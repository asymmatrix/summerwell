import java.util.Arrays;

/**
 * https://leetcode.com/problems/perfect-squares/
 */
public class PerfectSquares {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i * i <= k; i++) {
        dp[k] = Math.min(dp[k], dp[k - i * i] + 1);
      }
    }

    return dp[n];
  }
}
