// Data_Queue.c : This file contains the 'main' function. Program execution begins and ends there.
//

#include <stdio.h>
#include <malloc.h>
#include <stdbool.h>

// Queue using DLL
struct Queue {
	struct Queue* prev;
	int data;
	struct Queue* next;
};

// TC : O(n) SC : O(1)
// Check Queue is empty or not
bool isEmpty(struct Queue* first) {
	if (first == NULL)
		return true;
	return false;
}

// TC : O(1) SC : O(1)  
// Insert in first of linked list
void enQueuefromFirstNode(struct Queue** first, int data) {
	struct Queue* temp, * temp2;
	temp2 = *first;

	temp = malloc(sizeof(struct Queue));
	if (temp == NULL)
		return;

	temp->prev = NULL;
	temp->data = data;
	temp->next = NULL;
	if (isEmpty(*first)) {
		*first = temp;
	}
	else
	{
		temp->next = *first;
		temp2->prev = temp;
		*first = temp;
	}
}

// TC : O(n) SC : O(1)
struct Queue* dQueuefromLastNode(struct Queue** first) {
	struct Queue* temp;
	temp = *first;

	if (temp == NULL)
		return;

	while (!isEmpty(*first))
	{
		if (temp->next == NULL)
			break;

		temp = temp->next;
	}
	int deleteData = temp->data;
	temp->prev->next = temp->next;

	return temp;
}
void displayQueue(struct Queue* first) {
	struct Queue* temp = first;

	while (temp != NULL)
	{
		printf("%d->", temp->data);
		temp = temp->next;
	}
}

int main() {
	struct Queue* head = NULL;
	enQueuefromFirstNode(&head, 10);
	enQueuefromFirstNode(&head, 20);
	enQueuefromFirstNode(&head, 30);
	enQueuefromFirstNode(&head, 40);
	enQueuefromFirstNode(&head, 50);

	displayQueue(head);

	printf("\n");
	printf("%d Deleted\n",dQueuefromLastNode(&head)->data);

	displayQueue(head);

	return 0;
}
