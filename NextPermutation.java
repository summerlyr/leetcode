public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return;
		int s = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				s = i;
			}
		}
		if (s == 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		int t = 0;
		int val = nums[s - 1];
		for (int i = s; i < nums.length; i++) {
			if (val < nums[i]) {
				t = i;
			}
		}
		swap(nums, s - 1, t);
		reverse(nums, s, nums.length - 1);

	}

	public void swap(int[] nums, int s, int t) {
		int tmp = nums[s];
		nums[s] = nums[t];
		nums[t] = tmp;
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation np = new NextPermutation();
		int[] nums = { 3, 4, 2, 1 };
		np.nextPermutation(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
