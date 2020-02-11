package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Tetris {

	public static void main(String[] args) {

		int[] input3 = { 1, 1, 1, 0, 0, 0, 0, 0, 0 };
		requiredTetriminos(3, 3, input3);
	}

	public static int requiredTetriminos(int input1, int input2, int[] input3) {

		int[][] matrix = new int[input2][input1];
		int index = 0;
		for (int i = 0; i < input2; i++) {
			for (int j = 0; j < input1; j++) {
				if (index < input3.length) {
					matrix[i][j] = input3[index];
					index++;
				}
			}
		}
		isValid(matrix);
		List<Titri> titris = new ArrayList<>();
		int[][] b1 = { { 0, 0 }, { 0, 1 }, { 0, 2 } };
		Titri t1 = new Titri(b1);
		int[][] b2 = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
		Titri t2 = new Titri(b2);
		int[][] b3 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } };
		Titri t3 = new Titri(b3);
		int[][] b4 = { { 0, 0 }, { 0, 1 }, { -1, 1 }, { -2, 1 } };
		Titri t4 = new Titri(b4);
		int[][] b5 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } };
		Titri t5 = new Titri(b5);
		int[][] b6 = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } };
		Titri t6 = new Titri(b6);
		int[][] b7 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } };
		Titri t7 = new Titri(b7);
		int[][] b8 = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } };
		Titri t8 = new Titri(b8);
		int[][] b9 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } };
		Titri t9 = new Titri(b9);
		int[][] b10 = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } };
		Titri t10 = new Titri(b10);
		int[][] b11 = { { 0, 0 }, { 0, 1 }, { -1, 1 }, { 1, 1 } };
		Titri t11 = new Titri(b11);
		int[][] b12 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 1 } };
		Titri t12 = new Titri(b12);
		int[][] b13 = { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } };
		Titri t13 = new Titri(b13);
		int[][] b14 = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } };
		Titri t14 = new Titri(b14);
		int[][] b15 = { { 0, 0 }, { 0, 1 }, { -1, 2 }, { -1, 1 } };
		Titri t15 = new Titri(b15);
		int[][] b16 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } };
		Titri t16 = new Titri(b16);
		int[][] b17 = { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 0, 1 } };
		Titri t17 = new Titri(b17);
		titris.add(t1);
		titris.add(t2);
		titris.add(t3);
		titris.add(t4);
		titris.add(t5);
		titris.add(t6);
		titris.add(t7);
		titris.add(t8);
		titris.add(t9);
		titris.add(t10);
		titris.add(t11);
		titris.add(t12);
		titris.add(t13);
		titris.add(t14);
		titris.add(t15);
		titris.add(t16);
		titris.add(t17);
		return 0;
	}

	static void cal(int matrix[][], List<Titri> titris, int count) {

		if (isValid(matrix)) {
			System.out.println("--> " + count);
		}

		for (int i = 0; i < titris.size(); i++) {
			Titri titri = titris.get(i);
			int titri_count = 0;
			for (int x = 0; x < titri.blocks.length; x++) {
				int col = titri.blocks[x][0];
				int row = titri.blocks[x][1];
				if (col >= 0 && col < matrix[0].length && row >= 0 && row < matrix.length) {
					titri_count++;
				}
			}
			if (titri_count == matrix.length) {
				for (int x = 0; x < titri.blocks.length; x++) {
					int col = titri.blocks[x][0];
					int row = titri.blocks[x][1];
					matrix[row][col] = 1;
				}
				count++;
			}
		}

	}

	static boolean isValid(int matrix[][]) {

		boolean check = true;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					check = false;
					break;
				}
			}
			if (!check) {
				break;
			}
		}

		return check;
	}

	static class Titri {
		int[][] blocks;

		public Titri(int[][] block) {
			blocks = block;
		}

	}
}
