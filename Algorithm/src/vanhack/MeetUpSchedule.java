package vanhack;

import java.util.Arrays;
import java.util.List;

public class MeetUpSchedule {

	public static void main(String[] args) {
		
		List<Integer> a1 = Arrays.asList(1,2,1,2,2);
		List<Integer> d1 = Arrays.asList(3,2,1,3,3);
		System.out.println(optimalPoint(a1, d1));
		System.out.println("---------------"+3);
		List<Integer> a2 = Arrays.asList(1,2,3,3,3);
		List<Integer> d2 = Arrays.asList(2,2,3,4,4);
		System.out.println(optimalPoint(a2, d2));
		System.out.println("---------------"+4);
		List<Integer> a3 = Arrays.asList(1,1,2);
		List<Integer> d3 = Arrays.asList(1,2,2);
		System.out.println(optimalPoint(a3, d3));
		System.out.println("---------------"+2);
		List<Integer> a4 = Arrays.asList(1,10,11);
		List<Integer> d4 = Arrays.asList(11,10,11);
		System.out.println(optimalPoint(a4, d4));
		System.out.println("---------------"+3);
		
		
		/*List<Integer> a2 = Arrays.asList(1,1,2);
		List<Integer> d2 = Arrays.asList(1,2,2);
		System.out.println(getSchedule(a2, d2));*/
	}
	
	public static int getSchedule(List<Integer> arrival, List<Integer> departure) {

		int[][] data = new int[arrival.size() + 1][departure.size() + 1];

		for (int i = 1; i <= arrival.size(); i++) {
			for (int j = 1; j <= departure.size(); j++) {
				int row = i - 1;
				int col = j - 1;
				if (arrival.get(row).equals(departure.get(col))) {
					data[i][j] = data[row][j] > data[i][col] ? data[row][j] : data[i][col];
				} else {
					data[i][j] = data[row][col] + 1;
				}
			}

		}

		return data[arrival.size()][departure.size()];
	} 
	
	public static int getSchedule1(List<Integer> arrival, List<Integer> departure) {
       int answer = 0;
       int maxDay = 0;
       int size = departure.size();
       for(Integer i : departure){
    	   if(i>maxDay){
    		   maxDay = i;
    	   }
       }
       answer = maxDay>size ? size : maxDay; 
		return answer;
	} 
	
	 public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
		    // Write your code 
		        int magic_sum = 0;
		        int dist_sum =0;
		        int ans = 0;
		        int sum = 0;
		        for(int i = 0;i < magic.size();i++){
		            magic_sum += magic.get(i);
		            dist_sum += dist.get(i);
		            if(sum < 0){
		                ans = i;
		                sum = 0;
		            }
		            sum = sum + magic.get(i) - dist.get(i);            
		        }
		        if(magic_sum < dist_sum)
		            return -1;
		        return ans;
		    }
}
