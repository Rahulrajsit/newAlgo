package LinkedList;

import java.util.HashMap;

public class P5_2_RandomFloat {

	private long a, b, m, seed;

	public P5_2_RandomFloat() {
		this(System.currentTimeMillis());
	}

	// To generate random float condition(1.Uniform 2.No prediction)
	// m must be powers of 2 then uniform distribution will maintain
	// Each n(from 0 to n-1) will get equal chance.
	// b and m must be relatively prime
	// a = gcf(b,m) + 4k (for some k)
	// System run all 10000 loop in less time due to this we have to pass seed value
	public P5_2_RandomFloat(long seed) {
		this.seed = seed;
		this.a = 1103515245L;
		this.b = 12345L;
		this.m = 1L << 32;
	}

	// bug:overflow due to multiplication
	// System run all 10000 loop in less time due to this line 37 i am passing 1 or 0 -> new P5_2_RandomFloat(1); 
	public float rand() {
		seed = (a * seed + b) % m; // m is big number like power if 2 then we will maintain uniformly  
		return (float) seed / (m - 1); // generate float value b/w (0 to 1)
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		// we have to pass seed value 1 
		// system execute in one time so, not getting diferent time as a seed  
		P5_2_RandomFloat random = new P5_2_RandomFloat(1);
		//P5_2_RandomFloat random = new P5_2_RandomFloat();
		
		for (int i = 1; i <= 10000; ++i) {
			int r = (random.rand() >= 0.5f) ? 0 : 1; // value less then 0.5 treated as 0, greater as 1
			if (hmap.get(r) == null)
				hmap.put(r, 1);
			else
				hmap.put(r, hmap.get(r) + 1);
			System.out.println(r);
		}
		System.out.println(hmap);
	}
}