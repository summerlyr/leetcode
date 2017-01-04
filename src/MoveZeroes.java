
public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		if (nums.length <= 1)
			return;
		int zeroNum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroNum++;
			} else {
				nums[i - zeroNum] = nums[i];
				if (zeroNum != 0)
					nums[i] = 0;
			}
		}
	}

	public void moveZeroes2(int[] nums) {
		if (nums.length == 0)
			return;
		int length = nums.length;
		int count = 0;
		for (int n : nums) {
			if (n != 0) {
				nums[count++] = n;
			}
		}
		for (int i = count; i < length; i++) {
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
