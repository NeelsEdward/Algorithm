package vanhack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class StockMarketPredection {

	public static void main(String[] args) {

		List<Integer> stockData = Arrays.asList(89214, 26671, 75144, 32445, 13656, 66289, 21951, 10265, 59857, 59133,
				63227, 86121, 37411, 54628, 25859, 43510, 63756, 54763, 30852, 53243, 76238, 96885, 33074, 17745, 81814,
				43436, 79172, 92819, 30001, 68442, 54021, 35566, 95113, 29164, 84362, 25120, 11804, 6313, 51736, 71661,
				81797, 14962, 57781, 35560, 85941, 99991, 95421, 66048, 54754, 26272, 35642, 47343, 39508, 85068, 65087,
				21321, 28503, 60611, 30491, 58503, 29052, 84512, 94069, 40516, 13675, 78430, 65635, 25479, 1094, 17370,
				13491, 99243, 48683, 71271, 34802, 34624, 87613, 46574, 671, 42366, 89197, 36313, 89708, 28704, 21380,
				54795, 66376, 49882, 15405, 96867, 24737, 60808, 81378, 35157, 1324, 11404, 29938, 66958, 53234, 47384);
		List<Integer> queries = Arrays.asList(80, 24, 26, 62, 46, 79, 85, 59, 52, 8, 76, 48, 72, 84, 3, 3, 30, 30, 36,
				86, 96, 72, 93, 25, 28, 68, 81, 18, 78, 14, 1, 57, 90, 26, 18, 87, 56, 55, 97, 59, 62, 73, 58, 85, 8,
				60, 87, 89, 89, 22);
		// System.out.println(predict(stockData, queries));
		System.out.println("---------------");
		// System.out.println(predict1(stockData, queries));

		List<Integer> stockData1 = Arrays.asList(5, 6, 8, 4, 9, 10, 8, 3, 6, 4);
		List<Integer> queries1 = Arrays.asList(3, 1, 8);
		// System.out.println(predict(stockData, queries));
		System.out.println("---------------");
		System.out.println(predict1(stockData1, queries1));

	}

	private static List<Integer> predict(List<Integer> stockData, List<Integer> queries) {

		List<Integer> answer = new LinkedList<Integer>();
		for (int index = 0; index < queries.size(); index++) {

			if (stockData.size() == 1) {
				answer.add(-1);
			} else {
				Integer actualIndex = queries.get(index);
				Integer decrementIndex = queries.get(index) - 1;
				Integer givenStockPrice = stockData.get(decrementIndex);
				boolean isValid = ((stockData.size() - actualIndex) > actualIndex);
				int indexTillRead = -1;
				int answerIndex = Integer.MAX_VALUE;
				int count = 0;
				while (count < 2) {
					if (isValid) {
						isValid = false;
						int till = indexTillRead != -1 ? Math.abs(decrementIndex - (indexTillRead + 1)) : 0;
						for (int i = decrementIndex; i >= till; i--) {
							Integer sp = stockData.get(i);
							indexTillRead++;
							if (sp < givenStockPrice) {
								if (indexTillRead != -1) {
									answerIndex = (i + 1) > (indexTillRead + 1) ? (actualIndex + (indexTillRead + 1))
											: (i + 1);
								} else {
									if (i + 1 < answerIndex) {
										answerIndex = i + 1;
									}
								}
								break;
							}
						}
					} else {
						isValid = true;
						int till = indexTillRead != -1 ? (actualIndex + (indexTillRead + 1)) : stockData.size();
						for (int i = actualIndex; i < till; i++) {
							Integer sp = stockData.get(i);
							indexTillRead++;
							if (sp < givenStockPrice) {
								if (indexTillRead != -1) {
									answerIndex = (i + 1) > (indexTillRead + 1)
											? Math.abs(decrementIndex - (indexTillRead + 1)) : (i + 1);
								} else {
									if (i + 1 < answerIndex) {
										answerIndex = i + 1;
									}
								}
								break;
							}
						}

					}
					count++;
				}
				if (answerIndex == -1) {
					answer.add(-1);
				} else {
					answer.add(answerIndex);
				}

			}
		}

		return answer;
	}

	private static List<Integer> predict1(List<Integer> stockData, List<Integer> queries) {

		List<Integer> answer = new LinkedList<Integer>();
		Map<Integer, Integer> resultValid = new HashMap<Integer, Integer>();
		for (int index = 0; index < queries.size(); index++) {

			if (stockData.size() == 1) {
				answer.add(-1);
			} else {
				Integer actualIndex = queries.get(index);
				Integer decrementIndex = queries.get(index) - 1;
				Integer givenStockPrice = stockData.get(decrementIndex);
				Integer leftIndex = -1;
				Integer rightIndex = -1;
				int count = 0;
				boolean isValid = false;
				boolean isLeftFirst = (stockData.size() - actualIndex > actualIndex);
				if(!resultValid.isEmpty() && resultValid.containsKey(actualIndex)){
					answer.add(resultValid.get(actualIndex));
					continue;
				}
				while (count < 2) {
					int tillIndex = -1;
					if (isLeftFirst) {
						isLeftFirst = false;
						int elementIndex = tillIndex != -1 ? Math.abs(decrementIndex - tillIndex) : 0;

						if (elementIndex == 0) {
							for (int i = decrementIndex; i >= elementIndex; i--) {
								Integer sp = stockData.get(i);
								if (sp < givenStockPrice) {
									leftIndex = i + 1;
									isValid = true;
									tillIndex = i + 1;
									break;
								}
							}
						} else {
							int i = decrementIndex;
							while (elementIndex <= 0) {
								Integer sp = stockData.get(i);
								if (sp < givenStockPrice) {
									leftIndex = i + 1;
									isValid = true;
									tillIndex = i + 1;
									break;
								}
								i--;
								elementIndex--;
							}
						}
					} else {
						isLeftFirst = true;
						int elementIndex = tillIndex != -1 ? Math.abs(actualIndex + tillIndex) : stockData.size();
						for (int i = actualIndex; i < elementIndex; i++) {
							Integer sp = stockData.get(i);
							if (sp < givenStockPrice) {
								rightIndex = i + 1;
								isValid = true;
								break;
							}
						}

					}
					count++;
				}
				if (!isValid) {
					resultValid.put(actualIndex, -1);
					answer.add(-1);
				} else {
					Integer idx = -1;
					if (leftIndex != -1 && rightIndex != -1) {
						idx = actualIndex - leftIndex > rightIndex - actualIndex ? rightIndex : leftIndex;
					} else if (leftIndex != -1) {
						idx = leftIndex;
					} else if (rightIndex != -1) {
						idx = rightIndex;
					}
					answer.add(idx);
					resultValid.put(actualIndex, idx);
				}
			}
		}

		return answer;
	}

}
