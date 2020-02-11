package tree;

public class DepthOfTree {

	public static void main(String[] args) {

		 Node root = new Node(1); 
	     root.left = new Node(2); 
	     root.right = new Node(3); 
	     root.left.left = new Node(4); 
	     root.left.right = new Node(5);
	     root.left.right.left = new Node(6);
	   
	 System.out.println("Height of tree is : " +maxDepth(root)); 
	}

	static int maxDepth(Node node) {

		if (node == null) {
			return 0;
		} else {

			int leftHeight = maxDepth(node.left);
			int rightHeight = maxDepth(node.right);

			return Math.max(leftHeight, rightHeight) + 1;
		}

	}
}
