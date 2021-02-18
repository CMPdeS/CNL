// Generated from D:/Dropbox/IMD/Mestrado Profissional/2020.2/Disciplinas/PPGTI1007 - LINGUAGENS DE DOMÍNIO ESPECÍFICO - T01/Projetos Atividades/code/CNL/src/br/ufrn/imd/ppgti/dsl\CNL.g4 by ANTLR 4.9.1
package br.ufrn.imd.ppgti.dsl.generated;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CNLParser}.
 */
public interface CNLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CNLParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(CNLParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CNLParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(CNLParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attrib}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterAttrib(CNLParser.AttribContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attrib}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitAttrib(CNLParser.AttribContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterConcat(CNLParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitConcat(CNLParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Method}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterMethod(CNLParser.MethodContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Method}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitMethod(CNLParser.MethodContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttribConcat}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterAttribConcat(CNLParser.AttribConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttribConcat}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitAttribConcat(CNLParser.AttribConcatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CNLParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(CNLParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link CNLParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(CNLParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link CNLParser#par}.
	 * @param ctx the parse tree
	 */
	void enterPar(CNLParser.ParContext ctx);
	/**
	 * Exit a parse tree produced by {@link CNLParser#par}.
	 * @param ctx the parse tree
	 */
	void exitPar(CNLParser.ParContext ctx);
	/**
	 * Enter a parse tree produced by {@link CNLParser#temporal}.
	 * @param ctx the parse tree
	 */
	void enterTemporal(CNLParser.TemporalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CNLParser#temporal}.
	 * @param ctx the parse tree
	 */
	void exitTemporal(CNLParser.TemporalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CNLParser#lista}.
	 * @param ctx the parse tree
	 */
	void enterLista(CNLParser.ListaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CNLParser#lista}.
	 * @param ctx the parse tree
	 */
	void exitLista(CNLParser.ListaContext ctx);
}