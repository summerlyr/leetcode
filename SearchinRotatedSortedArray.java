public class SearchinRotatedSortedArray {

	public int search(int[] nums, int target) {

		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		while (start < end) {
			mid = (start + end) / 2;
			if (nums[mid] > nums[end]) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		int m = start;
		start = 0;
		end = nums.length - 1;
		if (m != 0) {
			if (target == nums[start]) {
				return start;
			} else if (target == nums[end]) {
				return end;
			} else if (target > nums[start]) {
				end = m - 1;
			} else if (target < nums[end]) {
				start = m;
			}
		}
		while (start <= end) {
			mid = (start + end) / 2;
			if (target == nums[mid]) {
				return mid;
			} else if (target > nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;

	}

	public int search2(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[start] <= nums[mid]) {
				if (target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}

			if (nums[mid] <= nums[end]) {
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return -1;
	}

	public int search3(int[] nums, int target) {
		int n = nums.length;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			if (nums[mid] <= nums[end]) {
				end = mid;
			} else {
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
				return newmid;
			} else if (nums[newmid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArray sr = new SearchinRotatedSortedArray();
		int[] num = { 2, 2, 2, 0, 2, 2 };
		System.out.println(sr.search(num, 0));

	}

}
