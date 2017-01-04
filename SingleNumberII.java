import java.util.Arrays;

public class SingleNumberII {

	public int singleNumber(int[] A) {
		int result = 0;
		int[] count = new int[32];
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) == 1) {
					count[i]++;
				}
			}
			result |= (count[i] % 3) << i;
		}
		return result;
	}

	public int singleNumber21(int[] nums) {
		Arrays.sort(nums);
		int count = 0;
		while (count < nums.length - 2) {
			int c = 1;
			int cur = nums[count];
			while (count < nums.length - 1 && nums[count + 1] == cur) {
				count++;
				c++;
			}
			if (c != 3)
				return cur;
			count++;
		}
		return nums[count];
	}

	public static void main(String[] args) {
		SingleNumberII sn = new SingleNumberII();
		int[] a = { 2, 2, 3, 2 };
		System.out.println(sn.singleNumber(a));
	}

}
