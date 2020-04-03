package io.rtdi.hanaappserver;

import java.util.ArrayList;
import java.util.List;

public class ActivationResult {

	private List<ActivationResult> children;
	private String sqltext;
	private String info;
	private ActivationSuccess success;
	private HanaObject object;

	public ActivationResult() {
	}
	
	public ActivationResult(String info, String sqltext, ActivationSuccess success, HanaObject object) {
		this.sqltext = sqltext;
		this.info = info;
		this.success = success;
		this.object = object;
	}
	
	public ActivationResult addResult(String info, String sqltext, ActivationSuccess success, HanaObject object) {
		if (children == null) {
			children = new ArrayList<>();
		}
		ActivationResult r = new ActivationResult(info, sqltext, success, object);
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

	public HanaObject getObject() {
		return object;
	}

	@Override
	public String toString() {
		return "ActivationResult [info=" + info + ", success=" + getSuccess() + ", object="
				+ object + ", children=" + children + "]";
	}
}
