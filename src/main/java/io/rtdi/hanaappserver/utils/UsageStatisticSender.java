package io.rtdi.hanaappserver.utils;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsageStatisticSender implements Runnable {

	private UsageStatistics data;
	private boolean success;
	private Invocation.Builder invocationBuilder;
	protected final Logger logger;
	private HttpUtil httputil;

	public UsageStatisticSender() {
		logger = LogManager.getLogger(this.getClass().getName());
		try {
			httputil = new HttpUtil();
			Client client = ClientBuilder.newBuilder().sslContext(httputil.getSSLContext()).hostnameVerifier(httputil.getHostnameVerifier()).build();
			WebTarget serviceroot = client.target("https://pw2djf8u01.execute-api.eu-central-1.amazonaws.com/Prod");
			WebTarget usageendpoint = serviceroot.path("usagedata");
			invocationBuilder = usageendpoint.request(MediaType.APPLICATION_JSON);
			data = new UsageStatistics();
		} catch (ProcessingException | IllegalArgumentException e) {
			logger.error("Failed to create the connection to the UsageServer URL", e);
		}
	}
	
	@Override
	public void run() {
		try {
		    success = false;
		    data.update();
			Response response = invocationBuilder.post(Entity.entity(data, MediaType.APPLICATION_JSON));
			if (response.getStatus() == 200) {
				String result = response.readEntity(String.class);
				success = "\"saved\"".equals(result);
				if (success) {
					logger.info("Sent the usage statistics data successfully");
				} else {
					logger.warn("Data to the UsageServer was sent but server returned \"{}\"", result);
				}
			}
		} catch (ProcessingException | IllegalArgumentException e) {
			logger.error("Failed to send the data to the UsageServer", e);
		}
	}
				
	public boolean isSuccess() {
		return success;
	}

}
