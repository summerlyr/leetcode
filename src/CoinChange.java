import java.util.Arrays;

public class CoinChange {

	public int coinChange(int[] coins, int amount) {
		if (amount == 0)
			return 0;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			int cur = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0 && dp[i - coins[j]] >= 0)
					cur = Math.min(cur, dp[i - coins[j]] + 1);
			}
			if (cur != Integer.MAX_VALUE)
				dp[i] = cur;
		}
		return dp[amount];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
