
public class IntegerBreak {

	public int integerBreak(int n) {
		if (n == 0)
			return 0;
		else if (n <= 2)
			return 1;
		else if (n == 3)
			return 2;
		else if (n % 3 == 0)
			return (int) Math.pow(3, n / 3);
		else if (n % 3 == 1)
			return (int) Math.pow(3, (n - 4) / 3) * 2 * 2;
		else if (n % 3 == 2)
			return (int) Math.pow(3, n / 3) * 2;
		return 0;
	}

	public int integerBreak2(int n) {
		if (n == 0)
			return 0;
		int[] res = new int[n + 1];
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; 2 * j <= i; j++) {
				res[i] = Math.max(res[i], Math.max(j, res[j]) * Math.max(i - j, res[i - j]));
			}
		}
		return res[n];
	}

	public int integerBreak3(int n) {
		int[] res = new int[n + 1];
		if (n == 0)
			return 0;
		if (n <= 2)
			return 1;
		if (n == 3)
			return 2;
		res[2] = 2;
		res[3] = 3;
		for (int i = 4; i <= n; i++) {
			res[i] = Math.max(2 * res[i - 2], 3 * res[i - 3]);
		}
		return res[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
