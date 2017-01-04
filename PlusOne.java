
public class PlusOne {

	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] + 1 < 10) {
				digits[i] += 1;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		for (int i = 1; i < digits.length + 1; i++) {
			result[i] = digits[i - 1];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
