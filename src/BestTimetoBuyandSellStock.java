
public class BestTimetoBuyandSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int min = prices[0];
		int res = 0;
		for (int i = 1; i < prices.length; i++) {
			if (min > prices[i]) {
				min = prices[i];
			}
			res = Math.max(res, prices[i] - min);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
