package BSTProblems;

import java.util.Random;

public class P3_KthSmallest {

	// I want GLobal count then it will share Heap obj with stack frame
	// MyInteger value
	// TC : O(n) SC : O(n)
	public static int KthSmallest11(BSTNode root, int kth) {
		MyInteger gcount = new MyInteger(0);
		BSTNode res = auxKthSmallest11(root, kth, gcount);
		if (res == null)
			return Integer.MIN_VALUE;

		return res.data;
	}

	private static BSTNode auxKthSmallest11(BSTNode root, int k, MyInteger gcount) {
		if (root == null)
			return null;

		BSTNode res = auxKthSmallest11(root.left, k, gcount);
		if (res != null)
			return res;
		gcount.incr();
		if (gcount.get() == k)
			return root;

		return auxKthSmallest11(root.right, k, gcount);
	}

	private static BSTNode inOrderPredessor(BSTNode root) {
		BSTNode current = root.left;
		while (current.right != null && current.right != root) {
			current = current.right;
		}
		return current;
	}

	// TC : O(n) SC : O(1)
	public static int KthSmallest12(BSTNode root, int kth) {
		int count = 0;
		while (root != null) {
			if (root.left == null) {
				if (++count == kth)
					return root.data;
				root = root.right;
			} else {
				BSTNode tmp = inOrderPredessor(root);
				if (tmp.right == null) {
					tmp.right = root;
					root = root.left;
				} else {
					tmp.right = null;
					if (++count == kth)
						return root.data;
					root = root.right;
				}
			}
		}
		return Integer.MIN_VALUE;
	}

	// TC : O(h) SC : O(n) only for we add lst extra in BSTNode
	public static int KthSmallest2(BSTNode root, int kth) {
		while (root != null) {
			if (kth == root.lst_size + 1)
				return root.data;

			if (kth < root.lst_size + 1)
				root = root.left;
			else {
				kth = kth - (root.lst_size + 1);
				root = root.right;
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		BSTNode root = BSTUtils.createRandomBST(n);
		BSTUtils.displayTree(root);
		int k = new Random().nextInt(n) + 1;
		System.out.println(k);
		System.out.println(KthSmallest2(root, k));

	}

}
