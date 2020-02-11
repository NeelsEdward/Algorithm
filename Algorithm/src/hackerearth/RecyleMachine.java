package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RecyleMachine {

	/*
	You have collected  empty plastic bottles around your location.
	A machine contains an infinite amount of water stored that accepts the empty plastic bottles and but in return, you get some plastic bottles that are filled with water. The machine works based on a rule which states that you get one plastic bottle that is filled with water for  empty plastic bottles.
	You require water for yourself, therefore, you can use as many empty bottles as you can to get water. You must use the collected amount of water instantly and repeat the recycling process.
	You are required to print the total number of bottles that are filled with water.
	Input format
	First line: A single integer  denoting the number of test cases
	Next  lines:  and  two space-separated integers
	Output format
	Print a single integer in the next  lines.

	SAMPLE INPUT 
	3
	22 3
	7 10
	101 5
	SAMPLE OUTPUT 
	10
	0
	25*/
	public static void main(String args[]) throws Exception {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		long testCases = s.nextInt(); // Reading input from STDIN
		for (int t = 0; t < testCases; t++) {
			long totalWaterBottled = s.nextLong();
			long requiredBottle = s.nextLong();
			long answer = 0;
			if (requiredBottle > totalWaterBottled) {
				System.out.println(answer);
			} else {
				long tempWaterbottled = totalWaterBottled;
				while (requiredBottle <= tempWaterbottled) {
					long filled = tempWaterbottled / requiredBottle;
					long left = tempWaterbottled % requiredBottle;
					answer += filled;
					tempWaterbottled = filled + left;
				}
				System.out.println(answer);
			}
		}
	}
}
