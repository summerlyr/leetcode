import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null)
			return res;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			List<Integer> cur = new LinkedList<Integer>();
			if (!stack1.isEmpty()) {
				while (!stack1.isEmpty()) {
					TreeNode r = stack1.pop();
					cur.add(r.val);
					if (r.left != null)
						stack2.push(r.left);
					if (r.right != null)
						stack2.push(r.right);
				}
				res.add(cur);
			} else if (!stack2.isEmpty()) {
				while (!stack2.isEmpty()) {
					TreeNode r = stack2.pop();
					cur.add(r.val);
					if (r.right != null)
						stack1.push(r.right);
					if (r.left != null)
						stack1.push(r.left);
				}
				res.add(cur);
			}
		}
		return res;
	}

	public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean order = true;
		int size = 1;
		while (!queue.isEmpty()) {
			List<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (order) {
					list.add(cur.val);
				} else {
					list.add(0, cur.val);
				}
				if (cur.left != null)
					queue.add(cur.left);
				if (cur.right != null)
					queue.add(cur.right);
			}
			res.add(list);
			size = queue.size();
			order = order ? false : true;
		}
		return res;
	}

	public List<List<Integer>> zigzagLevelOrder3(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		help(root, res, 0);
		return res;
	}

	public void help(TreeNode root, List<List<Integer>> res, int level) {
		if (root == null)
			return;
		if (res.size() <= level) {
			res.add(new LinkedList<Integer>());
		}
		List<Integer> list = res.get(level);
		if (level % 2 == 0)
			list.add(root.val);
		else
			list.add(0, root.val);
		help(root.left, res, level + 1);
		help(root.right, res, level + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
