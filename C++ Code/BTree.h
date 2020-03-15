#pragma once
#include <iostream>
using namespace std;

struct BTree
{
	struct BTree* left;
	int data;
	struct BTree* right;
};
struct BTree* newNode(int data) {
	struct BTree* root = new BTree;
	root->data = data;
	root->left = root->right = NULL;
	return root;
}
struct BTree* insert(struct BTree* root, int data) {
	struct BTree temp;
	if (root == NULL)
		return newNode(data);
	else {
		int randA = rand() % data;
		if (randA == 0) {
			BTree* lchild = insert(root->left, data);
			root->left = lchild;
		}
		else {
			BTree* rchild = insert(root->right, data);
			root->right = rchild;
		}
	}
	return root;
}
void preOrder(struct BTree* root, int nspace, char ch) {
	if (root == NULL)
		return;
	for (int i = 0; i < nspace; i++)
		cout << ' ';

	cout << root->data << "(" << ch << ")" << endl;
	preOrder(root->left, nspace + 4, 'L');
	preOrder(root->right, nspace + 4, 'R');
}
