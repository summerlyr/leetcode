import java.util.LinkedList;
import java.util.List;

public class SumRoottoLeafNumbers {

	public int sumNumbers(TreeNode root) {
		return DFS(root, 0);
	}

	public int DFS(TreeNode root, int sum) {
		if (root == null)
			return sum;
		int cursum = sum * 10 + root.val;
		if (root.left == null) {
			return DFS(root.right, cursum);
		} else if (root.right == null) {
			return DFS(root.left, cursum);
		}
		return DFS(root.left, cursum) + DFS(root.right, cursum);
	}

	public int sumNumbers2(TreeNode root) {
		if (root == null)
			return 0;
		List<Integer> list = new LinkedList<Integer>();
		help(list, root, 0);
		int result = 0;
		for (int m : list) {
			result += m;
		}
		return result;
	}

	public void help(List<Integer> list, TreeNode root, int sum) {
		if (root.left == null && root.right == null) {
			list.add(sum * 10 + root.val);
			return;
		}
		if (root.left != null)
			help(list, root.left, sum * 10 + root.val);
		if (root.right != null)
			help(list, root.right, sum * 10 + root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
