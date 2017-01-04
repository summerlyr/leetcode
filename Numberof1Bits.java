public class Numberof1Bits {

	public int hammingWeight(int n) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>>= 1;
		}
		return count;
	}

	public int hammingWeight2(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numberof1Bits nob = new Numberof1Bits();
		System.out.println(nob.hammingWeight(11));
	}

}
