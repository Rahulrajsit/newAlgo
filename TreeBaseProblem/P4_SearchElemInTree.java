package TreeBaseProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class P4_SearchElemInTree {

	// TC : O(n) SC : O(n)
	// Using Stack
	public static boolean TreeSearch1(TreeNode root, int x) {

		return false;
	}

	// TC : O(n) SC : O(n)
	// Recursion
	public static boolean TreeSearch2(TreeNode root, int x) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return root.data == x; // This will return True or False
		if (root.data == x)
			return true;

		boolean res = TreeSearch2(root.left, x);

		// If this statement is true then it will not go to last return statement
		// Breaking of recursion
		if (res == true)
			return true;

		return TreeSearch2(root.right, x);
	}

	// TC : O(n) SC : O(n)
	// Using Queue Level by level(Left to Right)
	public static boolean TreeSearch3(TreeNode root, int x) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp.data == x)
				return true;
			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}
		return false;
	}

	private static TreeNode inOrderPredecessor(TreeNode root) {
		TreeNode current = root.left;
		while (current.right != null && current.right != root)
			current = current.right;
		return current;
	}

	// TC : O(n) SC : O(1)
	public static boolean TreeSearch4(TreeNode root, int x) {

		while (root != null) {
			if (root.left == null) {
				if (root.data == x)
					return true;
				root = root.right;
			} else {
				TreeNode tmp = inOrderPredecessor(root);
				// 1st time visit
				if (tmp.right == null) {
					tmp.right = root;
					if (root.data == x)
						return true;
					root = root.left;
				}
				// 2st time visit
				else {
					tmp.right = null;
					root = root.right;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int x = r.nextInt(n);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		long start = System.currentTimeMillis();
		System.out.println(x);
		System.out.println(TreeSearch1(root, x));
		System.out.println(TreeSearch2(root, x));
		System.out.println(TreeSearch3(root, x));
		System.out.println(TreeSearch4(root, x));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
