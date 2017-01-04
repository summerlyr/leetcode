public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int addition = 0;
		ListNode result = new ListNode(0);
		ListNode resultH = result;
		while (l1 != null && l2 != null) {
			int r = l1.val + l2.val + addition;
			addition = r / 10;
			result.next = new ListNode(r % 10);
			result = result.next;
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int r = l1.val + addition;
			addition = r / 10;
			result.next = new ListNode(r % 10);
			result = result.next;
			l1 = l1.next;
		}
		while (l2 != null) {
			int r = l2.val + addition;
			addition = r / 10;
			result.next = new ListNode(r % 10);
			result = result.next;
			l2 = l2.next;
		}
		if (addition != 0) {
			result.next = new ListNode(addition);
		}
		return resultH.next;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		int nextval = 0;
		while (l1 != null || l2 != null) {
			int curval = nextval;
			if (l1 != null) {
				curval = l1.val + curval;
				l1 = l1.next;
			}
			if (l2 != null) {
				curval = l2.val + curval;
				l2 = l2.next;
			}
			nextval = curval / 10;
			curval = curval % 10;
			result.next = new ListNode(curval);
			result = result.next;
		}
		if (nextval != 0)
			result.next = new ListNode(1);
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
