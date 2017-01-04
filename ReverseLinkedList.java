public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode p = head.next;
		head.next = null;
		ListNode next = reverseList(p);
		p.next = head;

		return next;

		/*
		 * ListNode feakHead = new ListNode(0); feakHead.next = head; ListNode
		 * front = feakHead.next; ListNode current = feakHead.next.next;
		 * while(current != null) { ListNode first = feakHead.next;
		 * feakHead.next = current; ListNode cur = current.next; front.next =
		 * cur; feakHead.next.next = first; current = cur; } return
		 * feakHead.next;
		 */
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null)
			return head;
		ListNode newlist = null;
		ListNode list = head;
		while (list != null) {
			ListNode cur = new ListNode(list.val);
			cur.next = newlist;
			newlist = cur;
			list = list.next;
		}
		return newlist;
	}

	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode listA = headA;
		ListNode listB = headB;
		while (listA != listB) {
			listA = listA == null ? headB : listA.next;
			listB = listB == null ? headA : listB.next;
		}
		return listA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
