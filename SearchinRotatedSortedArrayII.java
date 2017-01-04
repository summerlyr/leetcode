public class SearchinRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] > nums[start]) {
				if (nums[start] <= target && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (nums[mid] < nums[start]) {
				if (nums[mid] < target && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				start++;
			}
		}
		return false;
	}

	public boolean search2(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			while (start < end && nums[end] == nums[end - 1])
				end--;
			while (start < end && nums[start] == nums[start + 1])
				start++;
			int mid = (start + end) / 2;
			if (nums[mid] < nums[end]) {
				end = mid;
			} else if (nums[mid] > nums[end]) {
				start = mid + 1;
			}

		}
		int offset = start;
		start = 0;
		end = n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int newmid = (mid + offset) % n;
			if (nums[newmid] == target) {
				return true;
			} else if (nums[newmid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArrayII sr = new SearchinRotatedSortedArrayII();
		int[] nums = { 1, 1, 1, 2, 1, 1 };
		System.out.println(sr.search2(nums, 2));

	}

}
