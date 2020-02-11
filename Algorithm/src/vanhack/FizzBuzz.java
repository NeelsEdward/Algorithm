package vanhack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		Result.fizzBuzz(n);

		bufferedReader.close();
	}
}

class Result {
	public static void fizzBuzz(int n) {

		for (int i = 1; i <= n; i++) {
			boolean isMultiple3 = false;
			boolean isMultiple5 = false;
			if (i >= 3 && i % 3 == 0) {
				isMultiple3 = true;
			}
			if (i >= 5 && i % 5 == 0) {
				isMultiple5 = true;
			}
			if (isMultiple3 && isMultiple5) {
				System.out.println("FizzBuzz");
			} else if (isMultiple3) {
				System.out.println("Fizz");
			} else if (isMultiple5) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

}
