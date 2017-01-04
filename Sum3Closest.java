import java.util.Arrays;

public class Sum3Closest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[2];
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			for (int j = i + 1, k = nums.length - 1; j < k;) {
				int b = nums[j];
				int c = nums[k];
				int sum = a + b + c;
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
				if (sum - target > 0) {
					k--;
				} else {
					j++;
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
