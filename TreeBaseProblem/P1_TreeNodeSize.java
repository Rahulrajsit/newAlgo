package TreeBaseProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1_TreeNodeSize {

/*	
I/P:     1
	    / \
	   2   3
	  /\   /\
	 4  5 6  7
	 
	 O/P : 7
*/
	// TC : O(n) SC : O(n)
	// Using Stack
	public static int TreeSize1(TreeNode root) {
		TreeNode current = root;

		int count = 0;
		Stack<TreeNode> stackAddress = new Stack<TreeNode>();

		stackAddress.add(current);
		while (!stackAddress.isEmpty()) {
			TreeNode temp = stackAddress.pop();
			++count;

			if (temp.left != null)
				stackAddress.add(temp.left);

			if (temp.right != null)
				stackAddress.add(temp.right);

		}

		return count;
	}

	// TC : O(n) SC : O(n)
	// Recursive call
	public static int TreeSize2(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		int ls = TreeSize2(root.left);
		int rs = TreeSize2(root.right);

		return ls + rs + 1;
	}

	// TC : O(n) SC : O(n)
	// Using Queue
	// Level by level check
	public static int TreeSize3(TreeNode root) {
		int count = 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode tmp = q.remove();
			++count;

			if (tmp.left != null)
				q.add(tmp.left);
			if (tmp.right != null)
				q.add(tmp.right);
		}

		return count;
	}

	// TC : O(n) SC : O(1)
	// Find Predessor of Root Node
	private static TreeNode inOrderPredessor(TreeNode root) {
		TreeNode current = root.left;
		while (current.right != null && current.right != root) {
			current = current.right;
		}
		return current;
	}

	public static int TreeSize4(TreeNode root) {
		int count = 0;
		while (root != null) {
			if (root.left == null) {
				root = root.right;
				++count;
			} else {
				TreeNode tmp = inOrderPredessor(root);
				if (tmp.right == null) {
					tmp.right = root;
					root = root.left;
					++count;
				} else {
					tmp.right = null;
					root = root.right;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		long start = System.currentTimeMillis();
		System.out.println(TreeSize4(root));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
		// System.out.println(TreeSize1(root));
		// System.out.println(TreeSize2(root));
		// System.out.println(TreeSize3(root));

	}

}
