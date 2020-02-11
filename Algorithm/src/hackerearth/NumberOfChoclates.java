package hackerearth;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class NumberOfChoclates {
/*The number of chocolates that Alice is losing per day is . Whereas, the number of chocolates that Bob is gaining per day is . Currently, the number of chocolates that Alice and Bob contains is  and  respectively.

You are required to calculate the number of chocolates that Alice has when Bob does not contain any chocolates. 

Note

In any case, Alice always loses all the chocolates.
Input format

The first and only line contains four space-separated integers , , , and .

Output format

Print a single integer denoting the number of chocolates that Bob contains.

Note: It is guaranteed that the answer always exists.

Constraints


SAMPLE INPUT 
100 10 5 100
SAMPLE OUTPUT 
2010*/
	
	public static void main(String args[]) throws Exception {
		//Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" "); 
		//String input[] = s.nextLine().split(" ");
			long aliceChoclate = Long.parseLong(input[0]);
			long bobChoclate = Long.parseLong(input[1]);
			long aliceLoosePerDay = Long.parseLong(input[2]);
			long bobGainPerDat = Long.parseLong(input[3]);
			
			long totalDays = aliceChoclate/ aliceLoosePerDay;
			long bobTotalGain = bobChoclate + (bobGainPerDat * totalDays);
			System.out.println(bobTotalGain);
	}
}
