public class MaximumProductSubarray {
	public int maxProduct(int[] A) {
		if (A.length == 0)
			return A[0];
		int localMin = A[0];
		int localMax = A[0];
		int global = A[0];

		for (int i = 1; i < A.length; i++) {
			int copy = localMax;
			localMax = Math.max(Math.max(A[i] * localMax, A[i]), A[i] * localMin);
			localMin = Math.min(Math.min(A[i] * copy, A[i]), A[i] * localMin);
			global = Math.max(global, localMax);
		}
		return global;
	}

	public int maxProduct2(int[] nums) {
		int maxpre = nums[0];
		int minpre = nums[0];
		int max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int maxhere = Math.max(nums[i], Math.max(nums[i] * maxpre, nums[i] * minpre));
			int minhere = Math.min(nums[i], Math.min(nums[i] * maxpre, nums[i] * minpre));
			max = Math.max(maxhere, max);
			maxpre = maxhere;
			minpre = minhere;
		}
		return max;
	}

	public static void main(String[] args) {
	}

}
