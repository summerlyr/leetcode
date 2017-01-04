public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode reverse = new ListNode(head.val);
		ListNode list = head;
		while (list.next != null) {
			list = list.next;
			ListNode t = new ListNode(list.val);
			t.next = reverse;
			reverse = t;
		}
		ListNode fast = head;
		ListNode slow = head;
		ListNode reverseslow = reverse;
		while (slow != null) {
			ListNode t = reverseslow;
			reverseslow = reverseslow.next;
			t.next = slow.next;
			slow.next = t;
			slow = slow.next.next;
		}
		slow = head;
		while (fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = null;
	}

	public void reorderList2(ListNode head) {
		if (head == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		ListNode first = head;
		ListNode second = reverse(fast);
		while (second != null) {
			ListNode next = second.next;
			second.next = first.next;
			first.next = second;
			first = first.next.next;
			second = next;
		}
	}

	public ListNode reverse(ListNode head) {
		ListNode pre = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ReorderList rl = new ReorderList();
		rl.reorderList(head);
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);
		System.out.println(head.next.next.next.val);
	}

}
