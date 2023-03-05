package io.rtdi.appcontainer.plugins.databasehana.activation.antlr;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.ActivationSuccess;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;
import io.rtdi.appcontainer.plugins.database.ObjectType;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.AliasContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.BeginendContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.BeginstartContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.BlockcommentContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.BquotedContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.CommandblockContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.DeclarestartContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.DirectiveContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.DirectiveconditionContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.DirectiveendContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.DquotedContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.ExtraContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.ForendContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.ForstartContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.IdentifierContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.IfendContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.IfstartContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.LinecommentContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.LoopendContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.LoopstartContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.ParamclauseendContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.ParamclausestartContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.ScriptContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.SemiContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.SquotedContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.StatementContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.TextContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.VariableContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.WhileendContext;
import io.rtdi.appcontainer.plugins.databasehana.activation.antlr.SqlscriptsParser.WhilestartContext;

public class SqlScriptsAntlrListener extends SqlscriptsBaseListener {
	
	private StringBuilder text = new StringBuilder();
	private SQLParserContext sqlctx;
	private ActivationResult result;
	private int commanddepth = 0;

	public SqlScriptsAntlrListener(SQLParserContext sqlctx) {
		this.sqlctx = sqlctx;
		result = new ActivationResult(sqlctx.getFile().toPath(), "Parsing file");
	}

	public ActivationResult getResult() {
		return result;
	}

	@Override
	public void enterBlockcomment(BlockcommentContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterVariable(VariableContext ctx) {
		String variablestr = ctx.getText();
		try {
			String variable = variablestr.substring(1);
			addText(sqlctx.getVariables().getValue(variable));
		} catch (SQLException e) {
			result.addResult("Variable name not found", variablestr, ActivationSuccess.FAILED);
		}
	}

	@Override
	public void enterSquoted(SquotedContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterDquoted(DquotedContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterBquoted(BquotedContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterIdentifier(IdentifierContext ctx) {
		for (int i=0; i<ctx.getChildCount(); i++) {
			ParseTree child = ctx.getChild(i);
			if (child instanceof AliasContext) {
				String aliasstr = child.getText();
				String alias = aliasstr.substring(2, aliasstr.length()-1);
				try {
					String actualname = sqlctx.getGlobalSchemaMapping().getActualSchemaFromMapping(alias);
					addText(actualname);
				} catch (ActivationException e) {
					addText(aliasstr);
					result.addResult("Alias not found in the globalmapping file", alias, ActivationSuccess.FAILED);
					result.setActivationSuccess(ActivationSuccess.FAILED);
				}
			} else {
				addText(child.getText());
			}
		}
	}

	@Override
	public void enterDirective(DirectiveContext ctx) {
		if (result.isSkip()) {
			result = result.addResult("Directive is skipped due to parent", ctx.getText(), ActivationSuccess.SUCCESS);
		} else {
			result = result.addResult("Evaluating directive", ctx.getText(), ActivationSuccess.SUCCESS);
		}
	}

	@Override
	public void exitDirective(DirectiveContext ctx) {
		result = result.getParent();
	}

	@Override
	public void enterDirectivecondition(DirectiveconditionContext ctx) {
		if (! result.isSkip()) {
			boolean iscolumn = ctx.getToken(SqlscriptsParser.COLUMN, 0) != null;
			boolean isnot = ctx.getToken(SqlscriptsParser.NOT, 0) != null;
			ParseTree identifier;
			if (isnot) {
				identifier = ctx.getChild(8);
			} else {
				identifier = ctx.getChild(6);
			}
			if (iscolumn) {
				try {
					if (identifier.getChildCount() != 5) {
						throw new SQLException("identifier for columns must be schema.object.column but is " + identifier.getText());
					}
					String schema = identifier.getChild(0).getText();
					String actualschema = sqlctx.getGlobalSchemaMapping().getActualSchema(schema);
					String objectname = identifier.getChild(2).getText();
					String columnname = identifier.getChild(4).getText();
					boolean exists = sqlctx.getCatalogService().columnExists(sqlctx.getConnection(), actualschema, objectname, columnname);
					result.setSkip(!(isnot ^ exists));
				} catch (SQLException e) {
					result.addResult("Failed to test if the column exists: " + e.getMessage(), ctx.getText() , ActivationSuccess.FAILED);
					result.setSkip(true);
				}
			} else {
				try {
					if (identifier.getChildCount() != 3) {
						throw new SQLException("identifier for objects must be schema.object but is " + identifier.getText());
					}
					String schema = identifier.getChild(0).getText();
					String objectname = identifier.getChild(2).getText();
					String actualschema = sqlctx.getGlobalSchemaMapping().getActualSchema(schema);
					ObjectType objecttype = sqlctx.getCatalogService().objectExists(sqlctx.getConnection(), actualschema, objectname);
					result.setSkip( isnot^(objecttype == null) );
				} catch (SQLException e) {
					result.addResult("Failed to test if the column exists: " + e.getMessage(), ctx.getText() , ActivationSuccess.FAILED);
					result.setSkip(true);
				}
			}
		}
	}

	@Override
	public void enterDirectiveend(DirectiveendContext ctx) {
	}

	@Override
	public void enterLinecomment(LinecommentContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterText(TextContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterStatement(StatementContext ctx) {
	}

	@Override
	public void enterScript(ScriptContext ctx) {
	}

	@Override
	public void visitTerminal(TerminalNode node) {
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
	}

	@Override
	public void enterExtra(ExtraContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterCommandblock(CommandblockContext ctx) {
		if (commanddepth == 0) {
			this.text = new StringBuilder();
			if (!result.isSkip()) {
				result = result.addResult("Executing command", null, null);
			}
		}
		commanddepth++;
	}

	@Override
	public void exitCommandblock(CommandblockContext ctx) {
		commanddepth--;
		if (commanddepth == 0) {
			if (!result.isSkip()) {
				String sql = text.toString();
				if (result.getSuccess() == null) {
					//execute
					try (PreparedStatement stmt = sqlctx.getConnection().prepareStatement(sql);) {
						stmt.execute();
						result.setActivationSuccess(ActivationSuccess.SUCCESS);
					} catch (SQLException e) {
						result.addResult("Activation failed with error: " + e.getMessage(), sql, ActivationSuccess.FAILED);
					}
				}
				result.setSqlText(sql);
				result = result.getParent();
			}
		}
	}
	
	@Override
	public void enterSemi(SemiContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterDeclarestart(DeclarestartContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterBeginstart(BeginstartContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterBeginend(BeginendContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterIfstart(IfstartContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterIfend(IfendContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterForstart(ForstartContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterForend(ForendContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterWhilestart(WhilestartContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterWhileend(WhileendContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterLoopstart(LoopstartContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterLoopend(LoopendContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterParamclausestart(ParamclausestartContext ctx) {
		addText(ctx);
	}

	@Override
	public void enterParamclauseend(ParamclauseendContext ctx) {
		addText(ctx);
	}

	private void addText(RuleContext ctx) {
		if (!result.isSkip()) {
			text.append(ctx.getText());
		}
	}

	private void addText(String str) {
		if (!result.isSkip()) {
			text.append(str);
		}
	}

}
