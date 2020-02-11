package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ModifiedSingleTonList {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		List<Integer> l1= Collections.singletonList(4);
		System.out.println("Before--> "+l1.size());
		
		/*Iterator<Integer> iterator = l1.iterator();
		while (iterator.hasNext()) {
			iterator.remove();
		}*/
		System.out.println("After--> "+l1.size());
		
		/*String test = "i am # and #";
		String t = test.replaceAll("#", "Neels");
		System.out.println(t);*/
	}
}
