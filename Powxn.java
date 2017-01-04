public class Powxn {

	public double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}

	public double myPow2(double x, int n) {
		if (n < 0) {
			x = 1 / x;
			n = -n;
		}
		if (n == 0)
			return 1;
		double m = myPow(x, n / 2);
		if (n % 2 == 0)
			return m * m;
		else
			return x * m * m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
