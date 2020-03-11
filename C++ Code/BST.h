#pragma once

#include <iostream>
#include <chrono>
using namespace std;

struct BSTNode {
	struct BSTNode* left;
	int data;
	struct BSTNode* right;
};
struct BSTNode* newNode(int item)
{
	struct BSTNode* root = new BSTNode;
	root->data = item;
	root->left = root->right = NULL;
	return root;
}
struct BSTNode* insert(struct BSTNode* root, int data)
{
	if (root == NULL)
		return newNode(data);
	else
	{
		if (data < root->data) {
			BSTNode* lchild = insert(root->left, data);
			root->left = lchild;
		}
		else {
			BSTNode* rchild = insert(root->right, data);
			root->right = rchild;
		}
	}
	return root;
}
void preOrder(struct BSTNode* root, int nspace, char ch) {
	if (root == NULL)
		return;
	for (int i = 0; i < nspace; i++)
		cout << ' ';

	cout << root->data << "(" << ch << ")" << endl;
	preOrder(root->left, nspace + 4, 'L');
	preOrder(root->right, nspace + 4, 'R');
}
void inOrder(struct BSTNode* root) {
	if (root == NULL)
		return;

	inOrder(root->left);
	cout << root->data << ends;
	inOrder(root->right);
}
void preOrder(struct BSTNode* root) {
	if (root == NULL)
		return;

	cout << root->data << ends;
	preOrder(root->left);
	preOrder(root->right);
}
void postOrder(struct BSTNode* root) {
	if (root == NULL)
		return;

	postOrder(root->left);
	postOrder(root->right);
	cout << root->data << ends;
}
