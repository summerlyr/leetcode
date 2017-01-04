
public class MaximumSubarray {

	public int maxSubArray(int[] A) {
		int local = A[0];
		int global = A[0];
		for (int i = 1; i < A.length; i++) {
			local = Math.max(A[i], local + A[i]);
			global = Math.max(local, global);
		}
		return global;
	}

	public int maxSubArray2(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (sum < 0) {
				sum = nums[i];
			} else {
				sum = sum + nums[i];
			}

			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
