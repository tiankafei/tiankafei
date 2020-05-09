grammar RuleSet;
prog:   stmt+ ;
stmt: expr '=' expr NEWLINE     #eq
    |expr '<' expr NEWLINE              #lt
    |expr '<=' expr NEWLINE             # le
    |expr '>' expr NEWLINE              # gt
    |expr '>=' expr NEWLINE             # ge
    ;
expr:   expr op=('*'|'/') expr      # MulDiv
        |   expr op=('+'|'-') expr          # AddSub
        |   INT                 # int
        |   '(' expr ')'                # parens
        ;
MUL :   '*' ;         // assigns token name to '*' used above in grammar
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
NEWLINE : [\r\n]+ ;
INT :   [0-9]+ ;         // match integers
WS  :   [ \t]+ -> skip ; // toss out whitespace