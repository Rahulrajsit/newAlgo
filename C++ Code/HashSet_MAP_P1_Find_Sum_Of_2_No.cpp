// HashSet_MAP_P1_Find_Sum_Of_2_No.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <chrono>
#include <algorithm>
#include <unordered_set>
using namespace std;
using namespace std::chrono;

class P1_Find_Sum_Of_2_No {
public:
	int TestCase1(int* in, int n) {
		srand((unsigned)time(0));
		int randNumber1 = 1 + rand() % n;

		for (int i = 0; i < n; i++) {  // Array defination or assign value to array
			int randNumber = 1 + rand() % n;
			*(in + i) = randNumber;
		}
		return randNumber1 + 10;
	}

	int TestCase2(int* in, int n) {
		srand((unsigned)time(0));
		int randNumber1 = 1 + rand() % n;

		for (int i = 0; i < n; i++) {  // Array defination or assign value to array
			int randNumber = 1 + rand() % n;
			*(in + i) = randNumber;
		}
		return 0;
	}

	// TC : O(n^2) SC : O(1)
	bool findSum1(int* in, int n, int pairSum) {
		for (int i = 0; i < n - 1; i++) {
			int diffPairSum = pairSum - in[i];  // Find the diff of pair in position i+1 array 
			for (int j = i + 1; j < n; j++) {
				if (diffPairSum == in[j])
					return true;
			}
		}
		return false;
	}
	int searchAlgo1(int* in, int l, int n, int diffPairSum) {
		int left = l, right = n - 1;
		while (left < right) {
			int mid = left + ((right - left) / 2);
			cout << "Val " << *(in + mid) << ' ' << endl;

			if (in[mid] == diffPairSum)
				return mid;
			else if (in[mid] < diffPairSum)
				left = mid + 1;
			else
				right = mid;
		}
		if (in[left] == diffPairSum)
			return left;

		return INTMAX_MAX;
	}
	// TC : O(n log n) SC : O(1)
	bool findSum2(int* in, int n, int pairSum) {
		sort(in, in + n);
		for (int i = 0; i < n; i++) {
			cout << *(in + i) << ' ';
		}
		cout << endl;

		for (int i = 0; i < n; i++) {
			int diffPairSum = pairSum - in[i];  // Find the diff of pair in position i+1 array 
			int l = i + 1;
			int x = searchAlgo1(in + l, l, n, diffPairSum);
			if (x > -1)
				return true;
		}
		return false;
	}

	bool findSum3(int* in, int n, int pairSum) {
		unordered_set<int> hset;           // unordered and take O(1) if use set then it take O(log n) use BST

		for (int i = 0; i < n; i++) {
			int temp = pairSum - in[i];

			if (hset.find(temp) == hset.end())
				hset.insert(in[i]);
			else
				return true;
		}
		return false;
	}

	// TC : O(n) SC : O(1)
	void Display(int* in, int n) {
		for (int i = 0; i < n; i++) {
			cout << *(in + i) << ' ';
		}
		cout << endl;
	}
};

int main(int args, char** argv)
{
	P1_Find_Sum_Of_2_No obj;
	int n = atoi(argv[1]);
	int* in = new int[n];  // Array memory allocation or declaration

	int pairSum = obj.TestCase1(in, n);
	obj.Display(in, n);
	cout << "Pair Sum: " << pairSum << endl;

	auto start = high_resolution_clock::now();
	cout << "Search value is:" << boolalpha << obj.findSum3(in, n, pairSum) << endl;
	auto stop = high_resolution_clock::now();

	auto elapsed_seconds = stop - start;
	cout << "Time taken by function: "
		<< elapsed_seconds.count() << " seconds" << endl;


	//Deallocation of memory
	delete[] in;


	cout << endl;
	return 0;
}
