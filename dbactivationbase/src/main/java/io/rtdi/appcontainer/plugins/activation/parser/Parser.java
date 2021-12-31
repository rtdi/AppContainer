package io.rtdi.appcontainer.plugins.activation.parser;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import io.rtdi.appcontainer.plugins.activation.ActivationException;
import io.rtdi.appcontainer.plugins.activation.ActivationResult;
import io.rtdi.appcontainer.plugins.activation.IParser;
import io.rtdi.appcontainer.plugins.activation.SQLParserContext;

public abstract class Parser implements IParser {

	private Map<Character, IParser> parsers;
	private Parser defaultparser;
	private Parser parent;

	protected Parser(Parser parent) {
		super();
		setParsers();
		this.parent = parent;
	}
	
	public Map<Character, IParser> getChildParsers() {
		return parsers;
	}

	public void addChildParser(Character c, IParser parser) {
		if (parsers == null) {
			parsers = new HashMap<>();
		}
		parsers.put(c, parser);
	}
	
	public void setChildParsers(Map<Character, IParser> parsers) {
		this.parsers = parsers;
	}

	public Parser getDefaultParser() {
		return defaultparser;
	}

	public void setDefaultParser(Parser defaultparser) {
		this.defaultparser = defaultparser;
	}

	protected void fireChildParserCompleted(StringBuilder sb, IParser parser, SQLParserContext ctx, ActivationResult result) {
	}
	
	protected StringBuilder fireParserComplete(StringBuilder sb, Reader reader, SQLParserContext ctx, ActivationResult result) throws ActivationException, IOException, SQLException {
		return sb;
	}

	/**
	 * All Parsers should use this method to read the next char from the reader to make sure the context is current
	 * 
	 * @param reader to take the next character from
	 * @param ctx the parser context with status information
	 * @return a character or null in case of EOF
	 * @throws IOException
	 */
	public Character readChar(Reader reader, SQLParserContext ctx) throws IOException {
		Character c = ctx.getReadAheadChar();
		if (c != null) {
			return c;
		}
		int r = reader.read();
		if (r != -1) {
			c = (char) r;
			ctx.push(c);
			return c;
		} else {
			return null;
		}
	}
	
	public abstract void setParsers();

	public Parser getParent() {
		return parent;
	}

	protected StringBuilder getNewStringBuilder() {
		return new StringBuilder();
	}
	
	protected StringBuilder getNewStringBuilder(Character c) {
		StringBuilder sb = new StringBuilder();
		if (c != null) {
			sb.append(c);
		}
		return sb;
	}
}
