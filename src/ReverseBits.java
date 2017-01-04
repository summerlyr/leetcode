public class ReverseBits {

	public int reverseBits(long n) {
		long nn = n;
		long[] binary = new long[32];
		long sum = 0;
		long cheng = 1;
		System.out.println(n);
		for (int i = 0; i < 32; i++) {
			long m = nn % 2;
			nn = nn / 2;
			binary[32 - i - 1] = m;
		}
		for (int i = 0; i < 32; i++) {
			sum = sum + binary[i] * cheng;
			System.out.println(sum);
			cheng *= 2;
		}
		return (int) sum;

		// int i = 0;
		// int reverseVal = 0;
		// while (i <= 31) {
		// int temp = 1 << i;
		// int bitNum = (int) (temp & n);
		// if (bitNum != 0) {
		// reverseVal = (reverseVal << 1) + 1;
		// } else {
		// reverseVal = reverseVal << 1;
		// }
		// i++;
		// }
		// return reverseVal;
	}

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = (result << 1) | (n & 1);
			n = n >>> 1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits tb = new ReverseBits();
		System.out.println(tb.reverseBits(2147483648l));
	}

}
