
public class FindtheDuplicateNumber {
	public int findDuplicate(int[] nums) {

		if (nums.length <= 0)
			return -1;
		int slow = nums[0];
		int fast = nums[nums[0]];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}

	public int findDuplicate2(int[] nums) {
		if (nums.length == 0)
			return 0;
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			for (int n : nums) {
				if (n <= mid)
					count++;
			}
			if (count > mid)
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
