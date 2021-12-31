package io.rtdi.appcontainer.plugins.activation.parser;

/**
 * The line starts with a / char, so could be either a line comment or a block comment
 *
 */
public class CommentParser extends ParserSingleChar {
	
	public CommentParser(Parser parent) {
		super(parent);
	}

	@Override
	public String toString() {
		return "<comment>";
	}

	@Override
	public void setParsers() {
		addChildParser('/', new LineCommentParser(this));
		addChildParser('*', new BlockCommentParser(this));
	}

}
