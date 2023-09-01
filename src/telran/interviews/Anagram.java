package telran.interviews;

import java.util.*;

public class Anagram {

	public static boolean isAnagram(String str, String anagram) {
		Map<Integer, Integer> map = new HashMap<>();

		str.chars().forEach(e -> map.merge(e, 1, Integer::sum));
		anagram.chars().forEach(e -> map.merge(e, -1, Integer::sum));
		return map.values().stream().allMatch(e -> e == 0);
		
	}
}