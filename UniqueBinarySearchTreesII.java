import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesII {

	public List<TreeNode> generateTrees(int n) {
		return help(1, n);
	}

	public List<TreeNode> help(int start, int end) {
		List<TreeNode> result = new LinkedList<TreeNode>();
		if (start > end) {
			result.add(null);
			return result;
		}
		if (start == end) {
			TreeNode cur = new TreeNode(start);
			result.add(cur);
			return result;
		}

		List<TreeNode> left, right;
		for (int i = start; i <= end; i++) {
			left = help(start, i - 1);
			right = help(i + 1, end);
			for (TreeNode leftn : left) {
				for (TreeNode rightn : right) {
					TreeNode root = new TreeNode(i);
					root.left = leftn;
					root.right = rightn;
					result.add(root);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
