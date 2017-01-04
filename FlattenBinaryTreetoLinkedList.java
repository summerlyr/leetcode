public class FlattenBinaryTreetoLinkedList {

	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode right = root.right;
				TreeNode left = root.left;
				root.left = null;
				root.right = left;
				TreeNode rooth = root;
				while (rooth.right != null) {
					rooth = rooth.right;
				}
				rooth.right = right;
			}
			root = root.right;
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
