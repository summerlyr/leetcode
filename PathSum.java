public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		/*
		 * if(root == null) { return false; } if(root != null && root.left ==
		 * null && root.right == null && sum-root.val == 0) { return true; }
		 * else if(root != null && root.left != null && root.right == null) {
		 * return hasPathSum(root.left,sum-root.val); } else if(root != null &&
		 * root.right != null && root.left == null) { return
		 * hasPathSum(root.right,sum-root.val); } else if(root != null &&
		 * root.left != null && root.right != null) { return
		 * hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.
		 * val); } return false;
		 */

		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null && sum == root.val) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
