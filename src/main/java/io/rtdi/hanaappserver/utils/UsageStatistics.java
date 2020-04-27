package io.rtdi.hanaappserver.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.rtdi.hanaappcontainer.HanaRepoServlet;
import io.rtdi.hanaappserver.rest.HanaStoredProcedure;
import io.rtdi.hanaappserver.rest.odata.hanatable.ODataCollectionProcessor;

public class UsageStatistics {

	private List<Connection> connections;
	private long starttime;
	private long endtime;

	public UsageStatistics() {
		connections = Collections.singletonList(new Connection());
		starttime = System.currentTimeMillis();
	}

	public String getConnectorname() {
		return "HanaAppContainer";
	}

	public List<Connection> getConnections() {
		return connections;
	}

	public long getStarttime() {
		return starttime;
	}

	public long getEndtime() {
		return endtime;
	}

	public void update() {
		if (connections != null) {
			for ( Connection c : connections) {
				c.update();
			}
			starttime = endtime;
			endtime = System.currentTimeMillis();
		}
	}

	public static class Connection {

		private String connectionname;
		private List<Producer> producers;

		public Connection() {
			connectionname = System.getenv("HANAJDBCURL");
			producers = new ArrayList<>();
			producers.add(new Producer("HanaRepoServlet"));
			producers.add(new Producer("ODataCollection"));
			producers.add(new Producer("RestfulStoredProcedure"));
			update();
		}
		
		public String getConnectionname() {
			return connectionname;
		}

		public List<Producer> getProducers() {
			return producers;
		}

		public void update() {
			if (producers != null) {
				for ( Producer p : producers) {
					p.update();
				}
			}
		}

	}
	
	public static class Producer {

		private String producername;
		private List<ProducerInstance> instances;

		public Producer(String name) {
			this.producername = name;
			instances = Collections.singletonList(new ProducerInstance());
		}

		public String getProducername() {
			return producername;
		}

		public List<ProducerInstance> getInstances() {
			return instances;
		}

		public int getInstancecount() {
			if (instances != null) {
				return instances.size();
			} else {
				return 0;
			}
		}
		
		public void update() {
			if (instances != null) {
				ProducerInstance i = instances.get(0);
				switch (producername) {
				case "HanaRepoServlet":
					i.lastdatatimestamp = HanaRepoServlet.getLastProcessedtime();
					i.pollcalls = HanaRepoServlet.getInvocations() - i.pollcalls;
					break;
				case "ODataCollection":
					i.lastdatatimestamp = ODataCollectionProcessor.getLastProcessedtime();
					i.pollcalls = ODataCollectionProcessor.getInvocations() - i.pollcalls;
					break;
				case "RestfulStoredProcedure":
					i.lastdatatimestamp = HanaStoredProcedure.getLastProcessedtime();
					i.pollcalls = HanaStoredProcedure.getInvocations() - i.pollcalls;
					break;
				}
			}
		}

	}
	
	public static class ProducerInstance {

		private Long lastdatatimestamp;
		private int pollcalls;
		private String state;
		private long rowsproduced;

		public ProducerInstance() {
		}

		public Long getLastdatatimestamp() {
			return lastdatatimestamp;
		}

		public int getPollcalls() {
			return pollcalls;
		}

		public String getState() {
			return state;
		}

		public long getRowsproduced() {
			return rowsproduced;
		}

	}
	
}
