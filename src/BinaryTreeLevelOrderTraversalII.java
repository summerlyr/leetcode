import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		help(root, result, 0);
		return result;
	}

	public void help(TreeNode root, List<List<Integer>> result, int h) {
		if (root == null)
			return;
		if (result.size() - 1 < h) {
			result.add(0, new LinkedList<Integer>());
		}
		result.get(result.size() - h - 1).add(root.val);
		help(root.left, result, h + 1);
		help(root.right, result, h + 1);
	}

	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> cur = new LinkedList<Integer>();
			for (int i = 0; i < size; i++) {
				TreeNode n = queue.poll();
				cur.add(n.val);
				if (n.left != null)
					queue.add(n.left);
				if (n.right != null)
					queue.add(n.right);
			}
			result.add(0, cur);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
