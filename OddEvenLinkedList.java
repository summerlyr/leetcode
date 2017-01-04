
public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head.next;
		ListNode fasthead = fast;
		while (fast != null && fast.next != null) {
			slow.next = slow.next.next;
			fast.next = fast.next.next;
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = fasthead;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
