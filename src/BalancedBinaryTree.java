public class BalancedBinaryTree {

	public int checkHight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int hr = checkHight(root.right);
			if (hr == -1) {
				return -1;
			}
			int hl = checkHight(root.left);
			if (hl == -1) {
				return -1;
			}
			if (Math.abs(hr - hl) > 1) {
				return -1;
			} else {
				return Math.max(hr, hl) + 1;
			}
		}
	}

	public boolean isBalanced(TreeNode root) {
		int check = checkHight(root);
		if (check == -1) {
			return false;
		} else {
			return true;
		}
	}

	public int hight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int hr = hight(root.right);
			int hl = hight(root.left);
			return Math.max(hr, hl) + 1;
		}
	}

	public boolean isBalanced2(TreeNode root) {

		if (root == null) {
			return true;
		}
		int dis = hight(root.left) - hight(root.right);
		if (dis > 1 || dis < -1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
