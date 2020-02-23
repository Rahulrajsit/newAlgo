#include <iostream>
#include <iomanip>
#include <chrono>
#include <algorithm>
using namespace std;
using namespace std::chrono;

class FindDuplicate {
public:
	void TestCase1(int* arr, int n) {
		int i = 0;
		for (i = 0; i < n - 1; i++) {
			arr[i] = i + 1;
		}
		arr[i] = i;
	}

	void TestCase2(int* arr, int n) {
		int i = 0;
		for (i = 0; i < n - 1; i++) {
			arr[i] = n - 1 - i;
		}
		arr[i] = i;
	}

	// TC: O(n^2) SC: O(1)
	int findDuplicate1(int* in, int n) {
		int i = 0, j = 0;
		for (i = 0; i < n - 1; i++) {        // TC: O(n)
			for (j = i + 1; j < n; j++) {    // TC: O(n) * O(n) = O(n^2)
				if (in[i] == in[j])
					return in[i];
			}
		}
		return  INTMAX_MAX;
	}

	// TC: O(n log n) SC: O(1)
	int findDuplicate2(int* in, int n)
	{
		sort(in, in + n); //Due to sort its takes more time internally but TC: O(n log n)

		for (int i = 0; i < n - 1; i++) {  // TC: O(n)
			if (in[i] == in[i + 1])
				return in[i];
		}
		return  INTMAX_MAX;
	}

	// TC: O(n) SC: O(n)
	int findDuplicate3(int* in, int n) {
		int* auxArr = new int[n];
		for (int i = 0; i < n; i++) {
			*(auxArr + i) = 0;    // Initialize all elements to zero.
		}
		for (int i = 0; i < n; i++) {
			if (auxArr[in[i]] != 0)
				return in[i];
			auxArr[in[i]] = 1;
		}
		return INTMAX_MAX;
	}

	// TC: O(n) SC: O(n)
	int findDuplicate4(int* in, int n) {
		for (int i = 0; i < n; i++) {
			int temp = abs(in[i]);
			if (in[temp] < 0)
				return temp;
			in[temp] = in[temp] * -1;
		}
		return INTMAX_MAX;
	}
};
int main(int argc, char** argv)
{
	FindDuplicate obj;

	int n = atoi(argv[1]);
	int* in = new int[n];
	obj.TestCase1(in, n);

	/*for (int i = 0; i < n; i++) {
		cout << in[i] << ' ';
	}*/
	cout << endl;

	auto start = high_resolution_clock::now();
	cout << "Duplicate value is:" << obj.findDuplicate4(in, n) << endl;
	auto stop = high_resolution_clock::now();

	auto duration = duration_cast<microseconds>(stop - start);
	cout << "Time taken by function: "
		<< duration.count() << " microseconds" << endl;

	delete[] in;
	return 0;
}