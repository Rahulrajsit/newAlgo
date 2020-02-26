// P4_2D_FindData_Sorted.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <array>
#include <vector>
#include <chrono>
#include <algorithm>
using namespace std;
using namespace std::chrono;

class FindDataIn2D {
public:

	// TC : O(n^2) SC : O(n)
	int TestCase1(int** in, int n) {
		srand((unsigned)time(0));             // take time as seed value
		int r = 2 + rand() % n;               // generate random value
		int randSearch = 10 + rand() % n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				*(*(in + i) + j) = r++;
			}
		}
		return randSearch;
	}

	// TC : O(n^2) SC : O(1)
	int searchValue1(int** in, int n, int searchVal) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] == searchVal)
					return in[i][j];
			}
		}
		return INTMAX_MAX;
	}

	// TC : O(log n) SC : O(1)
	int searchAlgo1(int* in, int n, int searchVal) {
		int left = 0, right = n - 1;
		while (left < right) {
			int mid = left + ((right - left) / 2);
			if (in[mid] == searchVal)
				return mid;
			else if (in[mid] < searchVal)
				left = mid + 1;
			else
				right = mid;
		}
		if (in[left] == searchVal)
			return left;

		return INTMAX_MAX;
	}
	// TC : O(n) SC : O(1)
	int searchAlgo2(int* in, int n, int searchVal) {
		for (int i = 0; i < n; i++) {
			if (in[i] == searchVal)
				return i;
		}
		return INTMAX_MAX;
	}
	// TC : O(n log n) SC : O(1)
	int searchValue2(int** in, int n, int searchVal) {  // Getting 2D array
		for (int i = 0; i < n; i++) {
			int x = searchAlgo1(in[i], n, searchVal);   // Passing 1D array and here i am passing in[0],in[1]... 1 by 1 
			if (x > -1) {
				cout << "Value is:" << in[i][x] << endl;
				return in[i][x];
			}
		}
		return INTMAX_MAX;
	}

	//Finding perticular row where my value is available
	//Or you can say finding Ceil value("For searchVal")
	// Think in[0][4],in[1][4],in[2][4],in[3][4],in[4][4] is your new array and find ceil value 
	//TC : O(log n) SC: O(1)
	int findCandidateRow(int** in, int n, int searchVal) {
		int left = 0, right = n - 1;
		while (left < right) {
			int mid = left + ((right - left) / 2); // Avoid Integer out of range
			int temp = in[mid][n - 1];
			if (temp == searchVal)
				return mid;
			if (temp < searchVal)
				left = mid + 1;
			else
				right = mid;
		}
		if (in[left][n - 1] >= searchVal)
			return left;

		return INTMAX_MAX;
	}
	// TC : O(log n) SC : O(1)
	int searchValue3(int** in, int n, int searchVal) {  // Getting 2D array

		int r = findCandidateRow(in, n, searchVal);  //Here i am passing complete 2D array
		cout << "The row is: " << r << endl;   // r will give me that perticular row in which i have to find value

		if (r < 0)   // if r return -1 means ceil not exist 10,20,30,45,50  find ceil of 55 so it will return -1
			return INTMAX_MAX;

		int x = searchAlgo1(in[r], n, searchVal);  //TC : O(log n) SC:(1)

		if (x > -1) {
			cout << "Value is:" << in[r][x] << endl;
			return in[r][x];
		}
		return INTMAX_MAX;
	}

	// 
	// TC : O(log n) SC : O(1)
	int searchValue4(int** in, int n, int searchVal) {
		int left = 0, right = n * n - 1;
		while (left <= right) {
			int mid = left + ((right - left) / 2); // Avoid Integer out of range

			int tmp = in[mid / n][mid % n];  // Use to find 2D array index Ex:- | 123 | 547 | 789
											 // l=0,r=8 m=4 temp=in[4/3][4%3] ~ in[1][1] = 5 Ans.

			if (tmp == searchVal)
				return in[mid / n][mid % n];
			if (searchVal < tmp)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return INTMAX_MAX;
	}

	// TC : O(n^2) SC : O(1)
	void Display(int** in, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cout << *(*(in + i) + j) << ' ';
			}
			cout << endl;
		}
		cout << endl;
	}

};

int main(int args, char** argv)
{
	FindDataIn2D obj;
	int n = atoi(argv[1]);

	// 2D declaration, first i create 1D pointer array and inside it again 1D pointer array   
	int** in = new int* [n];        //in is double pointer
	for (int i = 0; i < n; ++i)     //inside 1D pointer array i create 1D pointer array one by one index
		in[i] = new int[n];         // m/r is allocated for next 1D array 

	cout << "Find value in 2D matrix : " << obj.TestCase1(in, n) << endl;
	int searchVal = obj.TestCase1(in, n);

	//obj.Display(in, n);

	auto start = high_resolution_clock::now();
	cout << "Search value is:" << obj.searchValue4(in, n, searchVal) << endl;
	auto stop = high_resolution_clock::now();

	auto elapsed_seconds = stop - start;
	cout << "Time taken by function: "
		<< elapsed_seconds.count() << " seconds" << endl;




	// TC : O(n)
	//Deallocation of memory for that thing first you have to dellocate in[i] location then in
	for (int i = 0; i < n; i++) {
		delete in[i];             // one by one i as deleting i'th dynmic array
	}
	delete[]in;

	cout << endl;

	return 0;
}
