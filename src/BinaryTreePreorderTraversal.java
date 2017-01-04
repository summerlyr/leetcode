import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		} else {
			list.add(root.val);
			list.addAll(preorderTraversal(root.left));
			list.addAll(preorderTraversal(root.right));
		}
		return list;
	}

	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			res.add(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
		return res;
	}

	public List<Integer> preorderTraversal3(TreeNode root) {
		List<Integer> res = new LinkedList<Integer>();
		help(res, root);
		return res;
	}

	public void help(List<Integer> res, TreeNode root) {
		if (root == null)
			return;
		res.add(root.val);
		help(res, root.left);
		help(res, root.right);
	}

	public static void main(String[] args) {

	}

}
