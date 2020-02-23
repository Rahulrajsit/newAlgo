package HashMap_List;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class P3_Distinct_Anagram_Class {

	public static String[] Testcase1(int x) {
		Random r = new Random();
		String[] str = new String[x];
		for (int i = 0; i < x; i++)
			str[i] = "str" + r.nextInt(5);
		return str;
	}

	public static int AnagramClass(String[] in) {
		int incount = 1;
		for (String s : in) {
			s.toCharArray();
			System.out.println(s.toCharArray());
		}
		for (int i = 0; i < in.length - 1; i++) {
			if (!in[i].equals(in[i + 1]))
				incount++;
		}
		return incount;
	}

	public static void AnagramClass3(String[] in) {
		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
		for (int i = 0; i < in.length; ++i) {
			char[] tmp1 = in[i].toCharArray();
			Arrays.sort(tmp1);
			String tmp2 = Arrays.toString(tmp1);
			List<String> val = hmap.get(tmp2);
			if (val == null) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(in[i]);
				hmap.put(tmp2, list);
			} else
				val.add(in[i]);
		}
		for (String tmp : hmap.keySet())
			System.out.println(tmp + ":" + hmap.get(tmp));
		System.out.println("Total Distinct Anagram is:" + hmap.size());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		String[] in = Testcase1(n);
		System.out.println(Arrays.toString(in));

		long start = System.currentTimeMillis();
		AnagramClass3(in);
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " secs");

	}

}
