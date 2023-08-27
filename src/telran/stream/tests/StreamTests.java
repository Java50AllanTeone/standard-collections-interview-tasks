package telran.stream.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
		Arrays.stream(strings)
		.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
		.entrySet()
		.stream()
		.sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			return res == 0 ? e1.getKey().compareTo(e2.getKey()) : res;
		})
		.forEach(e -> System.out.printf("\nKey %s, %s", e.getKey(), e.getValue()));
//		.forEach((k, v) -> System.out.printf("\nKey %s, %s", k, v));

	}
	
	@Test
	@Disabled
	void displayOccurencesTest() {
		String[] strings = {"lmn", "ab", "lmn", "ab", "a", "c", "a", "lmn"};
		displayOccurences(strings);
	}
	
	
	
	@Test
	void printDigitStatistics() {
		int[] numbers = getNumbers();
		
		
		Arrays.stream(numbers)
		.mapToObj(Integer::toString)
		.map(StreamTests::getArr)
		.flatMapToInt(Arrays::stream)
		.boxed()
		.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
		.entrySet()
		.stream()
		.sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			return res == 0 ? e1.getKey() - e2.getKey() : res;
		})
		.forEach(e -> System.out.printf("%d: %d\n", e.getKey(), e.getValue()));
		
		

		
		

	}
	
	void printDigitStatistics2() {
		int[] numbers = getNumbers();
		
		StringBuilder sb = new StringBuilder();
		
		Arrays.stream(numbers)
		.mapToObj(Integer::toString)
		.forEach(e -> sb.append(e));
		
		sb.toString().chars()
		.boxed()
		.collect(Collectors.groupingBy(e -> e, Collectors.counting()))
		.entrySet()
		.stream()
		.sorted((e1, e2) -> {
			int res = Long.compare(e2.getValue(), e1.getValue());
			return res == 0 ? e1.getKey() - e2.getKey() : res;
		})
		.forEach(e -> System.out.printf("%d: %d\n", e.getKey(), e.getValue()));
		
		
	}
	
	private static int[] getArr(String num) {
		return num.chars()				
		.map(Character::getNumericValue)
		.toArray();
	}
	
	private int[] getNumbers() {
		return new Random()
				.ints(1_000_000, 0, Integer.MAX_VALUE)
				.toArray();
	}

}
