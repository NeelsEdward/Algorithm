package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradingStudent {
/*HackerLand University has the following grading policy:

Every student receives a  in the inclusive range from 0 to 100.
Any  less than 40 is a failing grade.
Sam is a professor at the university and likes to round each student's  according to these rules:

If the difference between the grade and the next multiple 5 of  is less than 3 , round  up to the next multiple of 5 .
If the value of grade is less than 38, no rounding occurs as the result will still be a failing grade.
For example, grade 84  will be rounded to  85  but grade 29  will not be rounded because the rounding would result in a number that is less than 40.

Given the initial value of  for each of Sam's  students, write code to automate the rounding process.

Function Description

Complete the function gradingStudents in the editor below. It should return an integer array consisting of rounded grades.

gradingStudents has the following parameter(s):

grades: an array of integers representing grades before rounding
Input Format

The first line contains a single integer, , the number of students.
Each line  of the  subsequent lines contains a single integer, , denoting student 's grade.

Constraints

Output Format

For each , print the rounded grade on a new line.

Sample Input 0

4
73
67
38
33
Sample Output 0

75
67
40
33*/
	
	public static void main(String args[]) throws Exception {

		List<Integer> arry = gradSystem();
		for(int i=0;i<arry.size();i++){
			System.out.println(arry.get(i));
		}
	}

	public static List<Integer> gradSystem() {
		Scanner sc = new Scanner(System.in);
		int students = sc.nextInt();
		List<Integer> grades = null;
		List<Integer> list = new ArrayList<>();
		for (int s = 0; s < grades.size(); s++) {
			int grade = grades.get(s);
			if (grade < 38) {
				list.add(grade);
			} else {
				boolean isRoundOff = false;
				for (int g = 1; g <= 2; g++) {
					if (((grade + g) % 5 == 0)) {
						int gg = grade + g;
						list.add(gg);
						isRoundOff = true;
						break;
					}
				}
				if (!isRoundOff) {
					list.add(grade);
				}
			}

		}
		return list;

	}
}
