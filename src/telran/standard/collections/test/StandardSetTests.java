package telran.standard.collections.test;
import static org.junit.Assert.*;

import java.util.*;

import org.junit.jupiter.api.Test;

public class StandardSetTests {
	
	Integer[] numbers = { 10, -7, 100, 13, 91, 5, 10, 11};
	
	@Test
	void distinctListTest() {
		Integer[] expected = {10, -7, 100, 13, 91, 5, 11};
		Integer[] actual = distinctList(List.of(numbers)).toArray(Integer[]::new);
		assertArrayEquals(expected, actual);
	}
	
	List<Integer> distinctList(List<Integer> listWithRepeated) {
		return new ArrayList<>(new LinkedHashSet<Integer>(listWithRepeated));
	}

}
