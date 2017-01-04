
public class HouseRobberIII {

	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		int[] res = dfs(root);
		return Math.max(res[0], res[1]);
	}

	public int[] dfs(TreeNode root) {
		if (root == null)
			return new int[2];
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		int[] res = new int[2];
		res[0] = left[1] + right[1] + root.val;
		res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return res;
	}

	public int rob2(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(include(root), exclude(root));
	}

	public int include(TreeNode root) {
		if (root == null)
			return 0;
		return exclude(root.left) + exclude(root.right) + root.val;
	}

	public int exclude(TreeNode root) {
		if (root == null)
			return 0;
		return rob(root.left) + rob(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseRobberIII hr = new HouseRobberIII();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		System.out.println(hr.rob(root));
	}

}
