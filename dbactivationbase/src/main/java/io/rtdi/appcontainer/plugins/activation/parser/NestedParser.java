package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.IOException;
import java.io.Reader;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.ActivationSuccess;
import io.rtdi.appcontainer.plugins.activation.IParser;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public class NestedParser extends ParserCharSequence {

	private boolean skip;

	public NestedParser(Parser parent, Parser inner, boolean skip) {
		super(parent);
		setChildParsers(inner.getChildParsers());
		setDefaultParser(inner.getDefaultParser());
		this.skip = skip;
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		/*
		 * end on: // endif
		 */
		if (ctx.getCharBuffer().size() > 8
				&& ctx.getChar(-7) == '/'
				&& ctx.getChar(-6) == '/'
				&& ctx.getChar(-5) == ' '
				&& ctx.getChar(-4) == 'e'
				&& ctx.getChar(-3) == 'n'
				&& ctx.getChar(-2) == 'd'
				&& ctx.getChar(-1) == 'i'
				&& ctx.getChar(-0) == 'f') {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "<nested>";
	}

	@Override
	protected void fireChildParserCompleted(StringBuilder sb, IParser parser, SQLParserContext ctx, ActivationResult result) {
		if (parser instanceof CommandParser) {
			if (isParentSkipped()) {
				result.addResult(ctx.getFile().toPath(), "Skipped due to parent directive", null, ActivationSuccess.SUCCESS);
			} else if (skip) {
				result.addResult(ctx.getFile().toPath(), "Skipped due to directive", sb.toString(), ActivationSuccess.SUCCESS);
			} else {
				try (PreparedStatement stmt = ctx.getConnection().prepareStatement(sb.toString());) {
					stmt.execute();
					result.addResult(ctx.getFile().toPath(), "Executed sucessfully", sb.toString(), ActivationSuccess.SUCCESS);
				} catch (SQLException e) {
					result.addResult(ctx.getFile().toPath(), "Execution failed with \"" + e.getMessage() + "\"", sb.toString(), ActivationSuccess.FAILED);
				}
			}
		}
	}

	/**
	 * Handle the situation where there is a parent directive which is skipped. Then the children must be skipped also.
	 * Happens only if directives are nested.
	 * 
	 * @return true if any of the parent is a NestedParser and is skipped
	 */
	private boolean isParentSkipped() {
		Parser p = this;
		while (p.getParent() != null) {
			p = p.getParent();
			if (p instanceof NestedParser) {
				if (((NestedParser) p).skip) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void setParsers() {
	}

	protected StringBuilder fireParserComplete(StringBuilder sb, Reader reader, SQLParserContext ctx) throws ActivationException, IOException {
		return new StringBuilder(); // The nested parser itself is complete, does nor return anything to the caller
	}

}
