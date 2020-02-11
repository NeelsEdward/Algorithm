package algorithm;

import java.util.ArrayList;
import java.util.Map;

public class MagicSuduko {

	public static void main(String[] args) {

//		int[][] input1 = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	/*	int[][] input1 = { { 1, 0, 0, 0 }, 
						   { 0, 0, 2, 0 },
						   { 0, 3, 5, 0 },
						   { 0, 0, 0, 4 } };*/

		int[][] input1 = { { 1, 2, 3, 0, 0, 0, 0, 0, 0 }, 
						   { 0, 0, 0, 0, 0, 0, 1, 2, 3 }, 
						   { 0, 0, 0, 1, 2, 3, 0, 0, 0 },
						   { 2, 3, 1, 0, 0, 0, 0, 0, 0 },
						   { 0, 0, 0, 0, 0, 0, 2, 3, 1 },
						   { 0, 0, 0, 2, 3, 1, 0, 0, 0 },
						   { 3, 2, 1, 0, 0, 0, 0, 0, 0 },
						   { 0, 0, 0, 0, 0, 0, 3, 2, 1 },
						   { 0, 0, 0, 3, 2, 1, 0, 0, 0 },};

		System.out.println(SolveMagicSquare(input1));
	}

	public static int SolveMagicSquare(int[][] input1) {
		int count = 1;
		int length = input1.length;
		int smallCellLength = (int) Math.sqrt(length);
		boolean isValid = true;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (input1[i][j] != 0) {
					isValid = false;
					break;
				}
			}
			if (!isValid) {
				break;
			}
		}
		if (isValid) {
			return 1;
		}

		int row = 0;
		while (row < length) {
			int col = 0;
			while (col < length) {
				int rowF = row;
				int colF = col;
				
				while(rowF < row + smallCellLength && colF < col + smallCellLength){
					int element = input1[rowF][colF];
						boolean isDuplicate = false;
						for (int rowBackward = rowF - 1; rowBackward >= 0 && rowBackward >= row; rowBackward--) {
							if (element != 0 && element == input1[rowBackward][colF]) {
								isDuplicate = true;
							}
						}
						if (!isDuplicate) {
							for (int rowForward = rowF + 1;rowForward < row+smallCellLength && rowForward<length; rowForward++) {
								if (element != 0 && element == input1[rowForward][colF]) {
									isDuplicate = true;
								}
							}
						}
						if (!isDuplicate) {
							for (int colBackward = colF - 1; colBackward >= 0 && colBackward >= col; colBackward--) {
								if (element != 0 && element == input1[rowF][colBackward]) {
									isDuplicate = true;
								}
							}
						}
						if (!isDuplicate) {
							for (int colForward = colF + 1;colForward < col+smallCellLength && colForward <length; colForward++) {
								if (element != 0 && element == input1[rowF][colForward]) {
									isDuplicate = true;
								}
							}
						}
						if(isDuplicate){
							count = 0;
							return count;
						}
					rowF++;
					colF++;
				}
				col = col + smallCellLength;
			}
			row = row + smallCellLength;
		}

		return count;
	}
}
