
public class PatchingArray {

	public int minPatches(int[] nums, int n) {
		long miss = 1;
		int add = 0;
		int i = 0;
		while (miss <= n) {
			if (i < nums.length && nums[i] <= miss) {
				miss += nums[i++];
			} else {
				miss <<= 1;
				add++;
			}
		}
		return add;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
