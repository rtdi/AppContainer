package io.rtdi.appcontainer.plugins.activation;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Feedback about the activated objects")
public class ActivationResult {

	private List<ActivationResult> children;
	private ActivationResult parent;
	private String sqltext;
	private String info;
	private ActivationSuccess success;
	private java.nio.file.Path filepath;
	private static final ActivationResult EMPTY = new ActivationResult(Path.of("none"), "does not exist", null);
	private boolean skip = false;

	public ActivationResult() {
	}
	
	public ActivationResult(java.nio.file.Path filepath, String info) {
		this(filepath, info, null);
	}

	private ActivationResult(java.nio.file.Path filepath, String info, ActivationResult parent) {
		this.filepath = filepath;
		this.info = info;
		this.parent = parent;
	}
	
	public ActivationResult(java.nio.file.Path filepath, String info, String sqltext, ActivationSuccess success) {
		this(filepath, info, sqltext, success, null);
	}
	
	private ActivationResult(java.nio.file.Path filepath, String info, String sqltext, ActivationSuccess success, ActivationResult parent) {
		this(filepath, info, parent);
		this.sqltext = sqltext;
		this.success = success;
	}
	
	public static ActivationResult fromJson(String json) throws JsonMappingException, JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		return om.readValue(json, ActivationResult.class);
	}

	public ActivationResult addResult(String info, String sqltext, ActivationSuccess success) {
		return addResult(filepath, info, sqltext, success);
	}
	
	public ActivationResult addResult(java.nio.file.Path filepath, String info, String sqltext, ActivationSuccess success) {
		if (children == null) {
			children = new ArrayList<>();
		}
		ActivationResult r = new ActivationResult(filepath, info, sqltext, success, this);
		children.add(r);
		return r;
	}
	
	public List<ActivationResult> getChildren() {
		return children;
	}

	public String getSqltext() {
		return sqltext;
	}

	public String getInfo() {
		return info;
	}
	
	/**
	 * Helper class primarily useful for tests
	 * 
	 * @param path in the form of 0.1.5.7 to access the node's child at index 0, its child at index 1 etc 
	 * @return the child activation result or an empty ActivationResult in case the path leads to a non-existing child
	 */
	@JsonIgnore
	public ActivationResult getByPath(String path) {
		if (path == null) {
			return this;
		}
		String[] parts = path.split("\\.");
		if (parts.length == 0) {
			return this;
		} else {
			int i = 0;
			ActivationResult current = this;
			while (i < parts.length) {
				int index = Integer.valueOf(parts[i]);
				if (current.getChildren() != null && index < current.getChildren().size()) {
					current = current.getChildren().get(index);
				} else {
					return EMPTY;
				}
				i++;
			}
			return current;
		}
		
	}

	public ActivationSuccess getSuccess() {
		if (success == ActivationSuccess.FAILED) {
			return ActivationSuccess.FAILED;
		} else if (children != null) {
			for (ActivationResult c : children) {
				ActivationSuccess s = c.getSuccess();
				success = ActivationSuccess.aggregate(success, s);
				if (success == ActivationSuccess.FAILED) {
					return ActivationSuccess.FAILED;
				}
			}
		}
		return success;
	}

	@Override
	public String toString() {
		return "ActivationResult [info=" + info + ", success=" + getSuccess() + ", children=" + children + "]";
	}

	public void setActivationSuccess(ActivationSuccess success) {
		this.success = success;
	}

	/**
	 * @param childresult the result to add, if null nothing is added
	 */
	public void add(ActivationResult childresult) {
		if (childresult != null) {
			if (children == null) {
				children = new ArrayList<>();
			}
			children.add(childresult);
			childresult.parent = this;
		}
	}

	public java.nio.file.Path getFilePath() {
		return filepath;
	}

	public void setFilePath(java.nio.file.Path filepath) {
		this.filepath = filepath;
	}
	
	@JsonIgnore
	public ActivationResult getParent() {
		return parent;
	}
	
	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	public boolean isSkip() {
		if (skip) {
			return true;
		} else if (parent != null) {
			return parent.isSkip();
		} else {
			return false;
		}
	}

	public void setSqlText(String sql) {
		this.sqltext = sql;
	}

	public void setChildren(List<ActivationResult> children) {
		this.children = children;
	}

	public void setSqltext(String sqltext) {
		this.sqltext = sqltext;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setSuccess(ActivationSuccess success) {
		this.success = success;
	}
}
