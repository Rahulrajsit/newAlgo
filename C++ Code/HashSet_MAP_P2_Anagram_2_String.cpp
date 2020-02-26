// HashSet_MAP_P2_Anagram_2_String.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <string>
#include <unordered_map>
#include <algorithm>
using namespace std;

class Anagram_2_String {
public:

	// TC : O(?) SC : O(?)
	bool Anagram1(string str1, string str2) {
		if (str1.size() != str2.size())
			return false;
		return false;
	}

	// TC : O(n log n) SC : O(1)
	bool Anagram2(string str1, string str2) {
		if (str1.size() != str2.size())
			return false;

		sort(str1.begin(), str1.end());         // TC : O(n) SC : O(1)
		sort(str2.begin(), str2.end());         // TC : O(n) SC : O(1)

		for (int i = 0; i < str1.size(); i++) { // TC : O(n) SC : O(1)
			if (str1[i] != str2[i])
				return false;
		}
		return true;
	}

	// TC: O(n) SC: O(n) HashMap: [ n(2*O(1)) + n(2*O(1)) ]= O(n)
	// Contain ,Put Contain ,Remove
	
  bool Anagram3(string str1, string str2) {
		if (str1.size() != str2.size())
			return false;

		// TC : O(1) for every operation and unordered way
		unordered_map<char, int> hmap; //  map take O(log n)and use BST & ordered

		//Increment hmap value by 1 here it will take char 1-1 and 
		for (const char& c : str1) {
			hmap[c]++;
		}

		for (auto& e : hmap) {
			cout << '{' << e.first << ", " << e.second << '}' << '\n';
		}

		//If hmap key value is zero then return false otherwise decement value by 1
		for (const char& c : str2) {
			if (hmap[c] < 1)
				return false;
			hmap[c]--;
		}

		return true;
	}

	// TC: O(n) SC: O(n) DS: Array pattern 26
  
	bool Anagram3_1(string str1, string str2) {
		if (str1.size() != str2.size())
			return false;

		int lookup[26] = { 0 };

		for (int i = 0; i < str1.size(); ++i)
			++lookup[str1[i] - 'a'];

		for (int i = 0; i < str2.size(); ++i) {
			if (lookup[str2[i] - 'a'] == 0)
				return false;
			--lookup[str2[i] - 'a'];
		}
		return true;
	}
};

int main()
{
	Anagram_2_String obj;
	string str1 = "aahh";
	string str2 = "hjaa";

	/*cout << "Enter 1st string: " << endl;
	getline(cin, str1);

	cout << "Enter 2st string: " << endl;
	getline(cin, str2);*/


	cout << "Is Anagram: " << boolalpha << obj.Anagram3_1(str1, str2);
	cout << endl;

	return 0;
}
