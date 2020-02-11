package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ChessGame {

	public static void main(String[] args) {
		System.out.println(getStepCount(1,1,8,8));
	}

	public static int getStepCount(int input1, int input2, int input3, int input4) {
		   
		   int step = 500;
		   int matrix[][] = new int[9][9];
		   int length = 9;
		   matrix[input3][input4] =0;
		   int[] xmov = { 2,2,-2,-2,1,-1, 1,-1};
		   int[] ymov = {-1,1,-1, 1,2, 2,-2,-2};
		   Queue<Integer> x1 = new LinkedList<Integer>();
		   Queue<Integer> y1 = new LinkedList<Integer>();
		   x1.add(input1);
		   y1.add(input2);
		   
		   while(!x1.isEmpty() && !y1.isEmpty()){
		       
		       int x = x1.poll();
		       int y = y1.poll();
		       if(x == input3 && y == input4){
		           if(matrix[x][y] < step){
		        	   step = matrix[x][y];
		           }
		       }else{
		           
		           for(int i=0;i<8;i++){
		               int xx = x+xmov[i];
		               int yy = y+ymov[i];
		               if(xx>=1 && xx < length && yy>=1 && yy < length){
		                   if(matrix[xx][yy] == 0){
		                	   matrix[xx][yy] =matrix[x][y]+1;
		                	   x1.add(xx);
		                       y1.add(yy);
		                   }else{
		                	   int value = matrix[x][y]+1;
		                	   if(value < matrix[xx][yy]){
		                		   matrix[xx][yy] = value;
		                		   x1.add(xx);
			                       y1.add(yy);
		                	   }
		                   }
		               }
		           }
		       }
		       
		       
		   }
		   
		   
		   
		   return step;

 
	}

}