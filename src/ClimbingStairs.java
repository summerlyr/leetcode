public class ClimbingStairs {

	public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int t1 = 1;
		int t2 = 1;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = t1 + t2;
			t1 = t2;
			t2 = result;
		}
		return result;
	}

	public int climbStairs2(int n) {
		int[] res = new int[n + 1];
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}
		return res[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
