public class FactorialTrailingZeroes {

	public int trailingZeroes(int n) {
		int five = 5;
		int count = 0;
		while (n > 0) {
			count += n / five;
			n = n / five;
		}
		return count;
	}

	public int trailingZeroes2(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
