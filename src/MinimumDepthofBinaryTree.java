
public class MinimumDepthofBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth(root.right) + 1;
		}
		if (root.right == null) {
			return minDepth(root.left) + 1;
		} else {
			int mhl = minDepth(root.left);
			int mhr = minDepth(root.right);
			return Math.min(mhl, mhr) + 1;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
