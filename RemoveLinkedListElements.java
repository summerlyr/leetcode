public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;

		ListNode feakHead = new ListNode(0);
		feakHead.next = head;
		ListNode current = feakHead.next;
		ListNode back = feakHead;
		while (current != null) {
			if (current.val == val) {
				back.next = current.next;
				current = current.next;
			} else {
				back = back.next;
				current = current.next;
			}
		}
		return feakHead.next;
	}

	public ListNode removeElements2(ListNode head, int val) {
		if (head == null)
			return head;
		head.next = removeElements(head.next, val);
		if (head.val == val)
			return head.next;
		else
			return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
