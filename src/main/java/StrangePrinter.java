/**
 * https://leetcode.com/problems/strange-printer/
 */
public class StrangePrinter {
  public int strangePrinter(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    final int len = s.length();

    int[][] dp = new int[len][len];

    for (int i = 0; i < len; i++) {
      dp[i][i] = 1;
    }

    for (int offset = 1; offset < len; offset++) {
      for (int start = 0; start + offset < len; start++) {
        final int end = start + offset;
        int min = 1 + dp[start + 1][end];
        for (int mid = start + 1; mid <= end; mid ++) {
          if (s.charAt(start) == s.charAt(mid)) {
            int temp = dp[start + 1][mid - 1] + dp[mid][end];
            min = Math.min(min, temp);
          }
        }
        dp[start][end] = min;
      }
    }

    return dp[0][len - 1];
  }
}