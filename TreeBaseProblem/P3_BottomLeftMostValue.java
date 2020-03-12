package TreeBaseProblem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P3_BottomLeftMostValue {

	// TC : O(n) SC : O(n)
	// Using Stack
	public static int LeftMostvalue1(TreeNode root) {

		return 0;
	}

	// TC : O(n) SC : O(n)
	// Recursion
	public static int LeftMostvalue2(TreeNode root) {
		HashMap<Integer, LinkedList<Integer>> hmap = new HashMap<Integer, LinkedList<Integer>>();
		auxLeftMostvalue2(root, 1, hmap);
		System.out.println(hmap);
		return hmap.get(hmap.size()).get(0);
	}

	public static void auxLeftMostvalue2(TreeNode root, int level, HashMap<Integer, LinkedList<Integer>> hmap) {
		if (root == null)
			return;
		LinkedList<Integer> values = hmap.get(level);
		if (values == null) {
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(root.data);
			hmap.put(level, list);
		} else {
			values.add(root.data);
		}
		auxLeftMostvalue2(root.left, level + 1, hmap);
		auxLeftMostvalue2(root.right, level + 1, hmap);
	}

	enum state {
		NULLSTATE, NON_NULLSTATE
	}

	// TC : O(n) SC : O(n)
	// Using Queue Level by level(Left to Right)
	public static int LeftMostvalue3_1(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		q.add(null);
		int res = 0;
		state lastState = state.NULLSTATE;
		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			if (tmp == null) {
				lastState = state.NULLSTATE;
				if (!q.isEmpty())
					q.add(null);
				System.out.println();

			} else {
				if (lastState == state.NULLSTATE) {
					res = tmp.data;
					lastState = state.NON_NULLSTATE;
				}
				System.out.print(tmp.data + " ");
				if (tmp.left != null)
					q.add(tmp.left);
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		return res;
	}

	// TC : O(n) SC : O(n)
	// Using Queue Level by level(Right to Left)
	public static int LeftMostvalue3_2(TreeNode root) {
		int data = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			data = tmp.data;

			// If start from right to left then on last pop you get left data from Queue
			if (tmp.right != null)
				q.add(tmp.right);
			if (tmp.left != null)
				q.add(tmp.left);

		}
		return data;
	}

	// TC : O(n) SC : O(1)
	public static int LeftMostvalue4(TreeNode root) {

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		long start = System.currentTimeMillis();
		System.out.println("Left data: " + LeftMostvalue1(root));
		System.out.println("Left data: " + LeftMostvalue2(root));
		System.out.println("Left data: " + LeftMostvalue3_1(root));
		System.out.println("Left data: " + LeftMostvalue3_2(root));
		System.out.println("Left data: " + LeftMostvalue4(root));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
