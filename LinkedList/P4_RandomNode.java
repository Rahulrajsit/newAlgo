package LinkedList;

import java.util.HashMap;
import java.util.Random;

public class P4_RandomNode {

	// TC : O(n) SC : O(1)
	// complete scan
	public static ListNode randomNode1(ListNode head) {
		int n = 0;
		// TC : O(n) SC : O(1)
		// scan complete the node to count total length
		for (ListNode current = head.next; current != null; current = current.next) {
			n++;
		}

		Random r = new Random();

		// Generate random no. and then we have to traverse the node to that random node
		// length
		int random = r.nextInt(n);

		// System.out.println(random);

		// TC : O(n-k) ~ O(n) SC : O(1)
		// Traverse the node to that random node length
		ListNode current = head.next;
		for (int i = 0; i < random; ++i)
			current = current.next;

		// Return that node
		return current;
	}

	// uniformity not maintain
	// Restriction ~ you have to in one scan means TC:O(n)
	// TC : O(n) SC : O(1)
	public static ListNode randomNode2(ListNode head) {
		// random point to head node
		ListNode random = head.next;

		Random r = new Random();

		for (ListNode current = random.next; current != null; current = current.next) {

			// Here i am giving
			// uniformity not maintain because every time i am passing 2 ~ r.nextInt(2)

			// so getting each node probability depend on last node
			// prob. distribution is (1),(1/2,1/2),(1/2,1/4,1/4)... so every time getting
			// first node prob decrease
			// if we change t
			if (r.nextInt(2) == 1) // random will generate 0 or 1 but when it will generate 1 only on that time
				random = current;
		}
		return random;
	}

	// Restriction ~ you have to in one scan means TC:O(n)
	// TC : O(n) SC : O(1)
	public static ListNode randomNode3(ListNode head) {
		ListNode random = head.next;
		Random r = new Random();
		int n = 1;
		// Every time total no. of occurrence is increasing so probability distribution is same for each node
		// uniformity maintain and no prediction  
		for (ListNode current = random.next; current != null; current = current.next) {
			++n;
			if (r.nextInt(n) == 0)
				random = current;
		}
		return random;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		// getting n from command line AND create that no. of node
		ListNode head = LinkedListUtils.createList(n);

		// for display the node we have to create a Linked list utils
		LinkedListUtils.display(head);

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		for (int i = 1; i <= 10000; ++i) {
			// Generate random no. of node and we have to follow the random generator rules
			// 1.uniform and 2.No prediction
			ListNode random = randomNode2(head);
			String s = random.toString().split("@")[1];
			if (hmap.get(s) == null)
				hmap.put(s, 1);
			else
				hmap.put(s, hmap.get(s) + 1);
			// System.out.println(s);
		}
		System.out.println("\n" + hmap);

	}

}
