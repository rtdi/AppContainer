package io.rtdi.appcontainer.activationapp;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Feedback about the activated objects")
public class ActivationResult {

	private List<ActivationResult> children;
	private String sqltext;
	private String info;
	private ActivationSuccess success;

	public ActivationResult() {
	}
	
	public ActivationResult(String info, String sqltext, ActivationSuccess success) {
		this.sqltext = sqltext;
		this.info = info;
		this.success = success;
	}
	
	public ActivationResult addResult(String info, String sqltext, ActivationSuccess success) {
		if (children == null) {
			children = new ArrayList<>();
		}
		ActivationResult r = new ActivationResult(info, sqltext, success);
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
}
