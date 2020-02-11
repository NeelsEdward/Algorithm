package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Node {

	int data;
	Node left;
	Node right;

	Node(int item) {
		data = item;
		left = right = null;
	}

}
