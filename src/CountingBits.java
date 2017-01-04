
public class CountingBits {

	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		int s = 1;
		for (int i = s; i <= num; i++) {
			res[i] = 1 + res[i - s];
			if (i + 1 == (s << 1)) {
				s <<= 1;
			}
		}
		return res;
	}

	public int[] countBits2(int num) {
		int[] res = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			res[i] = res[i / 2] + i % 2;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
