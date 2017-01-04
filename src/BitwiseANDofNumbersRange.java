
public class BitwiseANDofNumbersRange {

	public int rangeBitwiseAnd(int m, int n) {
		if (m == 0)
			return 0;
		int r = 1;
		while (m != n) {
			m >>= 1;
			n >>= 1;
			r <<= 1;
		}
		return m * r;
	}

	public int rangeBitwiseAnd2(int m, int n) {
		while (m < n) {
			n = n & (n - 1);
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitwiseANDofNumbersRange ban = new BitwiseANDofNumbersRange();
		System.out.println(ban.rangeBitwiseAnd(5, 7));
	}
}
