package TreeBaseProblem;

import java.util.Random;

public class BinaryTreeUtils {

	private static TreeNode add1(TreeNode root, int data) {

		// If root is null then create one Treenode with root data
		// And return that Node as root
		if (root == null)
			return new TreeNode(data);

		TreeNode current = root, parent = null;
		Random r = new Random();
		while (current != null) {
			parent = current;
			// Taking decision as per rand 0,1 to move in left or right node in tree
			// 0 is left and 1 is right
			if (r.nextInt(2) == 0) {
				if (current.left == null) {
					parent.left = new TreeNode(data);
					// Once you add come back from Tree.
					break;
				}
				// Move node to current of left for next time to add
				// To reach left last node of tree
				current = current.left;
			} else {
				if (current.right == null) {
					parent.right = new TreeNode(data);
					break;
				}
				// Move node to current of right for next time to add
				// To reach right last node of tree
				current = current.right;
			}
		}

		return root;
	}

	// as like add1 we just create for next tree
	private static TreeNode add2(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		TreeNode current = root, parent = null;
		Random r = new Random();
		while (current != null) {
			parent = current;
			if (r.nextInt(2) == 0) {
				if (current.left == null) {
					parent.left = new TreeNode(data);
					break;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					parent.right = new TreeNode(data);
					break;
				}
				current = current.right;
			}
		}
		return root;
	}

	// This will generate different different tree every time
	public static TreeNode createBinaryTree(int n) {
		Random r = new Random();
		TreeNode root = null;
		for (int i = 0; i < n; i++) {
			int data = r.nextInt(n) + 1;
			root = add1(root, data);
		}
		return root;
	}

	// This will generate tree from 1 to n type data
	public static TreeNode createUniqueBinaryTree(int n) {
		TreeNode root = null;
		for (int i = 0; i < n; i++)
			root = add2(root, i + 1);

		return root;
	}

	// This will generate tree node in left side only
	public static TreeNode createOneSideBinaryTree(int n) {
		Random r = new Random();
		// Create root with null
		TreeNode root = null;
		for (int i = 0; i < n; i++) {
			int data = r.nextInt(n) + 1;
			// Root Node will create with data
			TreeNode tmp = new TreeNode(data);
			// Every time it will add to left side only
			if (root != null) {
				tmp.left = root;
			}
			root = tmp;
		}
		return root;
	}

	// PreOrder Display function
	public static void displayTree(TreeNode root) {
		auxDisplay(root, 0, "Root");
	}

	// PreOrder Print type
	private static void auxDisplay(TreeNode root, int space, String type) {
		if (root == null)
			return;
		for (int i = 0; i < space; i++)
			System.out.print(' ');

		System.out.println(root.data + "(" + type + ")");
		auxDisplay(root.left, space + 4, "L");
		auxDisplay(root.right, space + 4, "R");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);

	}

}
