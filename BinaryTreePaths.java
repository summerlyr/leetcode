import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new LinkedList<String>();
		List<Integer> cur = new ArrayList<Integer>();
		if (root == null)
			return res;
		help(res, root, cur);
		return res;
	}

	public void help(List<String> res, TreeNode root, List<Integer> cur) {
		if (root.left == null && root.right == null) {
			cur.add(root.val);
			String s = cur.get(0) + "";
			for (int i = 1; i < cur.size(); i++) {
				s = s + "->" + cur.get(i);
			}
			res.add(s);
			cur.remove(cur.size() - 1);
			return;
		}
		cur.add(root.val);
		if (root.left != null)
			help(res, root.left, cur);
		if (root.right != null)
			help(res, root.right, cur);
		cur.remove(cur.size() - 1);
	}

	public List<String> binaryTreePaths2(TreeNode root) {
		List<String> res = new LinkedList<String>();
		if (root == null)
			return res;
		help(res, root, "");
		return res;
	}

	public void help(List<String> res, TreeNode root, String cur) {
		if (root.left == null && root.right == null) {
			res.add(cur + root.val);
			return;
		}
		if (root.left != null)
			help(res, root.left, cur + root.val + "->");
		if (root.right != null)
			help(res, root.right, cur + root.val + "->");
	}

	public List<String> binaryTreePaths3(TreeNode root) {
		List<String> res = new LinkedList<String>();
		if (root == null)
			return res;
		if (root.left == null && root.right == null) {
			res.add(root.val + "");
			return res;
		}
		for (String s : binaryTreePaths(root.left)) {
			res.add(root.val + "->" + s);
		}
		for (String s : binaryTreePaths(root.right)) {
			res.add(root.val + "->" + s);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
