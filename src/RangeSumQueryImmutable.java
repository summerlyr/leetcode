
public class RangeSumQueryImmutable {

	int[] res;

	public RangeSumQueryImmutable(int[] nums) {
		res = new int[nums.length + 1];
		res[0] = 0;
		for (int i = 1; i <= nums.length; i++) {
			res[i] = nums[i - 1] + res[i - 1];
		}
	}

	public int sumRange(int i, int j) {
		return res[j + 1] - res[i];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
