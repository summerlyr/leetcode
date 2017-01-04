//http://www.cnblogs.com/grandyang/p/4295761.html

public class BestTimetoBuyandSellStockIV {

	/**
	 * dp[i, j] represents the max profit up until prices[j] using at most i
	 * transactions. dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1,
	 * jj]) { jj in range of [0, j-1] } = max(dp[i, j-1], prices[j] +
	 * max(dp[i-1, jj] - prices[jj])) dp[0, j] = 0; 0 transactions makes 0
	 * profit dp[i, 0] = 0; if there is only one price data point you can't make
	 * any transaction.
	 */
	public int maxProfit(int k, int[] prices) {
		if (k == 0 || prices.length == 0)
			return 0;
		if (k > prices.length / 2)
			return simple(prices);
		int[] globe = new int[k + 1];
		int[] local = new int[k + 1];
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = k; j >= 1; j--) {
				local[j] = Math.max(globe[j - 1] + Math.max(diff, 0), local[j] + diff);
				globe[j] = Math.max(globe[j], local[j]);

			}
		}
		return globe[k];
	}

	public int simple(int[] prices) {
		if (prices.length == 0)
			return 0;
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - prices[i - 1] > 0) {
				res += prices[i] - prices[i - 1];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimetoBuyandSellStockIV bt = new BestTimetoBuyandSellStockIV();
		int[] s = { 1, 2, 4, 2, 3, 4, 3, 5 };
		System.out.println(bt.maxProfit(3, s));
	}

}
