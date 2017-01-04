import java.util.Arrays;

public class MissingNumber {

	public int missingNumber(int[] nums) {
		boolean[] flag = new boolean[nums.length + 1];
		int result = 0;
		Arrays.fill(flag, false);
		for (int i = 0; i < nums.length; i++) {
			flag[nums[i]] = true;
		}
		for (int i = 0; i < flag.length; i++) {
			if (!flag[i]) {
				result = i;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
