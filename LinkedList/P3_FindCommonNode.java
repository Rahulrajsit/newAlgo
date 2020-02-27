package LinkedList;

import java.util.HashSet;

public class P3_FindCommonNode {

	// Complete scan
	// TC : O(n*m) SC : O(1)
	public static ListNode findCommonNode1(ListNode head1, ListNode head2) {
		for (ListNode current1 = head1.next; current1 != null; current1 = current1.next) {
			for (ListNode current2 = head2.next; current2 != null; current2 = current2.next) {
				if (current1 == current2)
					return current1;
			}
		}
		return null;
	}

	// TC : O(n+m) SC : O(n)
	// Here we are starting from dummy node so first we have to move one step
	public static ListNode findCommonNode2(ListNode head1, ListNode head2) {
		HashSet<ListNode> hset = new HashSet<ListNode>();

		// TC : O(n)
		// Insert address in HashSet
		for (ListNode current2 = head2.next; current2 != null; current2 = current2.next) {
			hset.add(current2);
		}

		// TC : O(m)
		// Check common node
		for (ListNode current1 = head1.next; current1 != null; current1 = current1.next) {
			if (hset.contains(current1))
				return current1;
		}
		return null;
	}

	// TC : O(n) SC : O(1)
	// Calculate length of list
	private static int length(ListNode head) {
		int n = 0;
		for (ListNode current = head.next; current != null; current = current.next) {
			++n;
		}
		return n;
	}

	// TC : O(n+m) SC : O(1)
	// TC : O(n+m) ~ [length + move + scan]
	public static ListNode findCommonNode41(ListNode head1, ListNode head2) {

		int n = length(head1); // TC : O(n)
		int m = length(head2); // TC : O(n)

		ListNode current1 = head1, current2 = head2;

		// TC : O(n)
		while (n > m) {
			current1 = current1.next;
			--n;
		}
		// TC : O(m)
		while (m > n) {
			current2 = current2.next;
			--m;
		}
		// TC : O(n)
		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1;
	}

	// TC : O(n+m) SC : O(1)
	public static ListNode findCommonNode42(ListNode head1, ListNode head2) {
		ListNode current1 = head1, current2 = head2;

		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
			if (current1 == null && current2 == null)
				break;
			if (current1 == null)
				current1 = head2;
			if (current2 == null)
				current2 = head1;
		}
		return current1;
	}

	// TC : O(n+m) SC : O(1)
	// Here i am moving one by one node and check both are same or not.
	// Then if anyone reach to null then 1 will point to 2 and vice versa 
	public static ListNode findCommonNode421(ListNode head1, ListNode head2) {
		ListNode current1 = head1, current2 = head2;

		while (current1 != current2) {
			current1 = (current1 != null) ? current1.next : head2;
			current2 = (current2 != null) ? current2.next : head1;
		}
		return current1;
	}

	// Both the Linked list contain null so result will be null only
	// never meet each other
	private static void testCase1(int n, int m) {
		ListNode head1 = LinkedListUtils.createList(n);
		ListNode head2 = LinkedListUtils.createList(m);

		// call to find Common node
		System.out.println(findCommonNode42(head1, head2));

		// Print head1 and head2
		LinkedListUtils.display(head1);
		LinkedListUtils.display(head2);
		System.out.println();
	}

	private static void testCase2(int n, int m) {
		ListNode head1 = LinkedListUtils.createList(n);
		ListNode head2 = LinkedListUtils.createList(m);

		// Get any Random node from head1 or list1
		ListNode tmp = P4_RandomNode.randomNode3(head1);
		System.out.println(tmp);

		ListNode current = head2;
		// Traverse the head2 till end and and end will point to random node of head1
		while (current.next != null)
			current = current.next;

		current.next = tmp;

		// call to find Common node
		System.out.println(findCommonNode421(head1, head2));

		// Print head1 and head2
		LinkedListUtils.display(head1);
		LinkedListUtils.display(head2);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		testCase1(n, m);
		testCase2(n, m);

	}

}
