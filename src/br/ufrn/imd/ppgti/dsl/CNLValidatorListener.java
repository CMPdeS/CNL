package br.ufrn.imd.ppgti.dsl;

import br.ufrn.imd.ppgti.dsl.generated.CNLBaseListener;
import br.ufrn.imd.ppgti.dsl.generated.CNLParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class CNLValidatorListener extends CNLBaseListener {
    private Map<String, ObjectType> variables = new HashMap<String, ObjectType>();
    private  List<String> errors = new ArrayList<String>();

    @Override public void exitAttrib(CNLParser.AttribContext ctx) {
        String left = ctx.NOME().getText();
        ObjectType type = ctx.lista()!=null?checkList(ctx.lista(), new ArrayList<String>()):checkObj(ctx.obj(), null);
        if(ctx.lista()!=null){
            ObjectType subtype = type;
            type = ObjectType.LISTA;
            type.setSubtype(subtype);
        }
        variables.put(left, type);
    }

    @Override public void exitConcat(CNLParser.ConcatContext ctx) {
        ObjectType typeLeft = ObjectType.INVALIDO, typeRight = ObjectType.INVALIDO;
        String left = null, right = null;
        List<String> validationMessages = new ArrayList<String>();
        List<String> temp =  new ArrayList<String>();
        for(TerminalNode nome:ctx.NOME()) {
            if(left == null) {
                left = nome.getText();
                typeLeft = variables.get(left);
            }else if(right == null){
                right = nome.getText();
                typeRight = variables.get(right);
            }
        }
        for(CNLParser.ObjContext obj:ctx.obj()) {
            if(left == null) {
                typeLeft = checkObj(obj, temp);
                validationMessages.addAll(temp);
            }else if(right == null){
                typeRight = checkObj(obj, temp);
                validationMessages.addAll(temp);
            }
        }
        if(ctx.lista()!=null) {
            ObjectType subtype =  checkList(ctx.lista(), temp);
            if(subtype != ObjectType.INVALIDO) {
                typeRight = ObjectType.LISTA;
                typeRight.setSubtype(subtype);
            }else
                typeRight = ObjectType.INVALIDO;
            validationMessages.addAll(temp);
        }
        if(typeLeft == null)
            typeLeft = ObjectType.INVALIDO;
        if(typeRight == null)
            typeRight = ObjectType.INVALIDO;
        if(typeLeft == ObjectType.INVALIDO || typeRight == ObjectType.INVALIDO) {
            String retorno = getErrorLine(ctx, "Objeto inválido!");
            for(String message:validationMessages)
                retorno +=message;
            errors.add(retorno);
        }
        if(typeLeft!=ObjectType.PACIENTE)
            errors.add(getErrorLine(ctx, "só é possível utilizar concatenações (+) se o membro à esquerda for um Paciente"));
        if(typeLeft==ObjectType.PACIENTE && typeRight == ObjectType.PACIENTE)
            errors.add(getErrorLine(ctx, "Um paciente não pode ser concatenado (+) com outro paciente"));
    }

    private String getErrorLine(ParserRuleContext ctx, String error){
        return getErrorLine(ctx, error, false);
    }
    private String getErrorLine(ParserRuleContext ctx, String error, boolean detalhes) {
        return "\r\n[ERRO] LINHA " + ctx.start.getLine() + ": (" +
                (ctx.getText().length() < 10 ? ctx.getText() : ctx.getText().substring(0, 10)) + "...)" + " " + error +"\n"
                + (detalhes?"[DETALHES]\n":"");
    }

    private ObjectType checkList(CNLParser.ListaContext lista, List<String> validationMessages) {
        //validationMessages = new ArrayList<String>();
        List<String> tmp = new ArrayList<String>();
        ObjectType current = null, last = null;
        for(ParseTree elem:lista.children){
            if(elem instanceof CNLParser.ObjContext) {
                CNLParser.ObjContext obj = (CNLParser.ObjContext) elem;
                if(current!=null)
                    last = current;
                current = checkObj(obj, tmp);
                validationMessages.addAll(tmp);
                if(last!=null && last != current) {
                    validationMessages.add(getErrorLine(obj, "uma Lista deve conter elementos do mesmo tipo!", false));
                    current = ObjectType.INVALIDO;
                }
            }
        }
        if(current==null)
            current = ObjectType.INVALIDO;
        return current;
    }

    @Override public void exitMethod(CNLParser.MethodContext ctx) {
        String method = ctx.FUNCAO().getText();
        List<String> methods = Arrays.asList(new String[]{"diagnosticar", "exame", "comorbidade", "sinaisvitais",
                "sintoma", "vacina", "print"});
        if(!methods.contains(method))
            errors.add(getErrorLine(ctx, method+": MÉTODO NÃO SUPORTADO."));
    }

    @Override public void exitObj(CNLParser.ObjContext ctx) {
        List<String> validationMessages = new ArrayList<String>();
        ObjectType type = checkObj(ctx,validationMessages);
        if(type == ObjectType.INVALIDO) {
            String retorno = getErrorLine(ctx, "Objeto inválido!");
            for(String message:validationMessages)
                retorno +=message;
            errors.add(retorno);
        }
    }

    /**
     * Verifica se o obj é um Paciente, Exame, Sinal, Sintoma, Vacina ou Comorbidade.
     * Verifica se há campos repetidos.
     * */
    private ObjectType checkObj(CNLParser.ObjContext ctx, List<String> validationMessages) {
        ObjectType retorno = ObjectType.INVALIDO;
        Map<String, Integer> controle = new HashMap<String, Integer>();
        //validationMessages = new ArrayList<String>();
        Integer count = null;
        boolean isPaciente, isExame, isSintoma, isSinal, isVacina, isComorbidade, hasIgg, hasIgm, isSorologia=false;
        for(ParseTree par:ctx.children) {
            if (par instanceof CNLParser.ParContext) {
                count = controle.get(((CNLParser.ParContext) par).getChild(0).getText());
                count = (count == null) ? 0 : count;
                controle.put(((CNLParser.ParContext) par).getChild(0).getText(), ++count);
                isSorologia = ((CNLParser.ParContext) par).getChild(2).getText().equals("SOROLOGIA");
            }
        }
        for(String chave:controle.keySet())
            if(controle.get(chave)>1) {
                validationMessages.add("\t- Par repetido: " + chave + "\n");
                retorno = ObjectType.INVALIDO;
                return retorno;
            }
        isPaciente = controle.keySet().contains("nome")
                && controle.keySet().contains("cpf")
                && controle.keySet().contains("nascimento");
        retorno = isPaciente?ObjectType.PACIENTE:retorno;
        isExame = controle.keySet().contains("tipo")
                && controle.keySet().contains("data")
                && controle.keySet().contains("resultado");
        retorno = isExame?ObjectType.EXAME:retorno;
        isSinal = controle.keySet().contains("tipo")
                && controle.keySet().contains("data")
                && controle.keySet().contains("leitura");
        retorno = isSinal?ObjectType.SINALVITAL:retorno;
        isVacina =  controle.keySet().contains("tipo")
                && controle.keySet().contains("data")
                && controle.keySet().contains("dose")
                && controle.keySet().contains("lote")
                && controle.keySet().contains("serial");
        retorno = isVacina?ObjectType.VACINA:retorno;
        isSintoma = controle.keySet().contains("tipo")
                && controle.keySet().contains("data") &&!isExame &&!isVacina &&!isSinal;
        retorno = isSintoma?ObjectType.SINTOMA:retorno;
        hasIgg = controle.keySet().contains("igg");
        hasIgm = controle.keySet().contains("igm");
        isComorbidade = ctx.COMORBIDADE() != null;
        retorno = isComorbidade?ObjectType.COMORBIDADE:retorno;
        if(!isPaciente && !isComorbidade && !isExame && !isVacina && !isSinal && !isSintoma)
            validationMessages.add("\t- Estrutura de dados incompatível com os tipos PACIENTE, SINTOMA, SINAL VITAL, EXAME, " +
                    "VACINA ou COMORBIDADE\n");
        if(isExame && isSorologia && !(hasIgg && hasIgm))
            validationMessages.add("\t- Exames do tipo SOROLOGIA precisam apresentar as leituras de IgG e IgM\n");
        return retorno;
    }

    @Override public void exitLista(CNLParser.ListaContext ctx) {
        List<String> validationMessages = new ArrayList<String>();
        ObjectType subtype = checkList(ctx, validationMessages);
        if(subtype == ObjectType.INVALIDO) {
            String retorno = getErrorLine(ctx, "Objeto inválido!");
            for(String message:validationMessages)
                retorno +=message;
            errors.add(retorno);
        }
    }

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<String> getErrors(){
        return errors;
    }
}
