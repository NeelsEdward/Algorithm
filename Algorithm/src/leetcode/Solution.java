package leetcode;

class Solution {
    public String convert(String s, int numRows) {
     

		int numRow = numRows -1;

		int max_gap = numRows / 2;
		int length = s.length();
		for (int i = 0; i <= numRow; i++) {

			if (i == 0 || i == (numRow)) {
				int index = i;
				while (index < length) {
					System.out.print(s.charAt(index));
					for (int g = 0; g < max_gap; g++) {
						System.out.print(" ");
					}
					index = index + (2 * (numRow));
				}
				System.out.println();
			} else {
				boolean isValid = true;
				int index = i;
				while (index < length) {
					if(isValid){
						isValid = false;
						int gap = numRow - i-1;
						System.out.print(s.charAt(index));
						for(int g=0;g<gap;g++){
							System.out.print(" ");
						}
						index = index + ((numRow-i)*2);
						
					}else{
						isValid = true;
						int gap = i-1;
						System.out.print(s.charAt(index));
						for(int g=0;g<gap;g++){
							System.out.print(" ");
						}
						index = index + (i*2);
					}
				}
				System.out.println();
			}
		}
	   return s;
    }
}   