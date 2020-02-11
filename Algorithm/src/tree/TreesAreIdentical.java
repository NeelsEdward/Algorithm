package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreesAreIdentical {

	public static void main(String[] args) {

		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);

		System.out.println("Identical-- " + isIdentical(root1, root2));
		
		System.out.println("-------------------------------------------");
		
		Node root3 = new Node(1);
		root3.left = new Node(2);
		root3.right = new Node(3);

		Node root4 = new Node(1);
		root4.left = new Node(2);
		root4.right = new Node(3);
		root4.right.left = new Node(4);

		System.out.print("Identical-- " + isIdentical(root3, root4));

	}

	static boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else {
			Queue<Node> queue1 = new LinkedList<Node>();
			queue1.add(root1);
			Queue<Node> queue2 = new LinkedList<Node>();
			queue2.add(root2);
			while (!queue1.isEmpty() || !queue2.isEmpty()) {

				Node n1 = queue1.poll();
				Node n2 = queue2.poll();
				if(n1 == null && n2 != null){
					return false;
				}
				if(n1 != null && n2 == null){
					return false;
				}
				if (n1.data != n2.data) {
					return false;
				}
				if (n1.left != null) {
					queue1.add(n1.left);
				}
				if (n1.right != null) {
					queue1.add(n1.right);
				}
				if (n2.left != null) {
					queue2.add(n2.left);
				}
				if (n2.right != null) {
					queue2.add(n2.right);
				}
			}
		}
		return true;
	}

}
