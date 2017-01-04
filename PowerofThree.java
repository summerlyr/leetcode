import java.util.Arrays;

public class PowerofThree {

	public boolean isPowerOfThree(int n) {
		if (n <= 0)
			return false;
		while (n % 3 == 0) {
			n = n / 3;
		}
		return n == 1;
	}

	public boolean isPowerOfThree2(int n) {
		return n > 0 && Math.log10(n) / Math.log10(3) % 1 == 0;
	}

	public boolean isPowerOfThree3(int n) {
		int[] allPowerOfThree = new int[] { 1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441,
				1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467 };
		return Arrays.binarySearch(allPowerOfThree, n) >= 0;
	}

	public boolean isPowerOfThree4(int n) {
		return n > 0 && (1162261467 % n == 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
