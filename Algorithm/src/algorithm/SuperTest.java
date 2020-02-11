package algorithm;

public class SuperTest {
 public void T(){
	 System.out.println("super");
 }
 
 public void T(int i){
	 System.out.println("super int");
 }
 
 public static void main(String[] args) {
	SuperTest st = new sub();
	//st.T();
	 String i = null;
	 System.out.println(i);
}
}
class sub extends SuperTest{
	
	public void S(){
		T();
		super.T();
	}
	
	public void SS(){
		T();
		super.T();
	}
	
}