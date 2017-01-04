
public class NumArray {

	class SegmentTreeNode {
		int start;
		int end;
		SegmentTreeNode left, right;
		int sum;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			left = right = null;
			this.sum = 0;
		}
	}

	SegmentTreeNode root = null;

	public NumArray(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end)
			return null;
		else {
			SegmentTreeNode ret = new SegmentTreeNode(start, end);
			if (start == end) {
				ret.sum = nums[start];
			} else {
				int mid = (start + end) / 2;
				ret.left = buildTree(nums, start, mid);
				ret.right = buildTree(nums, mid + 1, end);
				ret.sum = ret.left.sum + ret.right.sum;
			}
			return ret;
		}
	}

	void update(int i, int val) {
		update(root, i, val);
	}

	void update(SegmentTreeNode root, int pos, int val) {
		if (root.start == root.end) {
			root.sum = val;
		} else {
			int mid = (root.start + root.end) / 2;
			if (pos <= mid) {
				update(root.left, pos, val);
			} else {
				update(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	int sumRange(SegmentTreeNode root, int start, int end) {
		if (root.start == start && root.end == end) {
			return root.sum;
		} else {
			int mid = (root.start + root.end) / 2;
			if (end <= mid) {
				return sumRange(root.left, start, end);
			} else if (start >= mid + 1) {
				return sumRange(root.right, start, end);
			} else {
				return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
