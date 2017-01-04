public class ReverseLinkedListII {

	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode feakHead = new ListNode(0);
		feakHead.next = head;
		ListNode current = feakHead;
		ListNode list = feakHead;
		ListNode front = feakHead;
		int s = m;
		while (s > 1) {
			front = front.next;
			current = current.next;
			list = list.next;
			s--;
		}
		current = current.next;
		list = list.next;
		if (current.next == null || m == n) {
			return head;
		}
		current = current.next;
		int i = n - m;
		while (i > 0) {
			ListNode t = current;
			current = current.next;
			t.next = front.next;
			front.next = t;
			list.next = current;
			i--;
		}
		return feakHead.next;
	}

	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if (head == null || m == n)
			return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode pre = dummyHead;
		for (int i = 0; i < m - 1; i++)
			pre = pre.next;
		ListNode start = pre.next;
		ListNode then = start.next;
		for (int i = 0; i < n - m; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}
		return dummyHead.next;
	}

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		list.next.next.next = new ListNode(4);
		list.next.next.next.next = new ListNode(5);
		ReverseLinkedListII rll = new ReverseLinkedListII();
		rll.reverseBetween(list, 2, 4);

	}

}
