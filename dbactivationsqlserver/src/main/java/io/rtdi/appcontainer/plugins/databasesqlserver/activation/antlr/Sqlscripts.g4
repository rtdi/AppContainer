grammar Sqlscripts;
options { caseInsensitive = true; }

LINE_COMMENT_START: '//' ;
BLOCK_COMMENT_START: '/*' ;
BLOCK_COMMENT_END: '*/' ;
WS: [ \t\r\f]+ ;
NL: '\r\n' | '\n' ;
VARIABLE: ('&' [A-Z][A-Z_0-9]* ) ;
ALIAS: ('${' [A-Z][A-Z_0-9]* '}') ;

OBJECT: 'OBJECT' ;
COLUMN: 'COLUMN' ;
DECLARE: 'DECLARE' ;
BEGIN: 'BEGIN' ;
END: 'END' ;
IF: 'IF' ;
CASE: 'CASE' ;
FOR: 'FOR' ;
WHILE: 'WHILE' ;
LOOP: 'LOOP' ;
SEMI: ';' ;
NOT: 'NOT' ;
EXISTS: 'EXISTS' ;
SQ: '\'' ;
DQ: '"' ;
BQ: '`' ;
DOT: '.' ;
COMMA: ',' ;
WORD: ([A-Z_0-9!#$%&/+:<>=?*@{}|] 
  | ']' | '[' | '-' | [\u0080-\uFFFF])+ ;

ESC: '\\' . ;

blockcomment:
  BLOCK_COMMENT_START WS ~(BLOCK_COMMENT_END)* WS BLOCK_COMMENT_END WS? ;

alias: ALIAS ;

variable: VARIABLE;

squoted:
  SQ (alias | variable |
  ESC | ~(SQ))* SQ ;

dquoted:
  DQ (alias | variable |
  ESC | ~(DQ))* DQ ;

bquoted:
  BQ (alias | variable| ~(BQ))* BQ ;
  
identifier:
  (WORD | alias) (DOT (WORD | alias))* ;

directive:
  WS* directivecondition
  statement*
  directiveend ;

directivecondition:
  IF WS+
  (OBJECT | COLUMN ) WS+
  (NOT WS+)? EXISTS WS+
  identifier WS* NL;

directiveend:
  LINE_COMMENT_START WS* END WS+
  IF WS* ;

linecomment:
  LINE_COMMENT_START WS*
  (directive | ~( NL )* ) ;

beginblock:
  (declarestart statement*)?
  beginstart statement* beginend ;

declarestart:
  DECLARE (NL | WS)+;

beginstart:
  BEGIN (NL | WS)+;

beginend:
  END extra? ;


ifblock:
  ifstart statement* ifend ;

ifstart:
  IF (NL | WS)+;

ifend:
  END WS+ IF ;

caseblock:
  casestart inlinestatement* caseend ;

casestart:
  CASE (NL | WS)+;

caseend:
  END WS* ;


forblock:
  forstart statement* forend ;

forstart:
  FOR (NL | WS)+;

forend:
  END WS+ FOR ;

whileblock:
  whilestart statement* whileend ;

whilestart:
  WHILE (NL | WS)+;

whileend:
  END WS+ WHILE ;

loopblock:
  loopstart statement* loopend ;

loopstart:
  LOOP (NL | WS)+;

loopend:
  END WS+ LOOP ;
  
extra:
  (NL | WS)+;

semi:
  SEMI ;
  
text:
  WORD
  | OBJECT
  | COLUMN
  | NOT
  | EXISTS
  | WS+
  | COMMA
  ;

escapedchar:
  ESC ;

command:
  identifier
  | squoted 
  | dquoted
  | bquoted
  | paramclause
  | beginblock
  | ifblock
  | forblock
  | whileblock
  | loopblock
  | linecomment
  | blockcomment
  | variable
  | alias
  | extra
  | variable
  | escapedchar
  ;


commandblock:
  (text | command)* semi extra? ;

// A statement is semicolon terminated
statement : 
  linecomment (NL statement?)*
  | blockcomment
  | extra
  | commandblock;

// An inline statement is part of the SQL and not terminated with semi colon, e.g. "case when 1=1 then 5 end into :v1"
inlinestatement : 
  linecomment (NL statement?)*
  | blockcomment
  | extra
  | command;

paramclause:
  paramclausestart param_list paramclauseend ;

paramclausestart:
  '(' (NL | WS)*;

paramclauseend:
  ')'  (NL | WS)* ;

param_list:
  (text | command)* ;

script:
  statement* EOF;
