// BinaryTree.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include <iostream>
#include <chrono>
#include <queue>
#include <stack>
#include "BTree.h"
using namespace std;

class BTreeAlgo {
public:
	int TreeSize1(BTree* root);
	int TreeSize2(BTree* root);
	int TreeSize3(BTree* root);
};
// USing Stack
int BTreeAlgo::TreeSize1(BTree* root) {
	BTree* temp = NULL;
	temp = root;
	int count = 0;
	stack<BTree*> s;
	s.push(temp);
	while (temp->left != NULL)
	{
		s.push(root->left);
		temp = temp->left;
	}

	while (!s.empty())
	{
		temp = s.top();
		s.pop();
		if (temp->left != NULL)
			s.push(temp->left);
		if (temp->right != NULL)
			s.push(temp->right);
		++count;
	}
	return count;
}
// using recursion 
int BTreeAlgo::TreeSize2(BTree* root) {
	if (root == NULL)
		return 0;
	if (root->left == NULL && root->right == NULL)
		return 1;

	int lchild = TreeSize1(root->left);
	int rchild = TreeSize1(root->right);

	return lchild + rchild + 1;
}
// Using Queue
int BTreeAlgo::TreeSize3(BTree* root) {
	BTree* temp = NULL;
	int count = 0;
	queue<BTree*> q;
	q.push(root);
	while (!q.empty())
	{
		temp = q.front();
		q.pop();
		count++;

		if (temp->left != NULL)
			q.push(temp->left);
		if (temp->right != NULL)
			q.push(temp->right);
	}
	return count;
}

int main(int argc, char** argv)
{
	struct BTree* root = NULL;
	int n = atoi(argv[1]);

	srand((unsigned)time(0));

	int i = 1;
	int data1 = 1 + rand() % n;
	root = insert(root, data1);

	while (++i <= n)
	{
		int data = 1 + rand() % n;
		insert(root, i + 1);
	}

	preOrder(root, 0, 'M');

	BTreeAlgo obj;
	cout << "Tree size: " << obj.TreeSize1(root) << endl;
	cout << "Tree size: " << obj.TreeSize2(root) << endl;
	cout << "Tree size: " << obj.TreeSize3(root) << endl;
	return 0;
}
