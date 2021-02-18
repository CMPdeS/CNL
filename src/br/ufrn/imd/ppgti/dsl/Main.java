package br.ufrn.imd.ppgti.dsl;

import br.ufrn.imd.ppgti.dsl.generated.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Iniciando");
        try {
            CharStream input;
            if (args.length > 0)
                input = CharStreams.fromFileName(args[0]);
            else
                input = CharStreams.fromStream(System.in);

            CNLLexer lexer = new CNLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CNLParser parser = new CNLParser(tokens);
            ParseTree tree = parser.start();

            // show tree in text form
            //System.out.println(tree.toStringTree(parser));

            ParseTreeWalker walker = new ParseTreeWalker();
            CNLTranslatorListener eval = new CNLTranslatorListener();
            walker.walk(eval, tree);
            System.out.println(eval.getValue(tree));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
