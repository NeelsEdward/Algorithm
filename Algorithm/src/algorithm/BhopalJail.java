package algorithm;

public class BhopalJail {

	public static void main(String[] args) {
		int jump =4;//10;// 5;
		int slide = 1;
		int wall[] = {5,6,9,11,4,5};//{1,10};//{2,9,10};
		System.out.println(GetJumpCount(jump, slide, wall));
		System.out.println('C'=='C');
	}
	
	public static int GetJumpCount(int input1,int input2,int[] input3)
    {
		int result = 0;
		
		for(int i=1;i<input3.length;i++){
			if(input1>=input3[i]){
				result++;
			}else {
				boolean isValid = true;
				while(isValid){
					result++;
					if(input1>=input3[i]){
						break;
					}
					int dif = input1-input2;
					input3[i] = input3[i]-dif;
				}
			}
		}
	    
	    return result;
    }
}
