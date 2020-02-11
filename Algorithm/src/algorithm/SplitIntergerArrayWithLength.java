package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SplitIntergerArrayWithLength {

	public static void main(String[] args) {

		int input1 = 6;
		int input2 = 5;
		int input3 = 7;
		int input4 = 3;
		int input5_size_rows = 7;
		int input5_size_cols = 2;
		int input5[][] = { { 3, 4 }, { 3, 3 }, { 6, 1 }, { 1, 1 }, { 5, 5 }, { 5, 5 }, { 3, 1 } };
		int sum = homesteadThatDefinesANewLivingPlanet(input1, input2, input3, input4, input5_size_rows,
				input5_size_cols, input5);
		System.out.println(sum);
	}

	static void combinationUtil(int arr[], List<Integer> data, int start, int end, int index, int r,
			List<String> combination) {
		if (index == r) {
			String value = "";
			for (int j = 0; j < r; j++) {
				value += data.get(j) + "!";
			}
			combination.add(value);
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data.add(index, arr[i]);
			combinationUtil(arr, data, i + 1, end, index + 1, r, combination);
		}
	}

	static int homesteadThatDefinesANewLivingPlanet(int input1, int input2, int input3, int input4,
			int input5_size_rows, int input5_size_cols, int[][] input5) {

		int perimeter = 0;
		int col = input1 + 1;
		int row = input2 + 1;
		int minimumHubs = input4;
		int matrix[][] = new int[row][col];
		int dataIndex[] = new int[input5_size_rows];
		List<Integer> data = new ArrayList<Integer>();
		List<Integer> perimeterList = new ArrayList<Integer>();
		List<Integer> strIndexList = new ArrayList<Integer>();
		List<String> combination = new ArrayList<String>();
		List<String> removeRepition = new ArrayList<String>();
		int perimeter1 = 0;
		int perimeter2 = 0;
		for (int i = 0; i < input5_size_rows; i++) {
			int x = input5[i][0];
			int y = input5[i][1];
			matrix[y][x] = matrix[y][x] + 1;
		}
		for (int i = 0; i < dataIndex.length; i++) {
			dataIndex[i] = i;
		}
		combinationUtil(dataIndex, data, 0, dataIndex.length - 1, 0, minimumHubs, combination);

		for (int i = 0; i < combination.size(); i++) {

			String str = combination.get(i);
			String[] indexStr = str.split("!");
			int startIndex = 5000;
			int endIndex = -1;
			for (int j = 0; j < indexStr.length; j++) {
				int first = Integer.parseInt(indexStr[j]);
				for (int k = j + 1; k < indexStr.length; k++) {
					int second = Integer.parseInt(indexStr[k]);
					int x1 = input5[first][0];
					int y1 = input5[first][1];
					int x2 = input5[second][0];
					int y2 = input5[second][1];
					if (x1 == x2) {
						if (y1 < y2) {
							startIndex = first < startIndex ? first : startIndex;
							endIndex = second < endIndex ? endIndex : second;
						} else {
							startIndex = second < startIndex ? second : startIndex;
							;
							endIndex = first < endIndex ? endIndex : first;
						}
					} else if (x1 < x2) {
						startIndex = first < startIndex ? first : startIndex;
						endIndex = second < endIndex ? endIndex : second;
					} else {
						startIndex = second < startIndex ? second : startIndex;
						;
						endIndex = first < endIndex ? endIndex : first;
					}
				}
				String reptition = startIndex + "" + endIndex;
				if (!removeRepition.contains(reptition) && startIndex != endIndex) {
					removeRepition.add(reptition);

					int startX = input5[startIndex][0];
					int startY = input5[startIndex][1];
					int endX = input5[endIndex][0];
					int endY = input5[endIndex][1];
					int tempX = startX;
					if (startIndex > endX) {
						startIndex = endX;
						endX = tempX;
					}
					int tempY = startY;
					if (startY > endY) {
						startY = endY;
						endY = tempY;
					}
					int hubs = 0;
					for (int sx = startX; sx <= endX; sx++) {
						for (int sy = startY; sy <= endY; sy++) {
							hubs += matrix[sy][sx];
						}
					}
					if (hubs == minimumHubs) {
						perimeter = 2 * (Math.abs(startX - endX) + Math.abs(startY - endY) + 2);
						perimeterList.add(perimeter);
						strIndexList.add(i);
					}
				}
			}
		}
		if (perimeterList.size() > 2) {
			perimeter1 = Integer.MAX_VALUE;
			perimeter2 = Integer.MIN_VALUE;
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int m = 0; m < perimeterList.size(); m++) {
				String fStr = combination.get(strIndexList.get(m));
				String fStrarry[] = fStr.split("!");
				for (int n = m + 1; n < perimeterList.size(); n++) {

						String SecStr = combination.get(strIndexList.get(n));
						String SecStrarry[] = SecStr.split("!");
						boolean isValid = true;
						for (int p = 0; p < fStrarry.length; p++) {
							for (int q = 0; q < SecStrarry.length; q++) {
								if (fStrarry[p].equals(SecStrarry[q])) {
									isValid = false;
									break;
								}
							}
						}
						if (!isValid) {
							if(perimeterList.get(m) !=-1 && perimeterList.get(n) !=-1){
								int tempPeriMeter = perimeterList.get(m) > perimeterList.get(n) ? perimeterList.get(n)
										: perimeterList.get(m);
								list.add(tempPeriMeter);
								perimeterList.add(m,-1);
								perimeterList.remove(m+1);
								perimeterList.add(n,-1);
								perimeterList.remove(n+1);
							}
						} else {
							if(perimeterList.get(m) !=-1){
								list.add(perimeterList.get(m));
							}
							if(perimeterList.get(n) !=-1){
								list.add(perimeterList.get(n));
							}
						}
				}
			}
			Collections.sort(list);
			if (list.size() > 2) {
				perimeter = list.get(0) + list.get(1);
			}
		}
		return perimeter;
	}

}
