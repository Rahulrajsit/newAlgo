/***********************************************
 * 
 *      Count zero follow by Non zero Number
 *      
 *      CountZero1 TC:- O(n) SC:- O(1)
 *      CountZero2 TC:- O(log n) SC:- O(1)
 *      
************************************************/
package Array;

import java.util.Arrays;
import java.util.Random;

public class P2_CountZero {

	public static void TestCase1(int[] in) {
		Random r = new Random();
		int nzeros = r.nextInt(in.length);
		int i;
		for (i = 0; i < nzeros; i++)
			in[i] = 0;
		while (i < in.length)
			in[i++] = r.nextInt(100) + 1;
	}

	public static int CountZero1(int[] in) {
		int i;
		for (i = 0; i < in.length; i++) {
			if (in[i] != 0)
				break;
		}
		return i;
	}

	public static int CountZero2(int[] in) {
		int l = 0, r = in.length - 1;
		while (r - l > 1) {
			int m = (l + r) / 2;
			if (in[m] == 0)
				l = m;
			else
				r = m - 1;
		}
		if (in[r] == 0)
			return r + 1;
		else if (in[l] == 0)
			return l + 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		
		TestCase1(in);
		
		System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		
		System.out.println(CountZero1(in));
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken:" + (end - start) / 1000.0 + " secs");

	}

}
