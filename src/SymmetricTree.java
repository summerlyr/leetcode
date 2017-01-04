import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		return isSymmetric(root.left, root.right);

	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;

		if (!(left.val == right.val)) {
			return false;
		} else {
			return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}

	}

	public List<Integer> preOrder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			list.add(0);
			return list;
		}
		if (root.left == null && root.right == null) {
			list.add(root.val);
		} else {
			list.addAll(preOrder(root.left));
			list.add(root.val);
			list.addAll(preOrder(root.right));
		}

		return list;

	}

	public List<Integer> postOrder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			list.add(0);
			return list;
		}
		if (root.left == null && root.right == null) {
			list.add(root.val);
		} else {
			list.addAll(preOrder(root.right));
			list.add(root.val);
			list.addAll(preOrder(root.left));
		}

		return list;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
