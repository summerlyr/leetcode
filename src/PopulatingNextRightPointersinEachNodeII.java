import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNodeII {
	public void connect(TreeLinkNode root) {
		TreeLinkNode head = null;
		TreeLinkNode prev = null;
		TreeLinkNode cur = root;
		while (cur != null) {
			while (cur != null) {
				if (cur.left != null) {
					if (prev != null) {
						prev.next = cur.left;
					} else {
						head = cur.left;
					}
					prev = cur.left;
				}
				if (cur.right != null) {
					if (prev != null) {
						prev.next = cur.right;
					} else {
						head = cur.right;
					}
					prev = cur.right;
				}
				cur = cur.next;
			}
			cur = head;
			head = null;
			prev = null;
		}
	}

	public void connect2(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		int size = 1;
		while (!queue.isEmpty()) {
			for (int i = 0; i < size; i++) {
				TreeLinkNode cur = queue.poll();
				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
				if (i < size - 1)
					cur.next = queue.peek();
			}
			size = queue.size();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
