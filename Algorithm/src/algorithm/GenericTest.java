package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenericTest implements Test{

	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);
		
		System.out.println(new GenericTest().get(a,0));
		
	}

	@Override
	public Object get(List list, int i) {
		// TODO Auto-generated method stub
		return list.get(i);
	}

	@Override
	public List get(List list) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

interface Test<T>{

	T get(List<T> list,int i);
	List<T> get(List<T> list);
	
}
