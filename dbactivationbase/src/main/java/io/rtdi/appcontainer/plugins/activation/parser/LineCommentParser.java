package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.rtdi.appcontainer.DatabaseObjectIdentifier;
import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.ActivationSuccess;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

/**
 * Line Comments can have the following directives or combinations of keywords
 * <UL><LI>if object exists MYTABLE</LI>
 * <LI>if object exists MYSCHEMA.MYTABLE</LI>
 * <LI>if object not exists MYSCHEMA.MYTABLE</LI>
 * <LI>if column exists MYSCHEMA.MYTABLE.COLUMN1</LI>
 * <LI>if column not exists MYSCHEMA.MYTABLE.COLUMN1</LI>
 * <LI>if column not exists MYTABLE.COLUMN1</LI>
 * <LI>if column not exists CURRENTSCHEMA.MYTABLE.COLUMN1</LI>
 * <LI>if column not exists ${schema1}.MYTABLE.COLUMN1</LI>
 * <LI>endif</LI>
 * </UL>
 * 
 * 
 * Identifiers can be either
 * <UL><LI>text: where the text does not contain a " or a . char</LI>
 * <LI>"text": double quoted text</LI>
 * <LI>${text}: a schema alias</LI>
 * </UL>
 */
public class LineCommentParser extends LineCommentInnerParser {
	private static final String ISCOMMAND = "^\\/ *if +.*";
    private static final Pattern ISCOMMANDPATTERN = Pattern.compile(ISCOMMAND);
    private static final String TYPE_PATTERN = "^\\/ *if +((object +)|(column +))(not +)?(exists +)(.*)";
    private static final Pattern COMMANDTYPEPATTERN = Pattern.compile(TYPE_PATTERN);
    /*
     * Each identifier might be followed by a . char as part of the pattern search.
     */

	public LineCommentParser(Parser parent) {
		super(parent);
	}

	@Override
	public void setParsers() {
	}

	@Override
	protected StringBuilder fireParserComplete(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws ActivationException, IOException, SQLException {
		String comment = sb.toString();
	    Matcher matcher = ISCOMMANDPATTERN.matcher(comment);
		if (matcher.find()) {
			// it is a directive, now we must figure out which
		    matcher = COMMANDTYPEPATTERN.matcher(comment);
		    if (matcher.find()) {
			    boolean testnotexists = (matcher.group(4) != null);
			    boolean objectexists = false;
			    String identifier = matcher.group(6);
			    String[] parts = identifier.split("\\.(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			    boolean skip = false;
			    if (matcher.group(2) != null) {
			    	// object
			    	String schema = null;
			    	String object = null;
			    	/*
			    	 * An object identifier can be either the object itself or schema.object
			    	 */
			    	try {
				    	if (parts.length == 1) {
				    		object = DatabaseObjectIdentifier.getObject(parts[0]);
				    	} else if (parts.length == 2) {
				    		schema = DatabaseObjectIdentifier.getSchema(parts[0], ctx.getGlobalSchemaMapping());
				    		object = DatabaseObjectIdentifier.getObject(parts[1]);
				    	} else {
							throw new ActivationException(
									String.format("The file \"%s\" contains a directive \"/%s\" for an object but it is not in the format [<schema>.]<object>",
											ctx.getFileName(), comment));
				    	}
			    	} catch (SQLException e) {
						throw new ActivationException(
								String.format("The file \"%s\" contains a directive based on an identifier, which is of invalid format",
										ctx.getFileName()));
			    	}
			    	objectexists = ctx.getCatalogService().objectExists(ctx.getConnection(), schema, object) != null;
			    } else if (matcher.group(3) != null) {
			    	// column
			    	String schema = null;
			    	String object = null;
			    	String column = null;
			    	/*
			    	 * An object identifier can be either the object itself or schema.object
			    	 */
			    	try {
				    	if (parts.length == 2) {
				    		object = DatabaseObjectIdentifier.getObject(parts[0]);
				    		column = DatabaseObjectIdentifier.getObject(parts[1]);
				    	} else if (parts.length == 3) {
				    		schema = DatabaseObjectIdentifier.getSchema(parts[0], ctx.getGlobalSchemaMapping());
				    		object = DatabaseObjectIdentifier.getObject(parts[1]);
				    		column = DatabaseObjectIdentifier.getObject(parts[2]);
				    	} else {
							throw new ActivationException(
									String.format("The file \"%s\" contains a directive \"/%s\" for a column but it is not in the format [<schema>.]<object>.<column>",
											ctx.getFileName(), comment));
				    	}
			    	} catch (SQLException e) {
						throw new ActivationException(
								String.format("The file \"%s\" contains a directive based on an identifier, which is of invalid format",
										ctx.getFileName()));
			    	}
			    	objectexists = ctx.getCatalogService().columnExists(ctx.getConnection(), schema, object, column);
			    } else {
					throw new ActivationException(
							String.format("The file \"%s\" contains a directive \"/%s\" but is not valid",
									ctx.getFileName(), comment));
			    }
		    	/*
		    	 * if exists       testnotexists   objectexists  -->  skip
		    	 *                 0               0                  1
		    	 *                 0               1                  0
		    	 * if not exists   1               0                  0
		    	 *                 1               1                  1
		    	 *                 
		    	 * !XOR(testnotexists, objectexists)
		    	 * 
		    	 * !XOR(a,b) = !((A AND !B) OR (!A AND B)) =
		    	 * = (!A OR B) AND (A OR !B)
		    	 */
		    	skip = (!testnotexists || objectexists) && (testnotexists || !objectexists);
		    	ActivationResult directive = result.addResult(ctx.getFile().toPath(), "Found a directive", "/" + comment, ActivationSuccess.SUCCESS);
				Parser nested = new NestedParser(this, getRootParser(), skip);
				return nested.read(getNewStringBuilder(), reader, ctx, directive);
					
		    } else {
				throw new ActivationException(
						String.format("The file \"%s\" contains a directive \"/%s\" but is not valid",
								ctx.getFileName(), comment));
		    }
		} else {
			return sb;
		}
	}

	private Parser getRootParser() {
		Parser p = this;
		while (p.getParent() != null) {
			p = p.getParent();
		}
		return p;
	}

}
