package LinkedList;

import java.util.HashSet;

public class P6_1_FindLoopNode {

	// TC : 3n ~ O(n) SC : O(1)
	public static ListNode detectLoop(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return null;
			fast = fast.next.next;
		} while (slow != fast);
		return slow;
	}

	// TC : O(n) SC : O(n)
	public static ListNode FindLoopNode1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();

		for (ListNode current = head.next; current != null; current = current.next) {
			if (hset.contains(current))
				return current;
			hset.add(current);
		}
		return null;
	}

	// TC : O(n) SC : O(1)
	// Java not support negative address
	public static ListNode FindLoopNode2(ListNode head) {

		/*
		 * for (ListNode current = head.next; current != null; current = current.next) {
		 * if (current.next < 0) return current; current.next *= -1; }
		 */
		return null;

	}

	// TC : 3n+n+2n ~ O(n) SC : O(1)
	// Java not support negative address
	public static ListNode FindLoopNode3(ListNode head) {
		ListNode slow, current, lengthNode;
		int count = 0;
		// TC : O(3n)
		lengthNode = current = detectLoop(head);
		slow = head;

		lengthNode = lengthNode.next;
		
		// TC : O(n)
		while (lengthNode != current) {
			count++;
			lengthNode = lengthNode.next;
		}
		System.out.println("length " + count);
		return null;

	}

	// TC : 4n ~ O(n) SC : O(1)
	public static ListNode FindLoopNode4(ListNode head) {
		ListNode slow, current;
		// TC : O(3n)
		current = detectLoop(head);
		slow = head;
		// TC : O(n)
		while (slow != current) {
			slow = slow.next;
			current = current.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);

		// N node creation with loop
		ListNode head = LinkedListUtils.createListwithLoop(n);
		// Node display with loop
		LinkedListUtils.displayWithLoop(head);

		long start = System.currentTimeMillis();
		System.out.println("loop is at: " + FindLoopNode3(head).data);
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " secs");

	}

}
