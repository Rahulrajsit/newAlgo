// P2_CountZero.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <stdlib.h>
#include <chrono>
using namespace std::chrono;
using namespace std;

class countZero {
	int size;
public:
	void TestCase1(int* in, int n) {
		int i;
		srand((unsigned)time(0));
		int randomLength = (rand() % n);
		for (i = 0; i < randomLength; i++)
			in[i] = 0;
		while (i < n)
			in[i++] = 1 + (rand() % n);
	}

	//TC : O(n) SC : O(1)
	int countZero1(int* in, int n) {
		int i = 0;
		for (i = 0; i < n; i++) {
			if (in[i] != 0) {
				break;
			}
		}
		return i;
	}

	//TC : O(log n) SC : O(1)
	int countZero2(int* in, int n) {
		int left = 0, right = n - 1;
		while (right - left > 1) {
			int mid = left + ((right - left) / 2);
			if (in[mid] == 0)
				left = mid;
			if (in[mid] > 0)
				right = mid - 1;
		}
		if (in[right] == 0)
			return right + 1;
		else if (in[left] == 0)
			return left + 1;
		else
			return 0;
	}

	void Display(int* in, int n) {
		for (int i = 0; i < n; i++)
			cout << in[i] << ' ';
		cout << endl;
	}
};

int main(int args, char** argv)
{
	countZero obj;
	int n = atoi(argv[1]);
	int* in = new int[n];

	obj.TestCase1(in, n);

	//obj.Display(in, n);

	cout << endl;

	auto start = high_resolution_clock::now();
	cout << "Number Of Zero's: " << obj.countZero1(in, n) << endl;
	auto stop = high_resolution_clock::now();

	auto elapsed_seconds = stop - start;
	cout << "Time taken by function: "
		<< elapsed_seconds.count() << " seconds" << endl;


	return 0;
}
