
public class BestTimetoBuyandSellStockII {

	public int maxProfit(int[] prices) {
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

	}

}
