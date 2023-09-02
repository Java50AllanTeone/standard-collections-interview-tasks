
package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionsPoolImpl implements ConnectionsPool {
	private int size;
	LinkedHashMap<Integer, Connection> map;
	

	public ConnectionsPoolImpl(int size) {
		super();
		this.size = size;
		map = new LinkedHashMap<>(size, 1, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Connection> map) {
				return false;
				
			}
		};
	}

	@Override
	public boolean addConnection(Connection connection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}