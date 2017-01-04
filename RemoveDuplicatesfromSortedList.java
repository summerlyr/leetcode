public class RemoveDuplicatesfromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		ListNode front = head;
		ListNode back = head;
		if (head == null) {
			return head;
		}
		while (front != null) {
			if (front.val == back.val) {
				front = front.next;
			} else {
				back.next = front;
				back = front;
			}
		}
		back.next = front;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
