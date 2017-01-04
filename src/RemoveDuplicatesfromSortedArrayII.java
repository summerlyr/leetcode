public class RemoveDuplicatesfromSortedArrayII {

	public int removeDuplicates(int[] A) {
		if (A.length <= 2)
			return A.length;

		int i = 0;
		int j = 1;
		int count = 0;
		int cur = A[0];
		while (j < A.length) {
			if (A[j] == cur && count < 1) {
				count++;
				A[++i] = cur;
			} else if (A[j] == cur && count >= 1) {
				count++;
			} else if (A[j] != cur) {
				count = 0;
				cur = A[j];
				A[++i] = A[j];

			}
			j++;
		}
		return i + 1;
	}

	public int removeDuplicates2(int[] nums) {
		int i = 0;
		for (int n : nums) {
			if (i < 2 || nums[i - 2] < n) {
				nums[i++] = n;
			}
		}
		return i;
	}

	public int removeDuplicates3(int[] nums) {
		if (nums.length <= 2)
			return nums.length;
		int count = 0;
		int flag = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				count++;
				flag = 0;
			} else if (nums[i] == nums[i - 1] && flag == 0) {
				flag = 1;
				count++;
			}
			nums[count] = nums[i];
		}
		return count + 1;
	}

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII rd = new RemoveDuplicatesfromSortedArrayII();
		int[] A = { 1, 1, 1 };
		System.out.println(rd.removeDuplicates(A));
	}
}
