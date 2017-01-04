
public class UglyNumber {

	public boolean isUgly(int num) {
		if (num == 1)
			return true;
		if (num <= 0)
			return false;
		while (num != 1) {
			if (num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				break;
			}
		}
		return num == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
