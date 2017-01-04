
public class BestTimetoBuyandSellStockwithCooldown {

	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;
		int buy = -prices[0];
		int pre_buy = buy;
		int sell = 0;
		int pre_sell = 0;
		for (int i = 1; i < prices.length; i++) {
			pre_buy = buy;
			buy = Math.max(pre_sell - prices[i], pre_buy);
			pre_sell = sell;
			sell = Math.max(pre_buy + prices[i], pre_sell);

		}
		return sell;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
