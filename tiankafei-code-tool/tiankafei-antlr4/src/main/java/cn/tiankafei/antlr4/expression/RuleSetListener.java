// Generated from E:/gits/tiankafei/tiankafei-code-tool/tiankafei-antlr4/src/main/java/cn/tiankafei/antlr4/expression\RuleSet.g4 by ANTLR 4.8
package cn.tiankafei.antlr4.expression;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RuleSetParser}.
 */
public interface RuleSetListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link RuleSetParser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterProg(RuleSetParser.ProgContext ctx);

    /**
     * Exit a parse tree produced by {@link RuleSetParser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitProg(RuleSetParser.ProgContext ctx);

    /**
     * Enter a parse tree produced by the {@code eq}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void enterEq(RuleSetParser.EqContext ctx);

    /**
     * Exit a parse tree produced by the {@code eq}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void exitEq(RuleSetParser.EqContext ctx);

    /**
     * Enter a parse tree produced by the {@code lt}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void enterLt(RuleSetParser.LtContext ctx);

    /**
     * Exit a parse tree produced by the {@code lt}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void exitLt(RuleSetParser.LtContext ctx);

    /**
     * Enter a parse tree produced by the {@code le}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void enterLe(RuleSetParser.LeContext ctx);

    /**
     * Exit a parse tree produced by the {@code le}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void exitLe(RuleSetParser.LeContext ctx);

    /**
     * Enter a parse tree produced by the {@code gt}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void enterGt(RuleSetParser.GtContext ctx);

    /**
     * Exit a parse tree produced by the {@code gt}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void exitGt(RuleSetParser.GtContext ctx);

    /**
     * Enter a parse tree produced by the {@code ge}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void enterGe(RuleSetParser.GeContext ctx);

    /**
     * Exit a parse tree produced by the {@code ge}
     * labeled alternative in {@link RuleSetParser#stmt}.
     *
     * @param ctx the parse tree
     */
    void exitGe(RuleSetParser.GeContext ctx);

    /**
     * Enter a parse tree produced by the {@code parens}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterParens(RuleSetParser.ParensContext ctx);

    /**
     * Exit a parse tree produced by the {@code parens}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitParens(RuleSetParser.ParensContext ctx);

    /**
     * Enter a parse tree produced by the {@code MulDiv}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterMulDiv(RuleSetParser.MulDivContext ctx);

    /**
     * Exit a parse tree produced by the {@code MulDiv}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitMulDiv(RuleSetParser.MulDivContext ctx);

    /**
     * Enter a parse tree produced by the {@code AddSub}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterAddSub(RuleSetParser.AddSubContext ctx);

    /**
     * Exit a parse tree produced by the {@code AddSub}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitAddSub(RuleSetParser.AddSubContext ctx);

    /**
     * Enter a parse tree produced by the {@code int}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void enterInt(RuleSetParser.IntContext ctx);

    /**
     * Exit a parse tree produced by the {@code int}
     * labeled alternative in {@link RuleSetParser#expr}.
     *
     * @param ctx the parse tree
     */
    void exitInt(RuleSetParser.IntContext ctx);
}