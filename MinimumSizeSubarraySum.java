
public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int fast = 0;
		int slow = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while (fast < n) {
			sum += nums[fast];
			while (sum >= s) {
				min = Math.min(min, fast - slow + 1);
				sum -= nums[slow++];
			}
			fast++;
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public int minSubArrayLen2(int s, int[] nums) {
		int min = Integer.MAX_VALUE;
		int[] sum = new int[nums.length + 1];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		for (int i = 0; i < sum.length; i++) {
			int end = binarySearch(i + 1, sum.length - 1, sum[i] + s, sum);
			if (end == sum.length)
				break;
			min = Math.min(min, end - i);

		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	int binarySearch(int start, int end, int key, int[] sums) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if (sums[mid] < key) {
				start = mid + 1;
			} else if (sums[mid] == key) {
				return mid;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
		int[] nums = { 2, 1, 3, 2, 3, 4 };
		System.out.println(ms.minSubArrayLen(16, nums));
	}

}
