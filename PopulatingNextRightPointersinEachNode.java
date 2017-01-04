import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode pre = root;
		while (pre.left != null) {
			TreeLinkNode cur = pre;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				cur = cur.next;
			}
			pre = pre.left;
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

	public void connect3(TreeLinkNode root) {
		if (root == null || root.left == null)
			return;
		root.left.next = root.right;
		if (root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
