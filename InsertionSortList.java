public class InsertionSortList {

	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode feakHead = new ListNode(0);
		feakHead.next = new ListNode(head.val);
		ListNode result = feakHead;
		while (head.next != null) {
			head = head.next;
			while (result.next != null) {

				if (result.next.val >= head.val) {
					ListNode t = new ListNode(head.val);
					t.next = result.next;
					result.next = t;
					break;
				}
				result = result.next;
			}
			if (result.next == null) {
				result.next = new ListNode(head.val);
			}
			result = feakHead;
		}
		return feakHead.next;
	}

	public ListNode insertionSortList2(ListNode head) {
		if (head == null)
			return head;
		ListNode feakHead = new ListNode(0);
		ListNode list = feakHead;
		while (head != null) {
			list = feakHead;
			while (list.next != null && head.val > list.next.val) {
				list = list.next;
			}
			ListNode next = head.next;
			head.next = list.next;
			list.next = head;
			head = next;
		}
		return feakHead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
