
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;
		ListNode newlist = null;
		ListNode list = head;
		while (list != null) {
			ListNode cur = new ListNode(list.val);
			cur.next = newlist;
			newlist = cur;
			list = list.next;
		}
		list = head;
		while (list != null) {
			if (list.val != newlist.val) {
				return false;
			}
			list = list.next;
			newlist = newlist.next;
		}
		return true;
	}

	public boolean isPalindrome2(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// 如果是双数，slow停留在前半部分最后一个节点
			// 如果是单数，slow停留在最中间的节点
		}
		slow.next = reverse(slow.next);
		slow = slow.next;
		while (slow != null) {
			if (head.val != slow.val) {
				return false;
			}
			slow = slow.next;
			head = head.next;
		}
		return true;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList pl = new PalindromeLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		pl.isPalindrome2(head);
	}

}
