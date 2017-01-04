
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			if (cur.left != null) {
				stack.push(cur.left);
				cur.left = null;
			} else if (cur.right != null) {
				result.add(cur.val);
				stack.pop();
				stack.push(cur.right);
			} else {
				result.add(cur.val);
				stack.pop();
			}
		}
		return result;
	}

	public List<Integer> inorderTraversal2(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		help(root, result);
		return result;
	}

	public void help(TreeNode root, List<Integer> result) {
		if (root == null)
			return;
		help(root.left, result);
		result.add(root.val);
		help(root.right, result);
	}

	public List<Integer> inorderTraversal3(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			result.add(cur.val);
			cur = cur.right;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
