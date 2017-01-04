
public class RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode list = head;
		if (list.next == null) {
			return null;
		}
		int length = 1;
		while (list.next != null) {
			length++;
			list = list.next;
		}
		list = head;
		if (n == length) {
			return head.next;
		}
		for (int i = 0; i < length - n - 1; i++) {
			list = list.next;
		}
		ListNode tmp = list.next.next;
		list.next = tmp;
		return head;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode feakHead = new ListNode(0);
		feakHead.next = head;
		ListNode fast = feakHead;
		ListNode slow = feakHead;
		while (n-- > 0) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return feakHead.next;
	}
}
