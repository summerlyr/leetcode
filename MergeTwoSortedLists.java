public class MergeTwoSortedLists {
	public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode newhead = null;
		if (l1.val <= l2.val) {
			newhead = l1;
			newhead.next = mergeTwoLists(l1.next, l2);
		} else {
			newhead = l2;
			newhead.next = mergeTwoLists(l1, l2.next);
		}
		return newhead;
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode newlist = new ListNode(0);
		ListNode newhead = newlist;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				ListNode cur = new ListNode(l1.val);
				newhead.next = cur;
				l1 = l1.next;
			} else {
				ListNode cur = new ListNode(l2.val);
				newhead.next = cur;
				l2 = l2.next;
			}
			newhead = newhead.next;
		}
		while (l1 != null) {
			ListNode cur = new ListNode(l1.val);
			newhead.next = cur;
			newhead = newhead.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			ListNode cur = new ListNode(l2.val);
			newhead.next = cur;
			newhead = newhead.next;
			l2 = l2.next;
		}
		return newlist.next;
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
