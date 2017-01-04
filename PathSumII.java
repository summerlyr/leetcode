import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

	int count = 0;
	boolean flag;

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		if (root.left == null && root.right == null && sum == root.val) {
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(root.val);
			list.add(cur);
			return list;
		}
		list = pathSum(root.left, sum - root.val);
		List<List<Integer>> list_right = pathSum(root.right, sum - root.val);
		for (List<Integer> l : list_right) {
			list.add(l);
		}

		for (List<Integer> l : list) {
			l.add(0, root.val);
		}
		return list;
	}

	public List<List<Integer>> pathSum2(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		if (root == null)
			return res;
		help(res, new LinkedList<Integer>(), root, sum);
		return res;
	}

	public void help(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum) {
		if (root.left == null && root.right == null && root.val == sum) {
			List<Integer> list = new LinkedList<Integer>(cur);
			list.add(root.val);
			res.add(list);
			return;
		}
		cur.add(root.val);
		if (root.left != null)
			help(res, cur, root.left, sum - root.val);
		if (root.right != null)
			help(res, cur, root.right, sum - root.val);
		cur.remove(cur.size() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
