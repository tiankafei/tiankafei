package cn.tiankafei.antlr4.expression;

public class EvalVisitor extends RuleSetBaseVisitor<Integer> {
    private boolean result = false;
    public boolean getResult() {
        return result;
    }
    public void setResult(boolean result) {
        this.result = result;
    }
    /** = */
    @Override
    public Integer visitEq(RuleSetParser.EqContext ctx) {
        // Integer result = visitChildren(ctx);
        RuleSetParser.ExprContext left = ctx.expr(0);
        RuleSetParser.ExprContext right = ctx.expr(1);
        int result = visit(left) - visit(right);
        if (result == 0) {
            this.setResult(true);
        } else {
            this.setResult(false);
        }
        return result;
    }
    /** <= */
    @Override
    public Integer visitLe(RuleSetParser.LeContext ctx) {
        // Integer result = visitChildren(ctx);
        RuleSetParser.ExprContext left = ctx.expr(0);
        RuleSetParser.ExprContext right = ctx.expr(1);
        int result = visit(left) - visit(right);
        if (result <= 0) {
            this.setResult(true);
        } else {
            this.setResult(false);
        }
        return result;
    }
    /** < */
    @Override
    public Integer visitLt(RuleSetParser.LtContext ctx) {
        RuleSetParser.ExprContext left = ctx.expr(0);
        RuleSetParser.ExprContext right = ctx.expr(1);
        int result = visit(left) - visit(right);
        if (result < 0) {
            this.setResult(true);
        } else {
            this.setResult(false);
        }
        return result;
    }
    /** >= */
    @Override
    public Integer visitGe(RuleSetParser.GeContext ctx) {
        RuleSetParser.ExprContext left = ctx.expr(0);
        RuleSetParser.ExprContext right = ctx.expr(1);
        int result = visit(left) - visit(right);
        if (result >= 0) {
            this.setResult(true);
        } else {
            this.setResult(false);
        }
        return result;
    }
    /** > */
    @Override
    public Integer visitGt(RuleSetParser.GtContext ctx) {
        RuleSetParser.ExprContext left = ctx.expr(0);
        RuleSetParser.ExprContext right = ctx.expr(1);
        int result = visit(left) - visit(right);
        if (result > 0) {
            this.setResult(true);
        } else {
            this.setResult(false);
        }
        return result;
    }
    /** INT */
    @Override
    public Integer visitInt(RuleSetParser.IntContext ctx) {
        return Integer.valueOf(ctx.INT().getText());
    }
    /** expr op=('*'|'/') expr */
    @Override
    public Integer visitMulDiv(RuleSetParser.MulDivContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getType() == RuleSetParser.MUL)
            return left * right;
        return left / right; // must be DIV
    }
    /** expr op=('+'|'-') expr */
    @Override
    public Integer visitAddSub(RuleSetParser.AddSubContext ctx) {
        int left = visit(ctx.expr(0)); // get value of left subexpression
        int right = visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getType() == RuleSetParser.ADD)
            return left + right;
        return left - right; // must be SUB
    }
    /** '(' expr ')' */
    @Override
    public Integer visitParens(RuleSetParser.ParensContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }
}