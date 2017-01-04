public class PartitionList {

	public ListNode partition(ListNode head, int x) {
		ListNode feakHead = new ListNode(0);
		feakHead.next = head;
		ListNode insert = feakHead;
		ListNode pointer = feakHead;
		while (pointer.next != null && pointer.next.val < x) {
			pointer = pointer.next;
			insert = insert.next;
		}
		while (pointer != null && pointer.next != null) {
			if (pointer.next.val >= x) {
				pointer = pointer.next;
			} else {
				ListNode t = pointer.next;
				pointer.next = pointer.next.next;
				t.next = insert.next;
				insert.next = t;
				insert = insert.next;
			}
		}
		return feakHead.next;
	}

	public ListNode partition2(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode biglist = new ListNode(0);
		ListNode biglisthead = biglist;
		ListNode list = dummy;
		while (list.next != null) {
			if (list.next.val >= x) {
				ListNode next = list.next;
				list.next = list.next.next;
				next.next = null;
				biglist.next = next;
				biglist = biglist.next;
			} else {
				list = list.next;
			}
		}
		list.next = biglisthead.next;
		return dummy.next;
	}

	public ListNode partition3(ListNode head, int x) {
		if (head == null)
			return head;
		ListNode p1 = new ListNode(0);
		ListNode p2 = new ListNode(0);
		ListNode h1 = p1;
		ListNode h2 = p2;
		while (head != null) {
			if (head.val < x) {
				p1.next = head;
				p1 = p1.next;
			} else {
				p2.next = head;
				p2 = p2.next;
			}
			head = head.next;
		}
		p2.next = null;
		// important! avoid cycle in linked list. otherwise u will get MLE.
		p1.next = h2.next;
		return h1.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
