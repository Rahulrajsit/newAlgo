package BSTProblems;

import java.util.Random;

public class P1_BSTSearch {

	public static boolean search1(BSTNode root, int x) {
		while (root != null) {
			if (x == root.data)
				return true;
			if (x < root.data)
				root = root.left;
			else
				root = root.right;
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BSTNode root = BSTUtils.createRandomBST(n);
		BSTUtils.displayTree(root);
		int k = new Random().nextInt(n) + 1;
		System.out.println(k);
		System.out.println(search1(root, k));
	}
}