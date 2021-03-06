
public class LowestCommonAncestorofaBinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (findNode(root.left, p) && findNode(root.left, q))
			return lowestCommonAncestor(root.left, p, q);
		if (findNode(root.right, p) && findNode(root.right, q))
			return lowestCommonAncestor(root.right, p, q);
		else
			return root;
	}

	public boolean findNode(TreeNode root, TreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return findNode(root.left, p) || findNode(root.right, p);
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null & right != null)
			return root;
		return left == null ? right : left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
