import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

	public int numSquares(int n) {
		int[] res = new int[n + 1];
		Arrays.fill(res, Integer.MAX_VALUE);
		res[0] = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 1; i + j * j <= n; j++) {
				res[i + j * j] = Math.min(res[i + j * j], res[i] + 1);
			}
		}
		return res[n];

	}

	public int numSquares2(int n) {
		while (n % 4 == 0) {
			n /= 4;
		}
		if (n % 8 == 7)
			return 4;
		if (ifSqrt(n))
			return 1;
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if (ifSqrt(n - i * i))
				return 2;
		}
		return 3;
	}

	public boolean ifSqrt(int n) {
		int m = (int) Math.sqrt(n);
		if (m * m == n)
			return true;
		return false;
	}

	public int numSquares3(int n) {
		if (n <= 0)
			return 0;
		int dp[] = new int[n + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i * i <= n; i++) {
			if (i * i == n)
				return 1;
			dp[i * i] = 1;
			queue.add(i * i);
		}
		while (!queue.isEmpty()) {
			int cur = queue.peek();
			for (int i = 1; i * i <= n - cur; i++) {
				if (i * i + cur == n)
					return dp[cur] + 1;
				else if (i * i + cur < n && dp[i * i + cur] == 0) {
					dp[i * i + cur] = dp[cur] + 1;
					queue.offer(i * i + cur);
				} else if (i * i + cur > n) {
					break;
				}
			}
			queue.poll();
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
