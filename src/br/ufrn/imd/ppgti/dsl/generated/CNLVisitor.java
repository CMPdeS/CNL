// Generated from D:/Dropbox/IMD/Mestrado Profissional/2020.2/Disciplinas/PPGTI1007 - LINGUAGENS DE DOMÍNIO ESPECÍFICO - T01/Projetos Atividades/code/CNL/src/br/ufrn/imd/ppgti/dsl\CNL.g4 by ANTLR 4.9.1
package br.ufrn.imd.ppgti.dsl.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CNLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CNLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CNLParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(CNLParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Attrib}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrib(CNLParser.AttribContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(CNLParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Method}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethod(CNLParser.MethodContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttribConcat}
	 * labeled alternative in {@link CNLParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribConcat(CNLParser.AttribConcatContext ctx);
	/**
	 * Visit a parse tree produced by {@link CNLParser#obj}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObj(CNLParser.ObjContext ctx);
	/**
	 * Visit a parse tree produced by {@link CNLParser#par}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPar(CNLParser.ParContext ctx);
	/**
	 * Visit a parse tree produced by {@link CNLParser#temporal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemporal(CNLParser.TemporalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CNLParser#lista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista(CNLParser.ListaContext ctx);
}