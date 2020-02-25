// P3_CeilValue.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <chrono>
#include <algorithm>
#include <chrono>
using namespace std;
using namespace std::chrono;

class CeilValue {

public:
	// TC : O(n log n)
	int TestCase1(int* in, int n) {
		srand((unsigned)time(0));
		int randomGenrator = rand() % n;

		for (int i = 0; i < n; i++) {  // TC : O(n)
			int randomGenrator2 = 1 + rand() % n;
			in[i] = randomGenrator2;
		}
		sort(in, in + n);     //TC : O(n log n)
		return randomGenrator;
	}

	//TC : O(n) SC : O(1)
	int Ceil1(int* in, int n, int findCeil) {
		for (int i = 0; i < n; i++) {
			if (in[i] >= findCeil)
				return in[i];
		}
		return INTMAX_MAX;
	}

	//TC : O(log n) SC : O(1)
	int Ceil2(int* in, int n, int findCeil) {
		int left = 0, right = n - 1;
		while (left < right) {
			int mid = left + ((right - left) / 2);
			if (in[mid] == findCeil)
				return in[mid];
			else if (in[mid] < findCeil)
				left = mid + 1;
			else
				right = mid;
		}
		if (in[left] >= findCeil)
			return in[left];

		return INTMAX_MAX;
	}
	void Display(int* in, int n, int findCeil) {
		for (int i = 0; i < n; i++) {
			cout << in[i] << ' ';
		}
		cout << endl;
	}
};
int main(int args, char** argv)
{
	CeilValue obj;
	int n = atoi(argv[1]);
	int* in = new int[n];

	cout << "Find ceil Value:" << obj.TestCase1(in, n);
	int findCeil = obj.TestCase1(in, n);
	cout << endl;

	auto start = high_resolution_clock::now();
	cout << "The Ceil value:" << obj.Ceil2(in, n, findCeil) << endl;
	auto stop = high_resolution_clock::now();

	auto elapsed_seconds = stop - start;
	cout << "Time taken by function: "
		<< elapsed_seconds.count() << " seconds" << endl;


	obj.Display(in, n, findCeil);

	delete[] in; // deallocation of in array
	
	return 0;
}
