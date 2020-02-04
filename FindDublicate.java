package raj;

import java.util.Arrays;

public class FindDublicate {

	public static void TestCase1(int[] in) {
		int i;
		for (i = 0; i < in.length - 1; i++)
			in[i] = i + 1;
		in[i] = i;
	}

	public static void TestCase2(int[] in) {
		int i;
		for (i = 0; i < in.length - 1; i++)
			in[i] = in.length - 1 - i;
		in[i] = i;
	}

	public static int FindDuplicate1(int[] in) {
		int i, j;
		for (i = 0; i < in.length - 1; i++) {
			for (j = i + 1; j < in.length; j++) {
				if (in[i] == in[j])
					return in[i];
			}
		}
		return Integer.MIN_VALUE;
	}

	public static int FindDuplicate2(int[] in) {
		int i, j;
		Arrays.parallelSort(in);
		for (i = 0; i < in.length; i++) {
			if (in[i] == in[i + 1])
				return in[i];
		}
		return Integer.MIN_VALUE;
	}

	public static int FindDuplicate3(int[] in) {
		int[] aux = new int[in.length];
		int i, j;
		for (i = 0; i < in.length; i++) {
			if (aux[in[i]] != 0)
				return in[i];
			aux[in[i]] = 1;
		}
		return Integer.MIN_VALUE;
	}

	public static int FindDuplicate4(int[] in) {
		for (int i = 0; i < in.length; i++) {
			int temp = Math.abs(in[i]);
			if (in[temp] < 0)
				return temp;
			in[temp] *= -1;
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		TestCase2(in);
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(FindDuplicate4(in));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " secs");

	}
}
