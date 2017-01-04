import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST {

	public int kthSmallest(TreeNode root, int k) {
		int left = count(root.left);
		if (left + 1 == k)
			return root.val;
		else if (k > left + 1)
			return kthSmallest(root.right, k - left - 1);
		else
			return kthSmallest(root.left, k);
	}

	public int count(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		if (root.left != null && root.right != null) {
			return 1 + count(root.left) + count(root.right);
		}
		if (root.left == null)
			return 1 + count(root.right);
		if (root.right == null)
			return 1 + count(root.left);
		return 0;
	}

	public int kthSmallest2(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		order(list, root);
		return list.get(k - 1);
	}

	public void order(List<Integer> list, TreeNode root) {
		if (root.left != null)
			order(list, root.left);
		list.add(root.val);
		if (root.right != null)
			order(list, root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
