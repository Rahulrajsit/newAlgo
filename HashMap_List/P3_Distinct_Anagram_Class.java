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
			str[i] = "str" + (char) (r.nextInt(26) + 'a'); // Random character generator
		return str;
	}

	// TC: O(n) SC:O(n) we check string s1,s2 is anagram or not
	public static boolean checkAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int[] count = new int[26];
		for (int i = 0; i < s1.length(); i++)
			++count[s1.charAt(i) - 'a'];

		for (int i = 0; i < s2.length(); i++) {
			if (count[s2.charAt(i) - 'a'] == 0)
				return false;
			--count[s2.charAt(i) - 'a'];
		}
		return true;
	}

	// TC:O(n^2 * m) SC:O(n)
	public static void AnagramClass1(String[] in) {
		int count = 0;
		boolean[] used = new boolean[in.length];
		for (int i = 0; i < in.length; i++) { // Take one string and compare to i+1 to n string TC:O(n)
			if (used[i])
				continue;
			// System.out.println(in[i]);
			for (int j = i + 1; j < in.length; j++) { // TC:O(n)*O(n) ->O(n^2)
				if (checkAnagram(in[i], in[j])) { // TC:O(m) SC:O(n) check each string with i'th string anagram or not
													// TC:O(n^2 * m)
					System.out.println(in[j]);
					used[j] = true;
				}
			}
			System.out.println();
		}
		for (boolean k : used) { // TC:O(n) here we will check total number of false value that is my distinct
									// value
			if (!k)
				count++;
		}
		System.out.println("Total Distinct Anagram is:" + count);
	}

	// Here i am maintaining map<key,value> value is dynamic increment List
	// TC: n[m log m + 2 * O(1)] -> O(n m log m) SC:O()
	public static void AnagramClass3(String[] in) {
		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();

		for (int i = 0; i < in.length; ++i) { // TC:O(n)
			char[] tmp1 = in[i].toCharArray();

			Arrays.sort(tmp1); // O(m log m)

			String tmp2 = Arrays.toString(tmp1);
			List<String> val = hmap.get(tmp2);
			if (val == null) {
				ArrayList<String> list = new ArrayList<String>();

				list.add(in[i]);// TC:O(1)
				hmap.put(tmp2, list);// TC:O(1)

			} else

				val.add(in[i]);// TC:O(1)
		}
		for (String tmp : hmap.keySet()) // TC: O(n)
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
