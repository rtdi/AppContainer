package io.rtdi.appcontainer.plugins.activation;

import java.io.File;
import java.sql.Connection;

import io.rtdi.appcontainer.plugins.activation.parser.VariableParser;
import io.rtdi.appcontainer.plugins.database.ICatalogService;

public class SQLParserContext {
	private RingBuffer<Character> charbuffer = new RingBuffer<>(10);
	private GlobalSchemaMapping gm;
	private SQLVariables variables;
	private Connection conn;
	private File file;
	private ICatalogService catalogservice;
	/**
	 * There are cases where a Parser ends because a regular char was read, not because a termination char was present.<br>
	 * Examples:<br>
	 * {@link VariableParser}: ...(&var)...<br>
	 * Here the VariableParser reads v..a..r..) and figures because ) is not in its allows char range, the
	 * variable name is var. But the ) char is needed by parent BracketParser to know it terminated.
	 * Therefore the VariableParser sets this flag to true and the readChar() method presents the same char again, fetching it from the context 
	 * ring buffer.  
	 */
	private int wasreadahead = 0;

	public Character getChar(int relativeindex) {
		return charbuffer.get(relativeindex);
	}
	
	public void parserDidReadAhead() {
		wasreadahead++;
	}
	
	public Character getReadAheadChar() {
		if (wasreadahead > 0) {
			wasreadahead--;
			return getChar(0);
		} else {
			return null;
		}
	}

	public RingBuffer<Character> getCharBuffer() {
		return charbuffer;
	}
	
	public void push(Character c) {
		charbuffer.push(c);
	}

	public void setGlobalSchemaMapping(GlobalSchemaMapping gm) {
		this.gm = gm;
	}

	public void setVariables(SQLVariables variables) {
		this.variables = variables;
	}

	public SQLVariables getVariables() {
		return variables;
	}
	
	public GlobalSchemaMapping getGlobalSchemaMapping() {
		return gm;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public Connection getConnection() {
		return conn;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getFileName() {
		if (file != null) {
			return file.getName();
		} else {
			return null;
		}
	}

	public void setCatalogService(ICatalogService catalogservice) {
		this.catalogservice = catalogservice;
	}
	
	public ICatalogService getCatalogService() {
		return catalogservice;
	}

}
