public class FindMinimuminRotatedSortedArray {

	public int findMin(int[] nums) {

		/*
		 * if(nums.length==1) return nums[0]; for(int i=0;i<nums.length-1;i++) {
		 * if(nums[i]>nums[i+1]) return nums[i+1]; }
		 * if(nums[nums.length-2]>nums[nums.length-1]) return
		 * nums[nums.length-1]; else return nums[0];
		 */
		if (nums.length == 1)
			return nums[0];
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		FindMinimuminRotatedSortedArray fmrsa = new FindMinimuminRotatedSortedArray();
		int[] num = { 1 };
		System.out.println(fmrsa.findMin(num));
	}

}
