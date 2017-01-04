public class RotateArray {

	public void rotate(int[] nums, int k) {
		int[] tmp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			tmp[(i + k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = tmp[i];
		}
	}

	public void rotate1(int[] nums, int k) {
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}

	public void rotate3(int[] nums, int k) {
		k = k % nums.length;
		if (nums.length <= 1 || k == 0)
			return;
		int start = 0;
		int n = nums.length;
		while (k != 0) {
			for (int i = 0; i < k; i++) {
				int tmp = nums[start + i];
				nums[start + i] = nums[start + n - k + i];
				nums[start + n - k + i] = tmp;
			}
			n = n - k;
			start = start + k;
			k = k % n;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateArray ra = new RotateArray();
		int[] nums = { 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27 };
		ra.rotate3(nums, 11);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
