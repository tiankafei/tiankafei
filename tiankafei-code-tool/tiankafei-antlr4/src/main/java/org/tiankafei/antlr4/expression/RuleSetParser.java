// Generated from E:/gits/tiankafei/tiankafei-code-tool/tiankafei-antlr4/src/main/java/cn/tiankafei/antlr4/expression\RuleSet.g4 by ANTLR 4.8
package org.tiankafei.antlr4.expression;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RuleSetParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, MUL = 8, DIV = 9,
            ADD = 10, SUB = 11, NEWLINE = 12, INT = 13, WS = 14;
    public static final int
            RULE_prog = 0, RULE_stmt = 1, RULE_expr = 2;

    private static String[] makeRuleNames() {
        return new String[]{
                "prog", "stmt", "expr"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'='", "'<'", "'<='", "'>'", "'>='", "'('", "')'", "'*'", "'/'",
                "'+'", "'-'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, null, null, null, null, null, null, "MUL", "DIV", "ADD",
                "SUB", "NEWLINE", "INT", "WS"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "RuleSet.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public RuleSetParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class ProgContext extends ParserRuleContext {
        public List<StmtContext> stmt() {
            return getRuleContexts(StmtContext.class);
        }

        public StmtContext stmt(int i) {
            return getRuleContext(StmtContext.class, i);
        }

        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitProg(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitProg(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(7);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(6);
                            stmt();
                        }
                    }
                    setState(9);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == T__5 || _la == INT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StmtContext extends ParserRuleContext {
        public StmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmt;
        }

        public StmtContext() {
        }

        public void copyFrom(StmtContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class LtContext extends StmtContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode NEWLINE() {
            return getToken(RuleSetParser.NEWLINE, 0);
        }

        public LtContext(StmtContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterLt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitLt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitLt(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class LeContext extends StmtContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode NEWLINE() {
            return getToken(RuleSetParser.NEWLINE, 0);
        }

        public LeContext(StmtContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterLe(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitLe(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitLe(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class EqContext extends StmtContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode NEWLINE() {
            return getToken(RuleSetParser.NEWLINE, 0);
        }

        public EqContext(StmtContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterEq(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitEq(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitEq(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class GtContext extends StmtContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode NEWLINE() {
            return getToken(RuleSetParser.NEWLINE, 0);
        }

        public GtContext(StmtContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterGt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitGt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitGt(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class GeContext extends StmtContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode NEWLINE() {
            return getToken(RuleSetParser.NEWLINE, 0);
        }

        public GeContext(StmtContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterGe(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitGe(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitGe(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_stmt);
        try {
            setState(36);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                case 1:
                    _localctx = new EqContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(11);
                    expr(0);
                    setState(12);
                    match(T__0);
                    setState(13);
                    expr(0);
                    setState(14);
                    match(NEWLINE);
                }
                break;
                case 2:
                    _localctx = new LtContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(16);
                    expr(0);
                    setState(17);
                    match(T__1);
                    setState(18);
                    expr(0);
                    setState(19);
                    match(NEWLINE);
                }
                break;
                case 3:
                    _localctx = new LeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(21);
                    expr(0);
                    setState(22);
                    match(T__2);
                    setState(23);
                    expr(0);
                    setState(24);
                    match(NEWLINE);
                }
                break;
                case 4:
                    _localctx = new GtContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(26);
                    expr(0);
                    setState(27);
                    match(T__3);
                    setState(28);
                    expr(0);
                    setState(29);
                    match(NEWLINE);
                }
                break;
                case 5:
                    _localctx = new GeContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(31);
                    expr(0);
                    setState(32);
                    match(T__4);
                    setState(33);
                    expr(0);
                    setState(34);
                    match(NEWLINE);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public ExprContext() {
        }

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class ParensContext extends ExprContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public ParensContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterParens(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitParens(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitParens(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class MulDivContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode MUL() {
            return getToken(RuleSetParser.MUL, 0);
        }

        public TerminalNode DIV() {
            return getToken(RuleSetParser.DIV, 0);
        }

        public MulDivContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterMulDiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitMulDiv(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitMulDiv(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class AddSubContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode ADD() {
            return getToken(RuleSetParser.ADD, 0);
        }

        public TerminalNode SUB() {
            return getToken(RuleSetParser.SUB, 0);
        }

        public AddSubContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterAddSub(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitAddSub(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitAddSub(this);
            else return visitor.visitChildren(this);
        }
    }

    public static class IntContext extends ExprContext {
        public TerminalNode INT() {
            return getToken(RuleSetParser.INT, 0);
        }

        public IntContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).enterInt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof RuleSetListener) ((RuleSetListener) listener).exitInt(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof RuleSetVisitor) return ((RuleSetVisitor<? extends T>) visitor).visitInt(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    private ExprContext expr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext(_ctx, _parentState);
        ExprContext _prevctx = _localctx;
        int _startState = 4;
        enterRecursionRule(_localctx, 4, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(44);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case INT: {
                        _localctx = new IntContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(39);
                        match(INT);
                    }
                    break;
                    case T__5: {
                        _localctx = new ParensContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(40);
                        match(T__5);
                        setState(41);
                        expr(0);
                        setState(42);
                        match(T__6);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(54);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(52);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 3, _ctx)) {
                                case 1: {
                                    _localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(46);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(47);
                                    ((MulDivContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == MUL || _la == DIV)) {
                                        ((MulDivContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(48);
                                    expr(5);
                                }
                                break;
                                case 2: {
                                    _localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(49);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(50);
                                    ((AddSubContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == ADD || _la == SUB)) {
                                        ((AddSubContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(51);
                                    expr(4);
                                }
                                break;
                            }
                        }
                    }
                    setState(56);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 4, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 2:
                return expr_sempred((ExprContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expr_sempred(ExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 4);
            case 1:
                return precpred(_ctx, 3);
        }
        return true;
    }

    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20<\4\2\t\2\4\3\t" +
                    "\3\4\4\t\4\3\2\6\2\n\n\2\r\2\16\2\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
                    "\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3" +
                    "\'\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4/\n\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\67" +
                    "\n\4\f\4\16\4:\13\4\3\4\2\3\6\5\2\4\6\2\4\3\2\n\13\3\2\f\r\2@\2\t\3\2" +
                    "\2\2\4&\3\2\2\2\6.\3\2\2\2\b\n\5\4\3\2\t\b\3\2\2\2\n\13\3\2\2\2\13\t\3" +
                    "\2\2\2\13\f\3\2\2\2\f\3\3\2\2\2\r\16\5\6\4\2\16\17\7\3\2\2\17\20\5\6\4" +
                    "\2\20\21\7\16\2\2\21\'\3\2\2\2\22\23\5\6\4\2\23\24\7\4\2\2\24\25\5\6\4" +
                    "\2\25\26\7\16\2\2\26\'\3\2\2\2\27\30\5\6\4\2\30\31\7\5\2\2\31\32\5\6\4" +
                    "\2\32\33\7\16\2\2\33\'\3\2\2\2\34\35\5\6\4\2\35\36\7\6\2\2\36\37\5\6\4" +
                    "\2\37 \7\16\2\2 \'\3\2\2\2!\"\5\6\4\2\"#\7\7\2\2#$\5\6\4\2$%\7\16\2\2" +
                    "%\'\3\2\2\2&\r\3\2\2\2&\22\3\2\2\2&\27\3\2\2\2&\34\3\2\2\2&!\3\2\2\2\'" +
                    "\5\3\2\2\2()\b\4\1\2)/\7\17\2\2*+\7\b\2\2+,\5\6\4\2,-\7\t\2\2-/\3\2\2" +
                    "\2.(\3\2\2\2.*\3\2\2\2/8\3\2\2\2\60\61\f\6\2\2\61\62\t\2\2\2\62\67\5\6" +
                    "\4\7\63\64\f\5\2\2\64\65\t\3\2\2\65\67\5\6\4\6\66\60\3\2\2\2\66\63\3\2" +
                    "\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29\7\3\2\2\2:8\3\2\2\2\7\13&.\66" +
                    "8";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}