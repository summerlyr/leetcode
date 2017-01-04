public class BinaryTreeMaximumPathSum {

	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		DFS(root);
		return max;
	}

	public int DFS(TreeNode root) {
		if (root == null)
			return 0;
		int left = DFS(root.left);
		int right = DFS(root.right);

		int cursum = root.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		if (cursum > max) {
			max = cursum;
		}

		int leftsum = root.val + left;
		int rightsum = root.val + right;

		Math.max(Math.max(root.val, leftsum), rightsum);

		return Math.max(Math.max(root.val, leftsum), rightsum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
