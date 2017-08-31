/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class CoinChange2 {
  public int change(int amount, int[] coins) {
    // dp[n, c] = dp[n, c - 1] + dp[n - coins[c], c]

    if (amount == 0) {
      return 1;
    }

    if (amount < 0 || coins == null || coins.length == 0) {
      return 0;
    }

    int[] dp = new int[amount + 1];

    for (int c = 0; c < coins.length; c++) {
      for(int n = 1; n <= amount; n++) {
        int v = 0;
        if (n > coins[c]) {
          v = dp[n - coins[c]];
        } else if (n == coins[c]) {
          v = 1;
        }

        dp[n] += v;
      }
    }
    return dp[amount];
  }
}
