
package telran.interviews;

import java.util.LinkedHashMap;
import java.util.Map;

public class ConnectionsPoolImpl implements ConnectionsPool {
	public int size;
	public LinkedHashMap<Integer, Connection> map;
	

	@SuppressWarnings("serial")
	public ConnectionsPoolImpl(int size) {
		super();
		this.size = size;
		map = new LinkedHashMap<>(size, 1, true) {
			@Override
			protected boolean removeEldestEntry(Map.Entry<Integer, Connection> map) {
				return size() > size;
			}
		};
	}

	@Override
	public boolean addConnection(Connection connection) {
		return map.putIfAbsent(connection.getId(), connection) == null;
	}

	@Override
	public Connection getConnection(int id) {
		return map.get(id);
	}

}