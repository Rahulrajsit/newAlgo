/*******************************************************
            Find Anagram of two string 
            
            I/P:  s1="aabbcc"
                  s2="ccbbaa"
            O/P:  true
            
 *******************************************************/
package HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class P2_Anagram_2_String {

	// TC: O(?) SC: O(?)
	public static boolean Anagram1(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		return true;
	}

	// TC: O(n log n) SC: O(1)
	public static boolean Anagram2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] temp1 = s1.toCharArray();
		char[] temp2 = s2.toCharArray();

		Arrays.sort(temp1);
		Arrays.sort(temp2);

		for (int i = 0; i < temp1.length; i++) {
			if (temp1[i] != temp2[i])
				return false;
		}
		return true;
	}

	// TC: O(n) SC: O(n) HashMap: [ n(2*O(1)) + n(2*O(1)) ]= O(n)
	// Contain ,Put Contain ,Remove
	public static boolean Anagram3(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			Integer val = hmap.get(s1.charAt(i));
			if (!hmap.containsKey(s1.charAt(i))) {
				hmap.put(s1.charAt(i), 1);
			} else {
				hmap.put(s1.charAt(i), ++val);
			}
		}

		for (int i = 0; i < s2.length(); i++) {
			if (!hmap.containsKey(s2.charAt(i)))
				return false;
			Integer val = hmap.get(s2.charAt(i));
			if (val == 1)
				hmap.remove(s2.charAt(i));
			else
				hmap.put(s2.charAt(i), --val);
		}
		return true;
	}

	// TC: O(n) SC: O(1) DS: Array pattern 26
	public static boolean Anagram3_1(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		char[] lookup = new char[26];

		for (int i = 0; i < s1.length(); ++i)
			++lookup[s1.charAt(i) - 'a'];

		for (int i = 0; i < s2.length(); ++i) {
			if (lookup[s2.charAt(i) - 'a'] == 0)
				return false;
			--lookup[s2.charAt(i) - 'a'];
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ggyyhhjjuukkii";
		String s2 = "hhuujjyyggiikk";

		long start = System.currentTimeMillis();

		System.out.println(Anagram3(s1, s2));

		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " secs");

	}

}
