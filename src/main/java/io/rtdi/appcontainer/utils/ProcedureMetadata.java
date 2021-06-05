package io.rtdi.appcontainer.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcedureMetadata {

	private Map<String, ProcedureParameter> parameters = new HashMap<>();
	private Map<Integer, ProcedureParameter> parameterindex = new HashMap<>();

	public void addParameter(ProcedureParameter parameter) {
		parameters.put(parameter.getParametername(), parameter);
		if (parameter.getIndex() > 0) {
			/*
			 * Do not add return parameters
			 */
			parameterindex.put(parameter.getIndex(), parameter);
		}
	}
	
	public ProcedureParameter getParameter(String name) {
		return parameters.get(name);
	}

	public ProcedureParameter getParameter(int index) {
		return parameterindex.get(index);
	}
	
	/**
	 * @return the list of parameters sorted by position
	 */
	public List<ProcedureParameter> getParameters() {
		List<ProcedureParameter> r = new ArrayList<>();
		for (int i=0; i<parameterindex.size(); i++) {
			r.add(parameterindex.get(i+1));
		}
		return r;
	}

	/**
	 * @return the list of out parameters in an arbitrary order
	 */
	public List<ProcedureParameter> getOutputParameters() {
		List<ProcedureParameter> r = new ArrayList<>();
		for (int i=0; i<parameterindex.size(); i++) {
			ProcedureParameter p = parameterindex.get(i+1);
			if (p.getInouttype() == ProcedureParameterInOutType.OUT) {
				r.add(p);
			}
		}
		return r;
	}

}