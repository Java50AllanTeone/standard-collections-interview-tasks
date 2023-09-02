package telran.interviews;

public class Connection {
	public int id;
	public String ipAddress;
	public int port;
	
	public Connection(int id, String ipAddress, int port) {
		this.id = id;
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	
	
	@Override
	public String toString() {
		return "Connection [id=" + id + ", ipAddress=" + ipAddress + ", port=" + port + "]";
	}



	public int getId() {
		return id;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}
	
	public int getPort() {
		return port;
	}

}