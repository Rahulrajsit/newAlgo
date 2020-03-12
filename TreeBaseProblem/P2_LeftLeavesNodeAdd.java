package TreeBaseProblem;

import java.util.LinkedList;
import java.util.Queue;

public class P2_LeftLeavesNodeAdd {

	/*
	 * I/P: 1 / \ 2 3 /\ 6 7
	 * 
	 * O/P : 2+6 = 8
	 */
	// TC : O(n) SC : O(n)
	// Using Stack
	public static int TreeLeaveSum1(TreeNode root) {

		return 0;
	}

	// TC : O(n) SC : O(n)
	// Recursion call for check in every level True(left) and False(right)
	// Sending the information from parents to child
	// Best Solution5
	public static int TreeLeaveSum2(TreeNode root) {
		// Pass false or True as parents
		// We are interested in left leaves nodes
		return auxLeftLeaves(root, false);
	}

	// Outside Not visible
	private static int auxLeftLeaves(TreeNode root, boolean isLeft) {

		if (root == null)
			return 0;

		// we are interested to checking the leave is left or not
		if (root.left == null && root.right == null && isLeft == true)
			return root.data;

		int lsum = auxLeftLeaves(root.left, true);
		int rsum = auxLeftLeaves(root.right, false);

		return lsum + rsum;
	}

	// Custom Class for Queue which store Tree as well as Flag information
	static class MyNode {
		TreeNode node;
		boolean isLeft;

		// Create a constructor
		public MyNode(TreeNode node, boolean isLeft) {
			this.node = node;
			this.isLeft = isLeft;
		}
	}

	// TC : O(n) SC : O(n)
	// Using Queue
	public static int TreeLeaveSum3(TreeNode root) {

		// Add You own Custom node
		Queue<MyNode> q = new LinkedList<MyNode>();

		q.add(new MyNode(root, false));

		int sum = 0;

		while (!q.isEmpty()) {
			MyNode tmp = q.remove();
			if (tmp.node.left == null && tmp.node.right == null && tmp.isLeft == true)
				sum += tmp.node.data;

			if (tmp.node.left != null)
				q.add(new MyNode(tmp.node.left, true));

			if (tmp.node.right != null)
				q.add(new MyNode(tmp.node.right, false));
		}

		return sum;
	}

	// TC : O(n) SC : O(1)
	// Not suitable for this case
	public static int TreeLeaveSum4(TreeNode root) {

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		long start = System.currentTimeMillis();
		System.out.println(TreeLeaveSum1(root));
		System.out.println(TreeLeaveSum2(root));
		System.out.println(TreeLeaveSum3(root));
		System.out.println(TreeLeaveSum4(root));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
