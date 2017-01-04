import java.util.LinkedList;
import java.util.List;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		help(list, root, 0);
		return list;
	}

	public void help(List<Integer> list, TreeNode root, int level) {
		if (root == null)
			return;
		if (list.size() < level + 1) {
			list.add(root.val);
		}
		help(list, root.right, level + 1);
		help(list, root.left, level + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
