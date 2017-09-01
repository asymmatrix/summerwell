/**
 * https://leetcode.com/problems/remove-boxes/
 */
public class RemoveBoxes {
  public int removeBoxes(int[] boxes) {
    if (boxes == null || boxes.length == 0) {
      return 0;
    }

    final int n = boxes.length;
    int[][][] dp = new int[n][n][n];

    for (int i = 0; i < n; i++) {
      for (int k = 0; k < n; k++) {
        dp[i][i][k] = (k + 1) * (k + 1);
      }
    }

    for (int offset = 1; offset < n; offset++) {
      for (int i = 0; i + offset < n; i++) {
        int j = i + offset;

        for (int k = 0; k <= i; k++) {
          int score = (k + 1) * (k + 1) + dp[i + 1][j][0];

          for (int m = i + 1; m <= j; m++) {
            if (boxes[m] == boxes[i]) {
              int temp = dp[i + 1][m - 1][0] + dp[m][j][k + 1];
              score = Math.max(score, temp);
            }
          }

          dp[i][j][k] = score;
        }
      }
    }

    return dp[0][n - 1][0];
  }
}
