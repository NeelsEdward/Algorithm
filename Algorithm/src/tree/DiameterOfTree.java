package tree;

public class DiameterOfTree {

	public static void main(String[] args) {
		
		Node node = new Node(1);
		node.left = new Node(2);
		node.left.left = new Node(3);
		node.left.right = new Node(4);
		
		node.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		node.right.right.right = new Node(8);
		
		System.out.println("Diameter--> "+ diameterOftree(node));

	}

	public static int heightOftree(Node n) {

		if (n == null) {
			return 0;
		} else {
			int leftHeight = heightOftree(n.left);
			int rightHeight = heightOftree(n.right);

			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static int diameterOftree(Node n) {

		if (n == null) {
			return 0;
		} else {
			int leftHeight = heightOftree(n.left);
			int rightHeight = heightOftree(n.right);

			int lDiameter = diameterOftree(n.left);
			int rDiameter = diameterOftree(n.right);

			return Math.max(leftHeight + rightHeight + 1, Math.max(lDiameter, rightHeight));
		}
	}

}
