import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode root = head;
		while (root != null) {
			RandomListNode tmp = new RandomListNode(root.label);
			tmp.next = root.next;
			root.next = tmp;
			root = root.next.next;
		}
		root = head;
		while (root != null) {
			if (root.random != null)
				root.next.random = root.random.next;
			root = root.next.next;
		}
		RandomListNode list = head;
		RandomListNode cur = head.next;
		root = cur;
		while (list != null) {
			list.next = list.next.next;
			if (root.next != null)
				root.next = root.next.next;
			list = list.next;
			root = root.next;
		}
		return cur;
	}

	public RandomListNode copyRandomList2(RandomListNode head) {
		if (head == null)
			return null;
		Map<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
		RandomListNode root = new RandomListNode(head.label);
		RandomListNode list = root;
		map.put(root.label, root);
		while (head != null) {
			if (head.next == null)
				list.next = null;
			else {
				if (map.containsKey(head.next.label)) {
					list.next = map.get(head.next.label);
				} else {
					list.next = new RandomListNode(head.next.label);
					map.put(head.next.label, list.next);
				}

			}
			if (head.random == null)
				list.random = null;
			else {
				if (map.containsKey(head.random.label)) {
					list.random = map.get(head.random.label);
				} else {
					list.random = new RandomListNode(head.random.label);
					map.put(head.random.label, list.random);
				}
			}
			head = head.next;
			list = list.next;
		}
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
