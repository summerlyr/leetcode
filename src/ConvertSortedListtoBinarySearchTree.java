public class ConvertSortedListtoBinarySearchTree {

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode cur = new TreeNode(slow.next.val);
		ListNode right = slow.next.next;
		slow.next = null;
		cur.left = sortedListToBST(head);
		cur.right = sortedListToBST(right);
		return cur;
	}

	public TreeNode sortedListToBST2(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return new TreeNode(head.val);
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		TreeNode root = new TreeNode(slow.next.val);
		fast = slow.next.next;
		slow.next = null;
		slow = head;
		root.left = sortedListToBST(slow);
		root.right = sortedListToBST(fast);
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = new ListNode(1);
		list.next = new ListNode(3);
		ConvertSortedListtoBinarySearchTree cslbst = new ConvertSortedListtoBinarySearchTree();
		TreeNode tree = cslbst.sortedListToBST(list);
		System.out.println(tree.val);
	}

}
