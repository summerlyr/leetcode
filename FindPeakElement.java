
public class FindPeakElement {
	public int findPeakElement(int[] num) {
		/*
		 * for (int i = 1; i < num.length - 1; i++) { if (num[i] > num[i - 1] &&
		 * num[i] > num[i + 1]) { return i; } } if(num.length==1) { return 0; }
		 * if (num[0] > num[1]) { return 0; }
		 * if(num[num.length-1]>num[num.length-2]) { return num.length-1; }
		 * return 0;
		 */

		int low = 0;
		int high = num.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (num[mid] < num[mid + 1]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;

	}

	public int findPeakElement2(int[] nums) {
		// int[] tmp = nums.clone();
		// Arrays.sort(tmp);
		// return Arrays.binarySearch(nums,tmp[tmp.length-1]);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				return i - 1;
			}
		}
		return nums.length - 1;

	}

	public static void main(String[] args) {
		FindPeakElement fpe = new FindPeakElement();
		int[] num = { 3, 2, 1 };
		System.out.println(fpe.findPeakElement(num));
	}

}
