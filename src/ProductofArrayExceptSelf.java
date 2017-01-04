
public class ProductofArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] help1 = new int[n];
		int[] help2 = new int[n];

		help1[0] = 1;
		help2[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			help1[i] = help1[i - 1] * nums[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			help2[i] = help2[i + 1] * nums[i + 1];
		}
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				nums[i] = help2[i];
			} else if (i == n - 1) {
				nums[i] = help1[i];
			} else {
				nums[i] = help1[i] * help2[i];
			}
		}
		return nums;
	}

	public int[] productExceptSelf2(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		result[0] = 1;
		for (int i = 1; i < n; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}
		int tmp = 1;
		for (int i = n - 2; i >= 0; i--) {
			tmp = tmp * nums[i + 1];
			result[i] = result[i] * tmp;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
