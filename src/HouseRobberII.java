public class HouseRobberII {

	public int rob(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int a = 0;
		int b = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i % 2 == 0) {
				a = Math.max(a + nums[i], b);
			} else {
				b = Math.max(a, b + nums[i]);
			}
		}
		int max1 = Math.max(a, b);
		int aa = 0;
		int bb = 0;
		for (int i = 1; i < nums.length; i++) {
			if (i % 2 == 0) {
				aa = Math.max(aa + nums[i], bb);
			} else {
				bb = Math.max(aa, bb + nums[i]);
			}
		}
		int max2 = Math.max(aa, bb);
		return Math.max(max1, max2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
