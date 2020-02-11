package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Playingwithdigits {
/*Determine the number of integers that are available from  to  (inclusive) and satisfy the following conditions:
Sum of its digits is equal to a prime number
Divisible by 
Input format
The first and only line contains three space-separated positive integers , , and .
Output format
Print a single integer that denotes the answer to this question.
Constraints
SAMPLE INPUT 
5 86 4
SAMPLE OUTPUT 
7
*/
	public static void main(String args[]) throws Exception {
	//Scanner s = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input[] = br.readLine().split(" "); 
	//String input[] = s.nextLine().split(" ");
		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);
		long K = Long.parseLong(input[2]);
		long answer = 0;
		long numerStart = A;
		for(long s=A;s<B;s++){
			if(s%K==0){
				numerStart = s;
				break;
			}
		}
		for(long n = numerStart ;n<=B;n=n+K){
			
			if(n%K==0){
				long sum = 0;
				long number = n;
				while(number > 0)
		        {
					long temp = number % 10;
		            sum = sum + temp;
		            number = number / 10;
		        }
		        boolean flag = false;
		        for(int i = 2; i <= sum/2; ++i)
		        {
		            // condition for nonprime number
		            if(sum % i == 0)
		            {
		                flag = true;
		                break;
		            }
		        }
		        if (!flag){
		        	answer++;
		        }
			}
		}
		System.out.println(answer);
		
}
	
}
