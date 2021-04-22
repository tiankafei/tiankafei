// Generated from E:/gits/tiankafei/tiankafei-code-tool/tiankafei-antlr4/src/main/java/org/tiankafei/antlr4/math\Math.g4 by ANTLR 4.9.1
package org.tiankafei.antlr4.math;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MathParser}.
 */
public interface MathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MathParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(MathParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MathParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(MathParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInfixExpr(MathParser.InfixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code infixExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInfixExpr(MathParser.InfixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(MathParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(MathParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(MathParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(MathParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(MathParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(MathParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParensExpr(MathParser.ParensExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parensExpr}
	 * labeled alternative in {@link MathParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParensExpr(MathParser.ParensExprContext ctx);
}