
public class RecoverBinarySearchTree {

	TreeNode first = null;
	TreeNode second = null;
	TreeNode pre = new TreeNode(Integer.MIN_VALUE);

	public void recoverTree(TreeNode root) {
		traverse(root);
		int tmp = first.val;
		first.val = second.val;
		second.val = tmp;
	}

	private void traverse(TreeNode root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		traverse(root.left);
		if (first == null && pre.val >= root.val) {
			first = pre;
		}
		if (first != null && pre.val >= root.val) {
			second = root;
		}

		pre = root;

		traverse(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
