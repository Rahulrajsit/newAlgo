package algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class P5_find_sum {

	public static int TestCase1(int[] in) {
		Random r = new Random();
		for (int i = 0; i < in.length; i++)
			in[i] = r.nextInt(10) + 1;
		return r.nextInt(10) + 10;
	}

	public static int TestCase2(int[] in) {
		Random r = new Random();
		for (int i = 0; i < in.length; i++)
			in[i] = r.nextInt(10) + 1;
		return 0;
	}

	// TC: O(n^2) SC: O(1)
	public static boolean twoSum1(int[] in, int s) {
		for (int i = 0; i < in.length; i++) {
			int temp = s - in[i];
			for (int j = i + 1; j < in.length; j++) {
				if (temp == in[j])
					return true;
			}
		}
		return false;
	}

	// TC: O(n log n) SC: O(1)
	public static boolean twoSum2(int[] in, int s) {
		Arrays.sort(in);
		for (int i = 0; i < in.length; i++) {
			int temp = s - in[i];
			if (Arrays.binarySearch(in, i + 1, in.length, temp) > 0)
				return true;
		}
		return false;
	}

	// TC: O(n)amortized complexity SC: O(n)
	public static boolean twoSum3(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for (int i = 0; i < in.length; i++) {
			int temp = s - in[i];
			if (hset.contains(temp))
				return true;
			hset.add(in[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		int x = TestCase1(in);

		//System.out.println(Arrays.toString(in));
		//System.out.println(x);

		long start = System.currentTimeMillis();

		System.out.println(twoSum1(in, x));
		//System.out.println(twoSum2(in, x));
		//System.out.println(twoSum3(in, x));

		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " secs");

	}

}
