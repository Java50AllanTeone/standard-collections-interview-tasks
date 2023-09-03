package telran.interviews.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.interviews.*;
import java.util.stream.IntStream;

class ConnectionsPoolTests {
	ConnectionsPoolImpl con;
	
	@BeforeEach
	void init() {
		con = new ConnectionsPoolImpl(5);
		IntStream.range(1, 6).forEach(e -> con.addConnection(new Connection(e, Integer.toString(e), e)));
	}

	@Test
	void putTest() {
		Integer[] expected = {1, 2, 3, 4, 5};
		assertArrayEquals(expected, con.map.values().stream().map(e -> e.getId()).toArray());
		
		con.addConnection(new Connection(6, Integer.toString(6), 6));
		Integer[] expected1 = {2, 3, 4, 5, 6};
		assertArrayEquals(expected1, con.map.values().stream().map(e -> e.getId()).toArray());
	}
	
	@Test
	void getTest() {
		Integer[] expected = {2, 3, 4, 5, 1};
		con.getConnection(1);
		assertArrayEquals(expected, con.map.values().stream().map(e -> e.getId()).toArray());
		
		con.addConnection(new Connection(6, Integer.toString(6), 6));
		Integer[] expected1 = {3, 4, 5, 1, 6};
		assertArrayEquals(expected1, con.map.values().stream().map(e -> e.getId()).toArray());
		
	}

}
