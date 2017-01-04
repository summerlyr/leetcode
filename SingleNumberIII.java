
public class SingleNumberIII {

	public int[] singleNumber(int[] nums) {
		int t = 0;
		for (int i = 0; i < nums.length; i++) {
			t ^= nums[i];
		}
		t &= -t;
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & t) == 0) {
				result[0] ^= nums[i];
			} else {
				result[1] ^= nums[i];
			}

		}
		return result;
	}

	public int[] singleNumber2(int[] nums) {
		int t = 0;
		for (int n : nums) {
			t ^= n;
		}
		t = Integer.highestOneBit(t);
		int[] result = new int[2];
		for (int n : nums) {
			if ((t & n) == 0) {
				result[0] ^= n;
			} else {
				result[1] ^= n;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
