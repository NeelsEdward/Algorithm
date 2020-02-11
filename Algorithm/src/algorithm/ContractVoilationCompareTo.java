package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class ContractVoilationCompareTo {

	public static void main(String[] args) {
		
		ArrayList<T> list = new ArrayList<T>();
		T t1 = new T(27,"Neels");
		T t2 = new T(28,"NVN");
		T t3 = new T(26,"Neha");
		list.add(t1);
		list.add(t2);
		list.add(t3);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}
}

class T implements Comparable<T>{

	int age;
	String name;
	
	
	public T(int age, String name) {
		this.age = age;
		this.name = name;
	}


	@Override
	public int compareTo(T o) {
		// TODO Auto-generated method stub
		return 1;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.age+" "+this.name;
	}
	
	
}
