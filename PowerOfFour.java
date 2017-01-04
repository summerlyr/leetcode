
public class PowerOfFour {

	public boolean isPowerOfFour(int num) {
		return num > 0 && Math.log10(num) / Math.log10(4) % 1 == 0;
	}

	public boolean isPowerOfFour2(int num) {
		return num >= 1 && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
	}

	public boolean isPowerOfFour3(int num) {
		while (num > 1) {
			int tmp = num >> 2;
			if (num != tmp << 2)
				return false;
			num = tmp;
		}
		return num == 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
