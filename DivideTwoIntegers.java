
public class DivideTwoIntegers {

	public int divide(int dividend, int divisor) {
		if (divisor == 0)
			return Integer.MAX_VALUE;
		int sign = 1;
		if ((dividend > 0) ^ (divisor > 0)) {
			sign = -1;
		}
		long did = Math.abs((long) dividend);
		long dir = Math.abs((long) divisor);
		long count = 0;
		long tmp = dir;
		long mu = 1;
		while (did >= dir) {

			if (did >= tmp) {
				did -= tmp;
				count += mu;
				tmp <<= 1;
				mu <<= 1;
			} else {
				tmp >>= 1;
				mu >>= 1;
			}

		}
		count = sign * count;
		if (count < Integer.MIN_VALUE || count > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
