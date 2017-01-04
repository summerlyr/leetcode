
public class CountCompleteTreeNodes {

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int hl = 0;
		int hr = 0;
		TreeNode left = root;
		TreeNode right = root;
		while (left != null) {
			hl++;
			left = left.left;
		}
		while (right != null) {
			hr++;
			right = right.right;
		}
		if (hl == hr) {
			return (int) (Math.pow(2, hl) - 1);
		}

		return 1 + countNodes(root.left) + countNodes(root.right);

	}

	public int countNodes2(TreeNode root) {
		if (root == null)
			return 0;
		int hl = height(root.left);
		int hr = height(root.right);
		if (hl == hr) {// ����������ȫ������
			return (1 << hl) + countNodes(root.right);
		} else {// ����������ȫ������
			return (1 << hr) + countNodes(root.left);
		}
	}

	public int height(TreeNode root) {
		int hi = 0;
		while (root != null) {
			hi++;
			root = root.left;
		}
		return hi;
	}

	public int countNodes3(TreeNode root) {
		int count = 0;
		int h = height2(root);
		while (root != null) {
			if (height2(root.right) == h - 1) {
				count += 1 << h;
				root = root.right;
			} else {
				count += 1 << (h - 1);
				root = root.left;
			}
			h--;
		}
		return count;
	}

	public int height2(TreeNode root) {
		int hi = -1;
		while (root != null) {
			hi++;
			root = root.left;
		}
		return hi;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
