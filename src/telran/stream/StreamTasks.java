package telran.stream;

import java.util.*;


public class StreamTasks {
	public static void main(String[] args) {
		var cur = System.currentTimeMillis();		
		printDigitStatistics();
		System.out.println(System.currentTimeMillis() - cur);
	}

	
	static void printDigitStatistics() {
		int[] lookup = new int[10];
		
		new Random()
		.ints(10_000_000, 0, 10_000_000)
		.flatMap(e -> Integer.toString(e).chars())
		.forEach(e -> lookup[Character.getNumericValue(e)]++);
		
		TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
		
		for (int i = 0; i < lookup.length; i++)
			map.put(lookup[i], i);
		
		map
		.entrySet().stream().forEach(e -> System.out.printf("%d: %d\n", e.getValue(), e.getKey()));
	}
	
	
	
}

