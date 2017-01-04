import java.util.Stack;

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return help(root, Long.MIN_VALUE, Long.MAX_VALUE);

	}

	public boolean help(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		if (root.val <= min || root.val > max) {
			return false;
		}
		if (!help(root.left, min, root.val) || !help(root.right, root.val, max)) {
			return false;
		}
		return true;
	}

	public boolean isValidBST2(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return true;
		TreeNode pre = null;
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				TreeNode p = stack.pop();
				if (pre != null && pre.val >= p.val)
					return false;
				pre = p;
				cur = p.right;
			}
		}
		return true;
	}

	public boolean isValidBST3(TreeNode root) {
		return help2(root, null, null);
	}

	public boolean help2(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;
		if (min != null && root.val <= min)
			return false;
		if (max != null && root.val >= max)
			return false;
		if (!help2(root.left, min, root.val) || !help2(root.right, root.val, max))
			return false;
		return true;
	}

	public static void main(String[] args) {
	}

}
