package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import io.rtdi.appcontainer.plugins.activation.parser.CommandParser;
import io.rtdi.appcontainer.plugins.activation.parser.CommentParser;
import io.rtdi.appcontainer.plugins.activation.parser.NullParser;
import io.rtdi.appcontainer.plugins.activation.parser.ParserCharSequence;
import io.rtdi.appcontainer.plugins.database.IActivationService;
import io.rtdi.appcontainer.plugins.database.ICatalogService;

public class SQLParser extends ParserCharSequence implements IActivationService {
	
	protected SQLParser() {
		super(null);
	}
	
	@Override
	public ActivationResult activate(
			File file,
			Connection conn,
			GlobalSchemaMapping gm,
			SQLVariables variables,
			ICatalogService catalogservice) throws IOException, SQLException {
		SQLParserContext ctx = new SQLParserContext();
		ctx.setGlobalSchemaMapping(gm);
		ctx.setVariables(variables);
		ctx.setConnection(conn);
		ctx.setFile(file);
		ctx.setCatalogService(catalogservice);
		ActivationResult result = new ActivationResult(file.toPath(), "Parsing file");
		try (Reader reader = new FileReader(file);) {
			read(new StringBuilder(), reader, ctx, result);
			ctx.getConnection().commit();
		} catch (ActivationException e) {
			result.addResult(file.toPath(), "Unrecoverable activation error: " + e.getMessage(), null, ActivationSuccess.FAILED);
		}
		return result;
	}

	@Override
	protected boolean isParsingComplete(Character c, SQLParserContext ctx) {
		return false;
	}

	@Override
	protected void fireChildParserCompleted(StringBuilder sb, IParser parser, SQLParserContext ctx, ActivationResult result) {
		if (parser instanceof CommandParser) {
			try (PreparedStatement stmt = ctx.getConnection().prepareStatement(sb.toString());) {
				stmt.execute();
				result.addResult(ctx.getFile().toPath(), "Executed sucessfully", sb.toString(), ActivationSuccess.SUCCESS);
			} catch (SQLException e) {
				result.addResult(ctx.getFile().toPath(), "Execution failed with \"" + e.getMessage() + "\"", sb.toString(), ActivationSuccess.FAILED);
			}
		}
	}

	@Override
	public void setParsers() {
		addChildParser('\r', new NullParser());
		addChildParser('\n', new NullParser());
		addChildParser('\t', new NullParser());
		addChildParser(' ',  new NullParser());
		addChildParser('/',  new CommentParser(this));
		setDefaultParser(new CommandParser(this));
	}

}
