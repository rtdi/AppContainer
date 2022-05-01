package io.rtdi.appcontainer.plugins.database;

import java.util.ArrayList;
import java.util.List;

public class DatabaseObjectTree {
	private String schema;
	private String name;
	private String identifier;
	private String type;
	private String editorurl;
	private List<DatabaseObjectTree> children;
	
	/**
	 * For objects local to the current database catalog
	 * @param schema
	 * @param name
	 * @param type
	 */
	public DatabaseObjectTree(String schema, String name, String type) {
		this.schema = schema;
		this.name = name;
		this.type = type;
		this.identifier = '"' + schema + "\".\"" + name + '"';
	}

	/**
	 * For objects beyond the reach of the current catalog
	 * 
	 * @param identifier
	 * @param type
	 */
	public DatabaseObjectTree(String identifier, String type) {
		this.type = type;
		this.identifier = identifier;
	}

	/**
	 * @return "schema"."name" or a more detailed database identifier, e.g. catalog, remote database object name
	 */
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEditorurl() {
		return editorurl;
	}

	public void setEditorurl(String editorurl) {
		this.editorurl = editorurl;
	}

	public List<DatabaseObjectTree> getChildren() {
		return children;
	}

	public void setChildren(List<DatabaseObjectTree> children) {
		this.children = children;
	}

	/**
	 * @return schema name if the object is in the current catalog or null
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * @return object name if the object is in the current catalog or null
	 */
	public String getName() {
		return name;
	}

	public void addChild(DatabaseObjectTree child) {
		if (children == null) {
			children = new ArrayList<>();
		}
		children.add(child);
	}

}
