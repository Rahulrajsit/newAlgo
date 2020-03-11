// BSTree.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <chrono>
#include "BST.h"

using namespace std;
class MyClass
{
public:
	bool search(BSTNode* root, int data);
	int ceil(BSTNode* root, int data);
};
bool MyClass::search(BSTNode* root, int data) {
	while (root != NULL)
	{
		if (root->data == data)
			return true;
		if (data < root->data)
			root = root->left;
		else
			root = root->right;
	}
	return false;
}
int MyClass::ceil(BSTNode* root, int data) {
	int res = INT16_MIN;
	while (root != NULL)
	{
		if (root->data == data)
			return data;
		if (data < root->data) {
			res = root->data;
			root = root->left;
		}
		else
			root = root->right;

	}
	return res;
}

int main(int args, char** argv)
{
	struct BSTNode* root = NULL;
	srand((unsigned)time(0));


	int n = atoi(argv[1]);
	int i = 1;
	int data1 = 1 + rand() % n;
	root = insert(root, data1);

	while (++i <= 10)
	{
		int data = 1 + rand() % n;
		insert(root, data);
	}

	preOrder(root, 0, 'M');
	//inOrder(root);
	cout << endl;
	//preOrder(root);
	cout << endl;
	//postOrder(root);

	MyClass obj;
	int data = 5 + rand() % n;
	cout << "Data is: " << data << endl;
	cout << boolalpha << obj.search(root, data) << endl;
	cout << "Ceil value is: " << obj.ceil(root, data);

	return 0;
}
