package io.rtdi.appcontainer.rest;

public class RestService {
	private static Long repo_lastprocessed;
	private static int repo_invocations;
	private static Long odata_lastprocessed;
	private static int odata_invocations;
	private static Long rest_lastprocessed;
	private static int rest_invocations;
	
	public static Long getLastProcessedtimeRepo() {
		return repo_lastprocessed;
	}
	
	public static int getInvocationsRepo() {
		return repo_invocations;
	}
	
	public static Long getLastProcessedtimeOData() {
		return odata_lastprocessed;
	}
	
	public static int getInvocationsOData() {
		return odata_invocations;
	}
	
	public static Long getLastProcessedtimeRest() {
		return rest_lastprocessed;
	}
	
	public static int getInvocationsRest() {
		return rest_invocations;
	}
	
	public void tickRepo() {
		repo_lastprocessed = System.currentTimeMillis();
		repo_invocations++;
	}

	public void tickOData() {
		odata_lastprocessed = System.currentTimeMillis();
		odata_invocations++;
	}

	public void tickRest() {
		rest_lastprocessed = System.currentTimeMillis();
		rest_invocations++;
	}

}
