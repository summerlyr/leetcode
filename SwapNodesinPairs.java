public class SwapNodesinPairs {

	public ListNode swapPairs(ListNode head) {
		ListNode result = new ListNode(0);
		result.next = head;
		ListNode cur = result;
		while (cur.next != null && cur.next.next != null) {
			cur.next = swap(cur.next, cur.next.next);
			cur = cur.next.next;
		}
		return result.next;

	}

	public ListNode swap(ListNode node1, ListNode node2) {
		node1.next = node2.next;
		node2.next = node1;
		return node2;
	}

	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode dummyhead = dummy;
		while (dummyhead.next != null && dummyhead.next.next != null) {
			ListNode next = dummyhead.next.next;
			dummyhead.next.next = next.next;
			next.next = dummyhead.next;
			dummyhead.next = next;
			dummyhead = dummyhead.next.next;
		}
		return dummy.next;
	}

	public ListNode swapPairs3(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newhead = head.next;
		head.next = swapPairs(newhead.next);
		newhead.next = head;
		return newhead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
