public class IntersectionofTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode heada = headA;
		ListNode headb = headB;

		int lengtha = 0, lengthb = 0;

		while (heada != null) {
			lengtha++;
			heada = heada.next;
		}
		while (headb != null) {
			lengthb++;
			headb = headb.next;
		}
		heada = headA;
		headb = headB;
		while (lengtha > lengthb) {
			heada = heada.next;
			lengtha--;
		}
		while (lengthb > lengtha) {
			headb = headb.next;
			lengthb--;
		}
		while (heada != headb) {
			heada = heada.next;
			headb = headb.next;
		}
		return heada;

	}

	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
		ListNode listA = reverse(headA);
		ListNode listB = reverse(headB);
		ListNode pre = null;
		while (listA != null && listB != null) {
			if (listA.val == listB.val) {
				pre = listA;
				listA = listA.next;
				listB = listB.next;
			} else {
				break;
			}
		}
		return pre;
	}

	public ListNode reverse(ListNode head) {
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

	public static void main(String[] args) {

	}

}
