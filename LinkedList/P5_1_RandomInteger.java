package LinkedList;

import java.util.HashMap;

public class P5_1_RandomInteger {

	private long a, b, m, seed;

	public P5_1_RandomInteger() {
		this(System.currentTimeMillis());
	}

	// To generate random float condition(1.Uniform 2.No prediction)
	// m must be powers of 2 then uniform distribution will maintain
	// Each n(from 0 to n-1) will get equal chance.
	// b and m must be relatively prime
	// a = gcf(b,m) + 4k (for some k)
	public P5_1_RandomInteger(long seed) {
		this.seed = seed;
		this.a = 1103515245L;
		this.b = 12345L;
		this.m = 1L << 32;
	}

	// bug:overflow due to multiplication
	//
	public int nextInt(int n) {
		seed = (a * seed + b) % m;// m is big number like power if 2 then we will maintain uniformly
		return (int) (seed % n);// generate integer value
	}

	public static void main(String[] args) {
		// here every number will get equal chance
		int n = Integer.parseInt(args[0]);
		
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		// seed value we have to pass 
		P5_1_RandomInteger random = new P5_1_RandomInteger(0);  
		for (int i = 1; i <= 10000; ++i) {
			int r = random.nextInt(n);
			if (hmap.get(r) == null)
				hmap.put(r, 1);
			else
				hmap.put(r, hmap.get(r) + 1);
			//System.out.println(r);
		}
		System.out.println(hmap);
	}
}