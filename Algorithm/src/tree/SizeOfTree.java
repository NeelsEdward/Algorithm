package tree;

public class SizeOfTree {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);

		System.out.println("Height of tree is : " + size(root));
	}

	static int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return size(node.left) + 1 + size(node.right);
		}
	}
}
