public class ConvertSortedArraytoBinarySearchTree {

	public TreeNode sortedArrayToBST(int[] num) {
		return help(num, 0, num.length - 1);
	}

	public TreeNode help(int[] num, int s, int e) {
		if (s > e) {
			return null;
		} else {
			int curr = num[(s + e) / 2];
			TreeNode currnode = new TreeNode(curr);
			currnode.left = help(num, s, (s + e) / 2 - 1);
			currnode.right = help(num, (s + e) / 2 + 1, e);
			return currnode;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
