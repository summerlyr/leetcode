/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class SortList {
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

		}
		ListNode h2 = sortList(slow.next);
		slow.next = null;

		return merge(sortList(head), h2);

	}

	public ListNode merge(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head1;
		ListNode head2;
		if (l1.val <= l2.val) {
			head1 = l1;
			head2 = l2;
		} else {
			head1 = l2;
			head2 = l1;
		}

		while (head1.next != null && head2 != null) {
			if (head2.val >= head1.val && head2.val <= head1.next.val) {

				ListNode t = head1.next;
				ListNode t2 = head2;
				head2 = head2.next;
				head1.next = t2;
				head1.next.next = t;
				head1 = head1.next;

			} else {
				head1 = head1.next;
			}
		}
		if (head1.next == null) {
			head1.next = head2;
		}
		if (l1.val <= l2.val) {
			return l1;
		} else {
			return l2;
		}

	}
}