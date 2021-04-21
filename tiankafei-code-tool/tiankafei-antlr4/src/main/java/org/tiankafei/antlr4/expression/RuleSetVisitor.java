// Generated from E:/gits/tiankafei/tiankafei-code-tool/tiankafei-antlr4/src/main/java/cn/tiankafei/antlr4/expression\RuleSet.g4 by ANTLR 4.8
package org.tiankafei.antlr4.expression;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RuleSetParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 *            operations with no return type.
 */
public interface RuleSetVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link RuleSetParser#prog}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitProg(RuleSetParser.ProgContext ctx);

    /**
     * Visit a parse tree produced by the {@code eq}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitEq(RuleSetParser.EqContext ctx);

    /**
     * Visit a parse tree produced by the {@code lt}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLt(RuleSetParser.LtContext ctx);

    /**
     * Visit a parse tree produced by the {@code le}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLe(RuleSetParser.LeContext ctx);

    /**
     * Visit a parse tree produced by the {@code gt}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGt(RuleSetParser.GtContext ctx);

    /**
     * Visit a parse tree produced by the {@code ge}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitGe(RuleSetParser.GeContext ctx);

    /**
     * Visit a parse tree produced by the {@code parens}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParens(RuleSetParser.ParensContext ctx);

    /**
     * Visit a parse tree produced by the {@code MulDiv}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitMulDiv(RuleSetParser.MulDivContext ctx);

    /**
     * Visit a parse tree produced by the {@code AddSub}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAddSub(RuleSetParser.AddSubContext ctx);

    /**
     * Visit a parse tree produced by the {@code int}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitInt(RuleSetParser.IntContext ctx);
}