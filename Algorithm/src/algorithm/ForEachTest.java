package algorithm;

import java.util.Arrays;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {
		
	List<Integer> list = Arrays.asList(1,2,3);
	Test obj = new Test(1);
     for(Integer i : list){
    	 
     }

	}
	
	
	private static void alterValue(int value, Test obj){
		
	}
	
	
	public static class Test{
		private int id;
		private TestList list;
		
		

		
		public TestList getList() {
			return list;
		}

		public void setList(TestList list) {
			this.list = list;
		}

		public Test(int id) {
			super();
			this.id = id;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
	}
	
	public static class TestList{
		
	}
}
