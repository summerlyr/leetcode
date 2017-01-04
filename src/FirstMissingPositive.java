import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		if (nums.length == 0)
			return 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int count = 1;
		while (true) {
			if (!map.containsKey(count)) {
				break;
			}
			count++;
		}
		return count;
	}

	public int firstMissingPositive2(int[] nums) {
		if (nums.length == 0)
			return 1;
		int[] corr = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0 && nums[i] <= nums.length) {
				corr[nums[i]] = nums[i];
			}
		}
		for (int i = 0; i < corr.length; i++) {
			if (corr[i] != i) {
				return i;
			}
		}
		return nums.length + 1;
	}

	public int firstMissingPositive3(int[] nums) {
		if (nums.length == 0)
			return 1;
		int n = nums.length;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
				int tmp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = tmp;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	public int firstMissingPositive4(int[] nums) {
		if (nums.length == 0)
			return 1;
		Arrays.sort(nums);
		int start = 0;
		while (start < nums.length && nums[start] <= 0) {
			start++;
		}
		int count = 1;
		for (; start < nums.length - 1; start++) {
			if (nums[start] == count) {
				if (nums[start] != nums[start + 1]) {
					count++;
				}
			} else {
				break;
			}
		}
		if (start < nums.length && nums[start] == count)
			count++;
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
