package algo;

import java.util.Arrays;
import java.util.Random;

public class P4_2D_FindData_Sorted {

	public static int TestCase1(int[][] in) {
		int r = 1;
		Random r1 = new Random();
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in.length; j++) {
				in[i][j] = r++;
			}
		}
		return r1.nextInt(100) + 50;
	}

	public static boolean Search1(int[][] in, int x) {
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < in.length; j++) {
				if (in[i][j] == x)
					return true;
			}
		}
		return false;
	}

	public static boolean Search2(int[][] in, int x) {
		for (int i = 0; i < in.length; i++) {
			if (Arrays.binarySearch(in[i], x) >= 0)
				return true;
		}
		return false;
	}

	public static boolean Search4(int[][] in, int x) {
		int left = 0, right = in.length * in.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int tmp = in[mid / in.length][mid % in.length];
			if (tmp == x)
				return true;
			if (x < tmp)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		int[][] in = new int[n][n];
		int x = TestCase1(in);

		for (int[] tmp : in)
			System.out.println(Arrays.toString(tmp));

		System.out.println(x);

		long start = System.currentTimeMillis();

		System.out.println(Search4(in, x));

		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " secs");

	}

}
