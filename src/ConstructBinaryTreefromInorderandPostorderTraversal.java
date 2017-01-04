public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return help(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
	}

	public TreeNode help(int postend, int instart, int inend, int[] inorder, int[] postorder) {
		if (postend < 0 || instart > inend)
			return null;
		TreeNode tree = new TreeNode(postorder[postend]);

		int m = instart;
		for (; m < inend; m++) {
			if (inorder[m] == postorder[postend])
				break;
		}

		tree.left = help(postend - (inend - m - 1), instart, m - 1, inorder, postorder);
		tree.right = help(postend - 1, m + 1, inend, inorder, postorder);

		return tree;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
