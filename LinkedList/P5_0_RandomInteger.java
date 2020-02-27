package LinkedList;

import java.util.HashMap;

public class P5_0_RandomInteger {

	private long a, b, m, seed;

	public P5_0_RandomInteger() {
		this(System.currentTimeMillis());
	}

	public P5_0_RandomInteger(long seed) {
		this.seed = seed;
		this.a = 5;
		this.b = 7;
		this.m = 11;
	}

	public int nextInt(int n) {
		seed = (a * seed + b) % m;
		return (int) (seed % n);
	}

	public static void main(String[] args) {
		// suppose i am passing 10 then i will generate random value from 0 to 9 but here only few number is generating 
		// but it generate 5 0 2 6 4->5 0 2 6 4 (cycle) so uniform is lost and you can also predict next value
		int n = Integer.parseInt(args[0]);
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		P5_0_RandomInteger random = new P5_0_RandomInteger();
		for (int i = 1; i <= 10000; ++i) {
			int r = random.nextInt(n);
			if (hmap.get(r) == null)
				hmap.put(r, 1);
			else
				hmap.put(r, hmap.get(r) + 1);
			System.out.println(r);
		}
		System.out.println(hmap);
	}
}