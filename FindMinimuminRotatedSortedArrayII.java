
public class FindMinimuminRotatedSortedArrayII {

	public int findMin(int[] nums) {
		int lo = 0;
		int hi = nums.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = lo + (hi - lo) / 2;

			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else if (nums[mid] < nums[hi]) {
				hi = mid;
			} else { // when num[mid] and num[hi] are same
				hi--;
			}
		}
		System.out.println(lo);
		return nums[lo];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinimuminRotatedSortedArrayII fmr = new FindMinimuminRotatedSortedArrayII();
		int[] nums = { 1, 1, 1, 2, 1, 1 };
		System.out.println(fmr.findMin(nums));
	}

}
