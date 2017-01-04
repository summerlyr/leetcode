
public class PowerofTwo {

	public boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1)
				count++;
			n = n >> 1;
		}
		if (count != 1)
			return false;
		return true;
	}

	public boolean isPowerOfTwo2(int n) {
		if (n <= 0)
			return false;
		return (n & n - 1) == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
