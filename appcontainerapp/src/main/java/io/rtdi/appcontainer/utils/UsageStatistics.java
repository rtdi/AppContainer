package io.rtdi.appcontainer.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.rtdi.appcontainer.rest.RestService;

public class UsageStatistics {

	private List<Connection> connections;
	private long starttime;
	private long endtime;

	public UsageStatistics() {
		connections = Collections.singletonList(new Connection());
		starttime = System.currentTimeMillis();
	}

	public String getConnectorname() {
		return "AppContainer";
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
			connectionname = System.getenv("JDBCURL");
			producers = new ArrayList<>();
			producers.add(new Producer("Repo"));
			producers.add(new Producer("OData"));
			producers.add(new Producer("Rest"));
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
				case "Repo":
					i.lastdatatimestamp = RestService.getLastProcessedtimeRepo();
					i.setPollcalls(RestService.getInvocationsRepo());
					break;
				case "OData":
					i.lastdatatimestamp = RestService.getLastProcessedtimeOData();
					i.setPollcalls(RestService.getInvocationsOData());
					break;
				case "Rest":
					i.lastdatatimestamp = RestService.getLastProcessedtimeRest();
					i.setPollcalls(RestService.getInvocationsRest());
					break;
				}
			}
		}

	}
	
	public static class ProducerInstance {

		private Long lastdatatimestamp;
		private int pollcalls;
		private int pollcallslast;
		private String state;
		private long rowsproduced;

		public ProducerInstance() {
		}

		public void setPollcalls(int count) {
			pollcallslast = pollcalls;
			pollcalls = count;
		}

		public Long getLastdatatimestamp() {
			return lastdatatimestamp;
		}

		public int getPollcalls() {
			return pollcalls-pollcallslast;
		}

		public String getState() {
			return state;
		}

		public long getRowsproduced() {
			return rowsproduced;
		}

	}
	
}
