public class ReverseNodesinkGroup {

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

	public ListNode reverseKGroup(ListNode head, int k) {
		int start = 1;
		int end = start + k - 1;
		int length = 0;
		ListNode list = head;
		while (list != null) {
			length++;
			list = list.next;
		}
		list = head;
		while (end <= length) {

			list = reverseBetween(list, start, end);
			start = start + k;
			end = end + k;

		}
		return list;
	}

}
