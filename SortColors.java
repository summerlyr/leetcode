public class SortColors {

	public void sortColors(int[] A) {
		int[] num = { 0, 0, 0 };
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				num[0]++;
			}
			if (A[i] == 1) {
				num[1]++;
			}
			if (A[i] == 2) {
				num[2]++;
			}
		}
		for (int i = 0; i < num[0]; i++) {
			A[i] = 0;
		}
		for (int i = 0; i < num[1]; i++) {
			A[num[0] + i] = 1;
		}
		for (int i = 0; i < num[2]; i++) {
			A[num[1] + num[0] + i] = 2;
		}
	}

	public void sortColors2(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int index = 0;
		while (index <= high) {
			if (nums[index] == 0) {
				nums[index] = nums[low];
				nums[low++] = 0;
			} else if (nums[index] == 2) {
				nums[index] = nums[high];
				nums[high--] = 2;
				index--;
			}
			index++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
