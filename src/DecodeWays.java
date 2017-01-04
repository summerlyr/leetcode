public class DecodeWays {

	public int numDecodings(String s) {

		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];
		return memo[0];

	}

	public int numDecodings2(String s) {
		int n = s.length();
		if (n == 0)
			return 0;
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i <= n; i++) {
			int num1 = Integer.parseInt(s.substring(i - 1, i));
			int num2 = Integer.parseInt(s.substring(i - 2, i));
			if (num1 != 0)
				count[i] += count[i - 1];
			if (num2 <= 26 && num2 >= 10)
				count[i] += count[i - 2];
		}
		return count[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("11301"));
	}

}
