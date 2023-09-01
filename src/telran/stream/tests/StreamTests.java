package telran.stream.tests;

import static org.junit.jupiter.api.Assertions.*;


import java.util.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.stream.StreamTasks;

class StreamTests {

	private static final int N_GROUP_NUMBERS = 100;

	@Test
	@Disabled
	void test() {
		int[] ar = {1, 2, 3, 4};
		
		int sum = Arrays.stream(ar).sum();
		assertEquals(10, sum);
		
		sum = Arrays.stream(ar)
				.filter(n -> n % 2 == 0)
				.sum();
		
		assertEquals(6, sum);
		
	
		IntSummaryStatistics statistics = Arrays.stream(ar).summaryStatistics();
		System.out.println(statistics);
		
		boolean hasNumbersGreater10 = Arrays.stream(ar).anyMatch(a -> a > 10);
		System.out.println(hasNumbersGreater10);
		
		
		
	}
	
	@Test
	@Disabled
	void sumGroupsTest() {
		List<Integer> group1 = getRandomGroup(N_GROUP_NUMBERS);
		List<Integer> group2 = getRandomGroup(N_GROUP_NUMBERS);
		List<Integer> group3 = getRandomGroup(N_GROUP_NUMBERS);
		List<List<Integer>> groups = List.of(group1, group2, group3);
		System.out.println("Sum of group numbers is " + getGroupSum(groups));
	}

	private int getGroupSum(List<List<Integer>> groups) {	
		return groups.stream()
				.flatMap(List::stream)
				.mapToInt(n -> n)
				.sum();
	}

	private List<Integer> getRandomGroup(int nGroupNumbers) {	
		return new Random()
				.ints(nGroupNumbers, 1, 100)
				.boxed()
				.toList();
	}
	
	
	
	@Test
	@Disabled
	void charsStringTest() {
		"Hello World".chars().forEach(c -> System.out.printf("%c ", c));
	}
	
	private void displayOccurences(String[] strings) {
//		Arrays.stream(strings)
//		.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
//		.entrySet()
//		.stream()
//		.sorted((e1, e2) -> {
//			int res = Long.compare(e2.getValue(), e1.getValue());
//			return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
//		})
//		.forEach(e -> System.out.printf("\nKey %s, %s", e.getKey(), e.getValue()));
		
		Map<String, Integer> map = getMap(strings);
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
		});
		list.forEach(e -> System.out.printf("%s -> %s\n", e.getKey(), e.getValue()));


	}
	
	private Map<String, Integer> getMap(String[] strings) {
		Map< String, Integer> res = new HashMap<>();
		for (String str : strings) {
			res.merge(str, 1, Integer::sum);
		}
		return res;
	}

	@Test
//	@Disabled
	void displayOccurencesTest() {
		String[] strings = {"lmn", "ab", "lmn", "ab", "a", "c", "a", "lmn"};
		displayOccurences(strings);
	}

	
	

		
		@Test
		@Disabled
		void printSportLotoNumbersTest() {
			StreamTasks.printSportLotoNumbers();
		}
	
}
