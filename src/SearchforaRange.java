public class SearchforaRange {

	public int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		int start = 0;
		int end = nums.length - 1;
		boolean flag = false;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				flag = true;
				int low = mid;
				int high = mid;
				while (low > 0 && nums[low - 1] == target) {
					low--;
				}
				while (high < nums.length - 1 && nums[high + 1] == target) {
					high++;
				}
				result[0] = low;
				result[1] = high;
				break;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			}
		}
		if (!flag) {
			result[0] = result[1] = -1;
			return result;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchforaRange sr = new SearchforaRange();
		int[] nums = { 1, 1, 3 };
		System.out.println(sr.searchRange(nums, 1)[0] + " " + sr.searchRange(nums, 1)[1]);
	}

}
