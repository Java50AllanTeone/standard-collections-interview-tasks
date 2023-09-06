package telran.interviews;

import java.util.Arrays;

public class InterviewTasks {
	
	public static void main(String[] args) {
		displayShuffled(new int[]{1, 2, 3, 4, 5});
	}
	
	
	public static void displayShuffled(int[] ar) {
		Arrays.stream(ar).parallel().forEach(System.out::println);
	}
	
	public static List<DateRole> rolesInDates(List<DateRole> datesRoles, List<LocalDate> dates) {
		
	}

}
