import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		} else {
			list.addAll(postorderTraversal(root.left));
			list.addAll(postorderTraversal(root.right));
			list.add(root.val);
		}
		return list;
	}

	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		help(res, root);
		return res;
	}

	public void help(List<Integer> res, TreeNode root) {
		if (root == null)
			return;
		help(res, root.left);
		help(res, root.right);
		res.add(root.val);
	}

	public List<Integer> postorderTraversal3(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if (cur.left != null)
				stack.push(cur.left);
			if (cur.right != null)
				stack.push(cur.right);
		}
		reverse(res);
		return res;
	}

	public void reverse(List<Integer> list) {
		int l = 0;
		int h = list.size() - 1;
		while (l < h) {
			int tmp = list.get(l);
			list.set(l, list.get(h));
			list.set(h, tmp);
			l++;
			h--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
