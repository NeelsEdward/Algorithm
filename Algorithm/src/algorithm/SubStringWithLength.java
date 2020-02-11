package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SubStringWithLength {

	public static void main(String[] args) {
		
		char[] c = {'0','1','2','3','4','5','6'};
		String prefix = "";
		int n = c.length;
		int k =3;
		int number = 5000;
		/*char ch = (char)Character.forDigit(number, 10);
		System.out.println(ch);*/
		int num[] = {5,34,78,1,45,1,99,23};
        printTwoMaxNumbers(num);
		
		
		ArrayList<String> listOfCombination  =new ArrayList<String>();
		printAllKLengthRec(c,prefix, n, k , listOfCombination);
		List<String> validCombinatin = new ArrayList<String>();
		for(int i=0;i<listOfCombination.size();i++){
			String str = listOfCombination.get(i);
			boolean isValid = true;
			for(int j=0;j<k;j++){
				for(int l=j+1;l<k;l++){
					if(str.charAt(j) == str.charAt(l)){
						isValid = false;
						break;
					}
				}
				if(!isValid){
					break;
				}
			}
			if(isValid){
				validCombinatin.add(str);
			}
		}
		System.out.println(validCombinatin);
	}
	
	
	public static void printTwoMaxNumbers(int[] a){
		int min1 = a[0];
        int min2 = a[1];
         if (min2 < min1)
         {
             min1 = a[1];
             min2 = a[0];
         }

         for (int i = 2; i < a.length; i++){
             if (a[i] < min1)
             {
                 min2 = min1;
                 min1 = a[i];
             }
             else if (a[i] < min2)
             {
                 min2 = a[i];
             }
         }
         System.out.println(min1+" "+min2);
    }
	static void printAllKLengthRec(char set[], String prefix, int n, int k ,ArrayList<String> listOfCombination) {
        
        if (k == 0) {
        	listOfCombination.add(prefix);
           // System.out.println(prefix);
            return;
        }
 
        for (int i = 0; i < n; ++i) {
             
            String newPrefix = prefix + set[i]; 
             
            printAllKLengthRec(set, newPrefix, n, k - 1 , listOfCombination); 
        }
    }
}
