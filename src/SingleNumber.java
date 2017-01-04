
public class SingleNumber {

	public int singleNumber(int[] A) {// a^a=0;a^a^b^b^c=c
		int result = 0;
		for (int i = 0; i < A.length; i++) {
			result ^= A[i];
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
