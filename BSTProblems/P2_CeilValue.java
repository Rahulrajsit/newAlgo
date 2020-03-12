package BSTProblems;

import java.util.Random;

public class P2_CeilValue {

	public static int ceil1(BSTNode root, int data) {
		int res = Integer.MIN_VALUE;
		while (root != null) {

			if (root.data == data)
				return data;
			if (data < root.data) {
				res = root.data;
				root = root.left;
			} else
				root = root.right;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BSTNode root = BSTUtils.createRandomBST(n);
		BSTUtils.displayTree(root);
		int k = new Random().nextInt(n) + 1;
		System.out.println(k);
		System.out.println(ceil1(root, k));

	}
}