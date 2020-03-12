package BSTProblems;

public class P4_SerDe {

	// TC : O(n) SC : O(1)
	public static String serDe1(BSTNode root) {
		if (root == null)
			return "";
		String res = "";
		String left = serDe1(root.left);
		res = root.data + ",";
		String right = serDe1(root.right);
		return res + left + right;
	}

	// TC : O(n^2) Due to N comparison with root node
	// SC : O(1)
	public static BSTNode DeSer1(String in) {
		String[] tokens = in.split(",");

		BSTNode root = null;
		for (String x : tokens) {
			root = BSTUtils.add(root, Integer.parseInt(x));
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		BSTNode root = BSTUtils.createUniqueBST(n);
		BSTUtils.displayTree(root);
		String res = serDe1(root);
		System.out.println(res);
		root = DeSer1(res);
		BSTUtils.displayTree(root);
	}

}
