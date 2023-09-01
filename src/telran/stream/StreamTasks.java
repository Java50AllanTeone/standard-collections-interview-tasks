package telran.stream;

import java.util.*;
import java.util.stream.IntStream;


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

//	.mapToObj(Integer::toString)
//	.map(StreamTests::getArr)
//	.flatMapToInt(e -> e)
//	.boxed()
//	.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
//	.entrySet()
//	.stream()
//	.sorted((e1, e2) -> {
//		int res = Long.compare(e2.getValue(), e1.getValue());
//		return res == 0 ? e1.getKey() - e2.getKey() : res;
//	})
//	.forEach(e -> System.out.printf("%d: %d\n", e.getKey(), e.getValue()));
//}

	private static IntStream getArr(String num) {
		return num.chars().map(Character::getNumericValue);
	}

//void printDigitStatistics() {
//	StringBuilder sb = new StringBuilder();
//	
//	Arrays.stream(getNumbers())
//	.mapToObj(Integer::toString)
//	.forEach(e -> sb.append(e));
//	
//	sb.toString().chars()
//	.map(Character::getNumericValue)
//	.boxed()
//	.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
//	.entrySet()
//	.stream()
//	.sorted((e1, e2) -> {
//		int res = Long.compare(e2.getValue(), e1.getValue());
//		return res == 0 ? e1.getKey() - e2.getKey() : res;
//	})
//	.forEach(e -> System.out.printf("%d: %d\n", e.getKey(), e.getValue()));
//}
	
	static public void printSportLotoNumbers() {
		//prints random  6 unrepeated numbers from 1 to 49
		new Random().ints(1, 50).distinct().limit(6).forEach(n -> System.out.print(n + " "));
		
	}
	
	
	
}

