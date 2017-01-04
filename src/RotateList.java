public class RotateList {

	public ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0) {
			return head;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (n > 0) {
			if (fast.next == null) {
				fast = head;
			} else {
				fast = fast.next;
			}
			n--;
		}
		if (fast == head) {
			return head;
		} else {
			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
			fast.next = head;
			head = slow.next;
			slow.next = null;

		}
		return head;
	}

	public ListNode rotateRight2(ListNode head, int k) {
		if (head == null || head.next == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		int length = 1;
		while (fast.next != null) {
			fast = fast.next;
			length++;
		}
		k = length - k % length - 1;
		while (k-- > 0) {
			slow = slow.next;
		}
		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
