package leetcode;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s1 = "PAYPALISHIRING";
		int num1 = 3;
		//System.out.println(convert(s1, num1));

		System.out.println("------------------------");

		int num2 = 4;
		//System.out.println(convert(s1, num2));
		
		System.out.println("------------------------");
		System.out.println(convert("AB", 1));
	}

	public static String convert(String s, int numRows) {

		if(s.length() == 1 || numRows ==1){
			return s;
		}
		StringBuilder builder = new StringBuilder();
		int numRow = numRows - 1;

		int max_gap = numRows / 2;
		int length = s.length();
		for (int i = 0; i <= numRow; i++) {

			if (i == 0 || i == (numRow)) {
				int index = i;
				while (index < length) {
					//System.out.print(s.charAt(index));
					builder.append(s.charAt(index));
					for (int g = 0; g < max_gap; g++) {
						// System.out.print(" ");
						//builder.append(" ");
					}
					index = index + (2 * (numRow));
				}
				// System.out.println();
				//builder.append("\n");
			} else {
				boolean isValid = true;
				int index = i;
				while (index < length) {
					if (isValid) {
						isValid = false;
						int gap = numRow - i - 1;
						// System.out.print(s.charAt(index));
						builder.append(s.charAt(index));
						for (int g = 0; g < gap; g++) {
							// System.out.print(" ");
							//builder.append(" ");
						}
						index = index + ((numRow - i) * 2);

					} else {
						isValid = true;
						int gap = i - 1;
						// System.out.print(s.charAt(index));
						builder.append(s.charAt(index));
						for (int g = 0; g < gap; g++) {
							// System.out.print(" ");
							//builder.append(" ");
						}
						index = index + (i * 2);
					}
				}
				// System.out.println();
				//builder.append("\n");
			}
		}
		return builder.toString();
	}
}
