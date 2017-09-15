/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeBuySellStockIII {
  public int maxProfit(int[] prices) {
    return maxProfit(prices, 2);
  }

  private int maxProfit(int[] prices, int maxTxCnt) {

    if (prices == null || prices.length < 2 || maxTxCnt < 1) {
      return 0;
    }

    int[] profit = new int[prices.length];
    int[] maxCapitalAftrBuy = new int[prices.length];
    for (int i = 0; i < maxCapitalAftrBuy.length; i++) {
      maxCapitalAftrBuy[i] = -prices[i];
      if (i > 0) maxCapitalAftrBuy[i] = Math.max(maxCapitalAftrBuy[i - 1], maxCapitalAftrBuy[i]);
    }

    for(int tx = 0; tx < maxTxCnt; tx++) {
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
}
