package telran.interviews;


public class ShootingRating {
	static final double RATE_FACTOR = 0.7;
	static final int RANGE = 10;
	

	public static int rateShooting(int[] hittingResults) {
		int[] lookup = new int[RANGE + 1];
		int border = (int) (hittingResults.length * (1 - RATE_FACTOR));
		int rate = 0;
		
		for (int hit : hittingResults) {
			lookup[hit]++;
		}
		
		for (int i = 0; i < lookup.length; i++) {
			while (lookup[i] > 0 && border > 0) {
				rate = i;
				lookup[i]--;
				border--;
			}
		}
		return rate;
	}
	
	public static void main(String[] args) {
		int[] hittingResults = {4,3,6,7,2,9,9,4,10,8};
		
		if (rateShooting(hittingResults) != 4) {
			System.out.println("Test failed");
			return;
		}
		System.out.println("Success");
	}
}