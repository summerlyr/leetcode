import java.util.Arrays;

public class WiggleSortII {

	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int[] copy = new int[nums.length];
		int index = 0;
		int mid = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
		for (int i = 0; i <= mid; i++) {
			copy[index] = nums[mid - i];
			if (index + 1 < nums.length) {
				copy[index + 1] = nums[nums.length - i - 1];
			}
			index = index + 2;
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = copy[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
