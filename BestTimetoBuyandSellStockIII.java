
public class BestTimetoBuyandSellStockIII {

	public int maxProfit(int k, int[] prices) {
		if (k == 0 || prices.length == 0)
			return 0;
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

	public int maxProfit(int[] prices) {
		return maxProfit(2, prices);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
