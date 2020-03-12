package TreeBaseProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P6_Ser_De_P1_SerDe {

	// TC : O(n) SC : O(n)
	// Pre-order with NULL links
	public static String ser1(TreeNode root) {
		if (root == null)
			return "#";
		String left = ser1(root.left);
		String right = ser1(root.right);
		return root.data + "," + left + "," + right;
	}

	// TC : O(n) SC : O(n)
	public static TreeNode deser11(String in) {
		String tokens[] = in.split(",");
		MyInteger index = new MyInteger(0);
		return auxDeser11(tokens, index);
	}

	// Pre-order with NULL links
	private static TreeNode auxDeser11(String[] tokens, MyInteger index) {
		if (tokens[index.get()].equals("#"))
			return null;

		TreeNode root = new TreeNode(Integer.parseInt(tokens[index.get()]));
		index.incr();
		root.left = auxDeser11(tokens, index);
		index.incr();
		root.right = auxDeser11(tokens, index);

		return root;
	}

	// TC : O(n) SC : O(n)
	public static TreeNode deser12(String in) {
		String tokens[] = in.split(",");
		Queue<String> q = new LinkedList<String>();
		for (String token : tokens)
			q.add(token);
		return auxDeser12(q);
	}

	// Queue
	private static TreeNode auxDeser12(Queue<String> q) {
		String token = q.remove();
		if (token.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(token));
		root.left = auxDeser12(q);
		root.right = auxDeser12(q);
		return root;
	}

	// TC : O(n) SC : O(n)
	// Pre-order with NULL links
	public static String ser2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		String res = "";
		q.add(root);
		while (!q.isEmpty()) {

			TreeNode temp = q.remove();
			if (temp == null)
				res += "#";
			else
				res += temp.data + ",";

			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);

		}
		return res;
	}

	public static String preOrder(TreeNode root) {
		if (root == null)
			return "";
		String left = preOrder(root.left);
		String right = preOrder(root.right);
		return root.data + "," + left + "," + right;
	}

	public static String inOrder(TreeNode root) {
		if (root == null)
			return "";
		String left = inOrder(root.left);
		String right = inOrder(root.right);
		return left + "," + root.data + "," + right;
	}

	// TC : O(n) SC : O(n)
	// Pre-order with NULL links
	public static String ser3(TreeNode root) {
		String res = preOrder(root);
		res = res + "#";
		res = res + inOrder(root);
		return res;
	}

	// TC : O(n) SC: O(n)
	public static TreeNode deser3(String input) {
		String[] tokens = input.split("#");
		String[] pre = tokens[0].split(",");
		String[] in = tokens[1].split(",");
		Queue<Integer> preQueue = new LinkedList<Integer>();
		for (String token : pre) {
			if (token.trim().length() != 0)
				preQueue.add(Integer.parseInt(token));
		}
		int i = 0;
		int[] inorder = new int[preQueue.size()];
		for (String token : in) {
			if (token.trim().length() != 0)
				inorder[i++] = Integer.parseInt(token);
		}
		System.out.println(preQueue);
		System.out.println(Arrays.toString(inorder));
		return auxdeser3(preQueue, inorder, 0, inorder.length - 1);
	}

	private static TreeNode auxdeser3(Queue<Integer> pre, int[] in, int l, int r) {
		if (l > r)
			return null;
		Integer current = pre.remove();
		int p = findElementIndex(current, in, l, r);
		TreeNode root = new TreeNode(current);
		root.left = auxdeser3(pre, in, l, p - 1);
		root.right = auxdeser3(pre, in, p + 1, r);
		return root;
	}

	private static int findElementIndex(Integer current, int[] in, int l, int r) {
		for (int i = l; i <= r; ++i)
			if (in[i] == current)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		TreeNode root = BinaryTreeUtils.createUniqueBinaryTree(n);
		BinaryTreeUtils.displayTree(root);
		long start = System.currentTimeMillis();
		String res = ser3(root);
		System.out.println(res);
		root = deser3(res);
		BinaryTreeUtils.displayTree(root);
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
