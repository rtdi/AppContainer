// Generated from java-escape by ANTLR 4.11.1
package io.rtdi.appcontainer.plugins.databasesnowflake.activation.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlscriptsParser}.
 */
public interface SqlscriptsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#blockcomment}.
	 * @param ctx the parse tree
	 */
	void enterBlockcomment(SqlscriptsParser.BlockcommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#blockcomment}.
	 * @param ctx the parse tree
	 */
	void exitBlockcomment(SqlscriptsParser.BlockcommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#alias}.
	 * @param ctx the parse tree
	 */
	void enterAlias(SqlscriptsParser.AliasContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#alias}.
	 * @param ctx the parse tree
	 */
	void exitAlias(SqlscriptsParser.AliasContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(SqlscriptsParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(SqlscriptsParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#squoted}.
	 * @param ctx the parse tree
	 */
	void enterSquoted(SqlscriptsParser.SquotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#squoted}.
	 * @param ctx the parse tree
	 */
	void exitSquoted(SqlscriptsParser.SquotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#dquoted}.
	 * @param ctx the parse tree
	 */
	void enterDquoted(SqlscriptsParser.DquotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#dquoted}.
	 * @param ctx the parse tree
	 */
	void exitDquoted(SqlscriptsParser.DquotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#bquoted}.
	 * @param ctx the parse tree
	 */
	void enterBquoted(SqlscriptsParser.BquotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#bquoted}.
	 * @param ctx the parse tree
	 */
	void exitBquoted(SqlscriptsParser.BquotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(SqlscriptsParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(SqlscriptsParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#directive}.
	 * @param ctx the parse tree
	 */
	void enterDirective(SqlscriptsParser.DirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#directive}.
	 * @param ctx the parse tree
	 */
	void exitDirective(SqlscriptsParser.DirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#directivecondition}.
	 * @param ctx the parse tree
	 */
	void enterDirectivecondition(SqlscriptsParser.DirectiveconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#directivecondition}.
	 * @param ctx the parse tree
	 */
	void exitDirectivecondition(SqlscriptsParser.DirectiveconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#directiveend}.
	 * @param ctx the parse tree
	 */
	void enterDirectiveend(SqlscriptsParser.DirectiveendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#directiveend}.
	 * @param ctx the parse tree
	 */
	void exitDirectiveend(SqlscriptsParser.DirectiveendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#linecomment}.
	 * @param ctx the parse tree
	 */
	void enterLinecomment(SqlscriptsParser.LinecommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#linecomment}.
	 * @param ctx the parse tree
	 */
	void exitLinecomment(SqlscriptsParser.LinecommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#beginblock}.
	 * @param ctx the parse tree
	 */
	void enterBeginblock(SqlscriptsParser.BeginblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#beginblock}.
	 * @param ctx the parse tree
	 */
	void exitBeginblock(SqlscriptsParser.BeginblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#declarestart}.
	 * @param ctx the parse tree
	 */
	void enterDeclarestart(SqlscriptsParser.DeclarestartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#declarestart}.
	 * @param ctx the parse tree
	 */
	void exitDeclarestart(SqlscriptsParser.DeclarestartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#beginstart}.
	 * @param ctx the parse tree
	 */
	void enterBeginstart(SqlscriptsParser.BeginstartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#beginstart}.
	 * @param ctx the parse tree
	 */
	void exitBeginstart(SqlscriptsParser.BeginstartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#beginend}.
	 * @param ctx the parse tree
	 */
	void enterBeginend(SqlscriptsParser.BeginendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#beginend}.
	 * @param ctx the parse tree
	 */
	void exitBeginend(SqlscriptsParser.BeginendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#ifblock}.
	 * @param ctx the parse tree
	 */
	void enterIfblock(SqlscriptsParser.IfblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#ifblock}.
	 * @param ctx the parse tree
	 */
	void exitIfblock(SqlscriptsParser.IfblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#ifstart}.
	 * @param ctx the parse tree
	 */
	void enterIfstart(SqlscriptsParser.IfstartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#ifstart}.
	 * @param ctx the parse tree
	 */
	void exitIfstart(SqlscriptsParser.IfstartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#ifend}.
	 * @param ctx the parse tree
	 */
	void enterIfend(SqlscriptsParser.IfendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#ifend}.
	 * @param ctx the parse tree
	 */
	void exitIfend(SqlscriptsParser.IfendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#forblock}.
	 * @param ctx the parse tree
	 */
	void enterForblock(SqlscriptsParser.ForblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#forblock}.
	 * @param ctx the parse tree
	 */
	void exitForblock(SqlscriptsParser.ForblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#forstart}.
	 * @param ctx the parse tree
	 */
	void enterForstart(SqlscriptsParser.ForstartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#forstart}.
	 * @param ctx the parse tree
	 */
	void exitForstart(SqlscriptsParser.ForstartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#forend}.
	 * @param ctx the parse tree
	 */
	void enterForend(SqlscriptsParser.ForendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#forend}.
	 * @param ctx the parse tree
	 */
	void exitForend(SqlscriptsParser.ForendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#whileblock}.
	 * @param ctx the parse tree
	 */
	void enterWhileblock(SqlscriptsParser.WhileblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#whileblock}.
	 * @param ctx the parse tree
	 */
	void exitWhileblock(SqlscriptsParser.WhileblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#whilestart}.
	 * @param ctx the parse tree
	 */
	void enterWhilestart(SqlscriptsParser.WhilestartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#whilestart}.
	 * @param ctx the parse tree
	 */
	void exitWhilestart(SqlscriptsParser.WhilestartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#whileend}.
	 * @param ctx the parse tree
	 */
	void enterWhileend(SqlscriptsParser.WhileendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#whileend}.
	 * @param ctx the parse tree
	 */
	void exitWhileend(SqlscriptsParser.WhileendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#loopblock}.
	 * @param ctx the parse tree
	 */
	void enterLoopblock(SqlscriptsParser.LoopblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#loopblock}.
	 * @param ctx the parse tree
	 */
	void exitLoopblock(SqlscriptsParser.LoopblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#loopstart}.
	 * @param ctx the parse tree
	 */
	void enterLoopstart(SqlscriptsParser.LoopstartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#loopstart}.
	 * @param ctx the parse tree
	 */
	void exitLoopstart(SqlscriptsParser.LoopstartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#loopend}.
	 * @param ctx the parse tree
	 */
	void enterLoopend(SqlscriptsParser.LoopendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#loopend}.
	 * @param ctx the parse tree
	 */
	void exitLoopend(SqlscriptsParser.LoopendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#dollarblock}.
	 * @param ctx the parse tree
	 */
	void enterDollarblock(SqlscriptsParser.DollarblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#dollarblock}.
	 * @param ctx the parse tree
	 */
	void exitDollarblock(SqlscriptsParser.DollarblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#extra}.
	 * @param ctx the parse tree
	 */
	void enterExtra(SqlscriptsParser.ExtraContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#extra}.
	 * @param ctx the parse tree
	 */
	void exitExtra(SqlscriptsParser.ExtraContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#semi}.
	 * @param ctx the parse tree
	 */
	void enterSemi(SqlscriptsParser.SemiContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#semi}.
	 * @param ctx the parse tree
	 */
	void exitSemi(SqlscriptsParser.SemiContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(SqlscriptsParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(SqlscriptsParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#escapedchar}.
	 * @param ctx the parse tree
	 */
	void enterEscapedchar(SqlscriptsParser.EscapedcharContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#escapedchar}.
	 * @param ctx the parse tree
	 */
	void exitEscapedchar(SqlscriptsParser.EscapedcharContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(SqlscriptsParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(SqlscriptsParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#commandblock}.
	 * @param ctx the parse tree
	 */
	void enterCommandblock(SqlscriptsParser.CommandblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#commandblock}.
	 * @param ctx the parse tree
	 */
	void exitCommandblock(SqlscriptsParser.CommandblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(SqlscriptsParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(SqlscriptsParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#paramclause}.
	 * @param ctx the parse tree
	 */
	void enterParamclause(SqlscriptsParser.ParamclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#paramclause}.
	 * @param ctx the parse tree
	 */
	void exitParamclause(SqlscriptsParser.ParamclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#paramclausestart}.
	 * @param ctx the parse tree
	 */
	void enterParamclausestart(SqlscriptsParser.ParamclausestartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#paramclausestart}.
	 * @param ctx the parse tree
	 */
	void exitParamclausestart(SqlscriptsParser.ParamclausestartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#paramclauseend}.
	 * @param ctx the parse tree
	 */
	void enterParamclauseend(SqlscriptsParser.ParamclauseendContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#paramclauseend}.
	 * @param ctx the parse tree
	 */
	void exitParamclauseend(SqlscriptsParser.ParamclauseendContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#param_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_list(SqlscriptsParser.Param_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#param_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_list(SqlscriptsParser.Param_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlscriptsParser#script}.
	 * @param ctx the parse tree
	 */
	void enterScript(SqlscriptsParser.ScriptContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlscriptsParser#script}.
	 * @param ctx the parse tree
	 */
	void exitScript(SqlscriptsParser.ScriptContext ctx);
}