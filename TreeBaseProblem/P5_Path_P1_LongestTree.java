package TreeBaseProblem;

import java.util.LinkedList;
import java.util.Queue;

public class P5_Path_P1_LongestTree {

	// TC : O(n) SC : O(n)
	// Using Stack Tree Traversal Recursion
	public static int LongRootToTreePath1_1(TreeNode root) {
		MyInteger gmax = new MyInteger(0);
		auxLongRootToTreePath1_1(root, 1, gmax);
		return gmax.get();
	}

	public static void auxLongRootToTreePath1_1(TreeNode root, int depth, MyInteger gmax) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			gmax.set(Math.max(gmax.get(), depth));
			return;
		}
		auxLongRootToTreePath1_1(root.left, depth + 1, gmax);
		auxLongRootToTreePath1_1(root.right, depth + 1, gmax);
	}

	static class MyNode1 {
		TreeNode node;
		int depth;

		public MyNode1(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}

	}

	// TC : O(n) SC : O(n)
	// Using Queue
	public static int LongRootToTreePath1_2(TreeNode root) {
		Queue<MyNode1> q = new LinkedList<P5_Path_P1_LongestTree.MyNode1>();
		q.add(new MyNode1(root, 1));
		int res = 0;
		while (!q.isEmpty()) {
			MyNode1 tmp = q.remove();
			if (tmp.node.left == null && tmp.node.right == null) {
				res = Math.max(res, tmp.depth);
			} else {
				if (tmp.node.left != null)
					q.add(new MyNode1(tmp.node.left, tmp.depth + 1));
				if (tmp.node.right != null)
					q.add(new MyNode1(tmp.node.right, tmp.depth + 1));
			}
		}

		return res;
	}

	// TC : O(n) SC : O(n)
	// Recursion
	public static int LongRootToTreePath2(TreeNode root) {
		if (root == null)
			return 0;

		// If only one node is available
		if (root.left == null && root.right == null)
			return 1;

		// It will return left total no. of left node
		int left = LongRootToTreePath2(root.left);
		// It will return left total no. of right node
		int right = LongRootToTreePath2(root.right);

		return Math.max(left, right) + 1;
	}

	// TC : O(n) SC : O(n)
	// Using Queue Level by level(Left to Right)
	public static int LongRootToTreePath3(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int nlevels = 0;
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp == null) {
				++nlevels;
				if (!q.isEmpty())
					q.add(null);
			} else {
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		return nlevels;
	}

	// TC : O(n) SC : O(1)
	// Inorder Predecessor not possible here
	public static int LongRootToTreePath4(TreeNode root) {

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		long start = System.currentTimeMillis();
		System.out.println(LongRootToTreePath1_1(root));
		System.out.println(LongRootToTreePath1_2(root));
		System.out.println(LongRootToTreePath2(root));
		System.out.println(LongRootToTreePath3(root));
		System.out.println(LongRootToTreePath4(root));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
