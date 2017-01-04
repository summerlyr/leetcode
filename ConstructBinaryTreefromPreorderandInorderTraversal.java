public class ConstructBinaryTreefromPreorderandInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return help(0, 0, preorder.length, preorder, inorder);
	}

	public TreeNode help(int prestart, int instart, int inend, int[] preorder, int[] inorder) {
		if (prestart > preorder.length - 1 || instart > inend)
			return null;
		TreeNode tree = new TreeNode(preorder[prestart]);

		int m = instart;
		for (; m < inend; m++) {
			if (inorder[m] == preorder[prestart]) {
				break;
			}
		}

		tree.left = help(prestart + 1, instart, m - 1, preorder, inorder);
		tree.right = help(prestart + m - instart + 1, m + 1, inend, preorder, inorder);
		return tree;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
