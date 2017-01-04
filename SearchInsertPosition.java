public class SearchInsertPosition {

	public int searchInsert(int[] A, int target) {
		return help(A, target, 0, A.length - 1);
	}

	public int help(int[] A, int target, int start, int end) {
		if (A.length == 0)
			return 0;
		if (end - start == 0 && target <= A[start])
			return start;
		if (end - start == 0 && target > A[start])
			return start + 1;

		int mid = start + (end - start) / 2;
		if (target <= A[mid]) {
			return help(A, target, start, mid);
		} else {
			return help(A, target, mid + 1, end);
		}
	}

	public int searchInsert2(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition sp = new SearchInsertPosition();
		int[] A = { 1, 3, 5, 6 };
		System.out.println(sp.searchInsert(A, 7));
	}

}
