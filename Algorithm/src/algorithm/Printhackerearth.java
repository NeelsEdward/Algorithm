package algorithm;

import java.io.IOException;
import java.util.Scanner;

public class Printhackerearth {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String str = scanner.next();
        int charMap[] = new int[7];
        for(int i=0;i<N;i++){
        	char c = str.charAt(i);
        	if(c =='h'){
        		charMap[0]++;
        	}
        	if(c =='a'){
        		charMap[1]++;
        	}
        	if(c =='e'){
        		charMap[2]++;
        	}
        	if(c =='r'){
        		charMap[3]++;
        	}
        	if(c =='c'){
        		charMap[4]++;
        	}
        	if(c =='k'){
        		charMap[5]++;
        	}
        	if(c =='t'){
        		charMap[6]++;
        	}
        	
        }
        int count = 0;
        int c1 =0 ,c2 =0,c3 =0;
        if(charMap[0] % charMap[4] == 0 && charMap[1] % charMap[4] == 0 && charMap[2]% charMap[4] == 0){
        	c1 = charMap[0]/charMap[4];
        }
        if(charMap[0] % charMap[5] == 0 && charMap[1] % charMap[5] == 0 && charMap[2]% charMap[5] == 0){
        	c2 = charMap[0]/charMap[5];
        }
        if(charMap[0] % charMap[6] == 0 && charMap[1] % charMap[6] == 0 && charMap[2]% charMap[6] == 0){
        	c3 = charMap[0]/charMap[4];
        }
        if(c1 !=0 && c2 !=0 && c3 !=0){
        	if((c1 == c2) && (c2 == c3)){
        		count = c1/2;
        	}
        }
        System.out.println(count);
	}
}
