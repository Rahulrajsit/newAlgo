package LinkedList;

import java.util.HashSet;

public class P2_DetectLoop {

	// TC : O(n) SC : O(n)
	public static boolean detectLoop1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (ListNode current = head.next; current != null; current = current.next) {
			if (hset.contains(current))
				return true;
			hset.add(current);
		}
		return false;
	}

	// TC : O(n) SC : O(1)
	public static boolean detectLoop2(ListNode head) {
		// for (ListNode current = head.next; current != null; current = current.next) {
		// if (current.next < 0)
		// return true;
		// current.next *= -1;
		// }
		return false;
	}

	// TC : O(n) SC : O(1)
	// slow is moving 1 by 1 And fast by 2 step so TC:[n+2n]~ O(3n) = O(n)
	public static boolean detectLoop31(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return false;
			fast = fast.next.next;
		} while (slow != fast);
		return true;
	}

	// TC : O(n) SC : O(1)
	// slow is moving 1 by 1 And fast by 3 step so TC:[n+3n]~ O(4n) = O(n)
	public static boolean detectLoop32(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;

		do {
			if (fast == null || fast.next == null || fast.next.next == null)
				return false;
			if (fast.next == slow || fast.next.next == slow)
				return true;
			fast = fast.next.next.next;
			slow = slow.next;
		} while (slow != fast);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		
		// N node creation with loop
		ListNode head = LinkedListUtils.createListwithLoop(n);
		// Node display with loop
		LinkedListUtils.displayWithLoop(head);

		System.out.println(detectLoop1(head));
		System.out.println(detectLoop31(head));
		System.out.println(detectLoop32(head));
		System.out.println();
        
		// N node creation without loop
		head = LinkedListUtils.createList(n);
		// Node display without loop
		LinkedListUtils.display(head);
		
		System.out.println(detectLoop1(head));
		System.out.println(detectLoop31(head));
		System.out.println(detectLoop32(head));
	}

}
