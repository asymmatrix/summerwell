/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeBuySellStockIV {
  public int maxProfit(int k, int[] prices) {
    if (prices == null || prices.length < 2 || k < 1) {
      return 0;
    }

    if (k >= prices.length / 2) {
      return quickSolve(prices);
    }

    int[] profit = new int[prices.length];
    int[] maxCapitalAftrBuy = new int[prices.length];
    for (int i = 0; i < maxCapitalAftrBuy.length; i++) {
      maxCapitalAftrBuy[i] = -prices[i];
      if (i > 0) maxCapitalAftrBuy[i] = Math.max(maxCapitalAftrBuy[i - 1], maxCapitalAftrBuy[i]);
    }

    for(int tx = 0; tx < k; tx++) {
      int maxCap = Integer.MIN_VALUE;
      for (int day = 1; day < prices.length; day++) {
        int pft = profit[day - 1];
        pft = Math.max(pft, prices[day] + maxCapitalAftrBuy[day]);
        pft = Math.max(pft, 0);
        maxCap = Math.max(maxCap, pft - prices[day]);

        profit[day] = pft;
        maxCapitalAftrBuy[day] = maxCap;
      }
    }

    return profit[prices.length - 1];
  }

  private int quickSolve(int[] prices) {
    int len = prices.length, profit = 0;
    for (int i = 1; i < len; i++)
      // as long as there is a price gap, we gain a profit.
      if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
    return profit;
  }
}
