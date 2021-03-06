package br.ufrn.imd.ppgti.dsl;

import br.ufrn.imd.ppgti.dsl.generated.CNLBaseListener;
import br.ufrn.imd.ppgti.dsl.generated.CNLParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CNLTranslatorListener extends CNLBaseListener {
    private Map<String, ObjectType> variables = new HashMap<String, ObjectType>();
    private ParseTreeProperty<String> values = new ParseTreeProperty<String>();
    public void setValue(ParseTree node, String value) { values.put(node, value); }

    public String getValue(ParseTree node) {
        if(node == null)
            return "";
        String response = "";
        if(values.get(node)!=null)
            response = values.get(node);
        else {
            for (int i=0; i<=node.getChildCount();i++){
                ParseTree child = node.getChild(i);
                if(child != null) {
                    if (child.getText().equals(",")
                        ||  child.getText().equals("[")
                        ||  child.getText().equals("]"))
                        response += child.getText();
                    else if (!(child instanceof TerminalNode))
                        response += getValue(child);
                }
            }
        }
        return response;
    }

    @Override public void exitStart(CNLParser.StartContext ctx) {
        String response = initResponse();
        response += getValue(ctx);

        setValue(ctx, response);
    }

    private String initResponse() {
        String response =
                "import json\n"
                + "import cnl as cnl\n\r";
        return response;
    }

    @Override public void exitAttrib(CNLParser.AttribContext ctx) {
        String left = ctx.NOME().getText();
        String right = getValue(ctx.obj());
        if(right == null || right.isEmpty())
            right = getValue(ctx.lista());
        setValue(ctx, left + " = " + right +"\n");
        ObjectType type = ctx.lista()!=null?checkList(ctx.lista(), null):checkObj(ctx.obj(), null);
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
                left = getValue(obj);
                typeLeft = checkObj(obj, temp);
                validationMessages.addAll(temp);
            }else if(right == null){
                right = getValue(obj);
                typeRight = checkObj(obj, temp);
                validationMessages.addAll(temp);
            }
        }
        right = (right == null)?getValue(ctx.lista()):right;
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
            String retorno = getErrorLine(ctx, "Objeto inv�lido!");
            for(String message:validationMessages)
                retorno +=validationMessages;
            setValue(ctx, retorno);
        }
        String retorno = "";
        if(typeRight == ObjectType.LISTA || variables.get(right) == ObjectType.LISTA) {
            retorno += "cnl.checkAndAddList(" + left + ",\"" + typeRight.getSubtype().getDescription() + "\")\n";
            retorno += left + "[\"" + typeRight.getSubtype().getDescription() + "\"].extend(" + right + ")\n";
        }else{
            retorno += "cnl.checkAndAddList("+left+",\""+typeRight.getDescription()+"\")\n";
            retorno += left + "[\"" + typeRight.getDescription() + "\"].append(" + right + ")\n";
        }
        setValue(ctx, retorno);
    }

    private String getErrorLine(ParserRuleContext ctx, String error){
        return getErrorLine(ctx, error, false);
    }
    private String getErrorLine(ParserRuleContext ctx, String error, boolean detalhes) {
        return "\r\n[ERRO] LINHA " + ctx.start.getLine() + ": (" +
                (ctx.getText().length() < 10 ? ctx.getText() : ctx.getText().substring(0, 10)) + "...)" + error +"\n"
                + (detalhes?"[DETALHES]\n":"");
    }

    private ObjectType checkList(CNLParser.ListaContext lista, List<String> validationMessages) {
        validationMessages = new ArrayList<String>();
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
        String target = ctx.obj()!=null?getValue(ctx.obj()):ctx.NOME().getText();
        String date = ctx.DATA()!=null?",\""+ctx.DATA().getText()+"\"":"";
        if(date.isEmpty())
            date = ctx.DATAHORA()!=null?","+ctx.DATAHORA().getText():"";
        switch(method){
            case "print":
                method = "cnl.imprimir";
                break;
            default:
                method = "cnl."+method;
                break;
        }
        setValue(ctx, method + "(" + target + date + ")\n");
    }

    @Override public void exitObj(CNLParser.ObjContext ctx) {
        List<String> validationMessages = new ArrayList<String>();
        ObjectType type = checkObj(ctx,validationMessages);
        if(type == ObjectType.INVALIDO) {
            String retorno = getErrorLine(ctx, "Objeto inv�lido!");
            for(String message:validationMessages)
                retorno +=validationMessages;
            setValue(ctx, retorno);
            return;
        }
        if(ctx.COMORBIDADE()!=null)
            setValue(ctx, "\""+ctx.COMORBIDADE().getText()+"\"");
        else if (ctx instanceof CNLParser.ObjContext && ctx.getParent() instanceof CNLParser.ListaContext)
            setValue(ctx, "{"+ getValue(ctx) +"}");
        else
            setValue(ctx, "json.loads(\"\"\"{"+ getValue(ctx) +"}\"\"\")");
    }

    /**
     * Verifica se o obj � um Paciente, Exame, Sinal, Sintoma, Vacina ou Comorbidade.
     * Verifica se h� campos repetidos.
     * */
    private ObjectType checkObj(CNLParser.ObjContext ctx, List<String> validationMessages) {
        ObjectType retorno = ObjectType.INVALIDO;
        Map<String, Integer> controle = new HashMap<String, Integer>();
        validationMessages = new ArrayList<String>();
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
            if(controle.get(chave)>1)
                validationMessages.add("\t- Par repetido: "+chave+"\n");
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
            validationMessages.add("\t- Estrutura de dados incompat�vel com os tipos PACIENTE, SINTOMA, SINAL VITAL, EXAME, " +
                    "VACINA ou COMORBIDADE\n");
        if(isExame && isSorologia && !(hasIgg && hasIgm))
            validationMessages.add("\t- Exames do tipo SOROLOGIA precisam apresentar as leituras de IgG e IgM\n");
        return retorno;
    }

    @Override public void exitPar(CNLParser.ParContext ctx) {
        String left = "\""+ctx.getChild(0).getText()+"\"";
        String right = (ctx.getChild(2) instanceof TerminalNode)?"\""+ctx.getChild(2).getText()+"\"":getValue(ctx.getChild(2));
        right = right.replaceAll("\"\"", "\"");
        setValue(ctx, left + " : " + right +"\n");
    }

    @Override public void exitLista(CNLParser.ListaContext ctx) {
        List<String> validationMessages = new ArrayList<String>();
        ObjectType subtype = checkList(ctx, validationMessages);
        if(subtype == ObjectType.INVALIDO) {
            String retorno = getErrorLine(ctx, "Objeto inv�lido!");
            for(String message:validationMessages)
                retorno +=validationMessages;
            setValue(ctx, retorno);
            return;
        }
        String retorno = "[";
        for(ParseTree child:ctx.children){
            if(child instanceof CNLParser.ObjContext) {
                if(!retorno.equals("["))
                    retorno += ",";
                retorno += getValue(child);
            }
        }
        retorno += "]";
        setValue(ctx, retorno);
    }
}
