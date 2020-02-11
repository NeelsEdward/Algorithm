package algorithm;

public class Millitary {

	public static void main(String[] args) {
		
		int input1 = 4;
		int input2 = 11;
		String input3 = "cAda";
		String input4 = "AbrAcadAbRa";
		/*StringBuilder sb = new StringBuilder();
		sb.append(input3);
		System.out.println(sb);
		sb.replace(0,1,"0");
		System.out.println(sb);*/
		
		System.out.println(appearanceCount(input1, input2, input3, input4));
	}
	
	public static int appearanceCount(int input1,int input2,String input3,String input4)
    {
	    int count = 0;
	    String temp = input3;
	  
	    for(int i=0;i<input4.length()-input1;i++){
	    	StringBuilder sb = new StringBuilder();
	    	sb.append(temp.toString());
	    	int isValid = 0;
	    	for(int j=i;j<i+input1;j++){
	    		for(int k=0;k<input3.length();k++){
		    		if(sb.charAt(k) == input4.charAt(j)){
		    			isValid++;
		    			sb.replace(k,k+1,"0");
		    			break;
		    		}
		    	}
	    	}
	    	if(isValid == temp.length()){
	    		count++;
	    	}
	    }
	    
	    
	    return count;
    }
}
