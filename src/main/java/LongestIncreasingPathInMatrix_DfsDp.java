/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInMatrix_DfsDp {
  private final int[] DELTA_i = {-1, 1, 0, 0};
  private final int[] DELTA_j = {0, 0, -1, 1};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int length[][] = new int[matrix.length][matrix[0].length];
    int answer = 1;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        answer = Math.max(answer, getLengthDfs(matrix, i, j, length));
      }
    }

    return answer;
  }

  private int getLengthDfs(int[][] matrix, int i, int j, int[][] length) {
    if (length[i][j] > 0) {
      return length[i][j];
    }

    int answer = 1;
    length[i][j] = 1;
    for (int d = 0; d < DELTA_i.length; d++) {
      int adj_i = i + DELTA_i[d];
      int adj_j = j + DELTA_j[d];
      if (validCord(matrix, adj_i, adj_j) && matrix[i][j] > matrix[adj_i][adj_j]) {
        int len = getLengthDfs(matrix, adj_i, adj_j, length);
        answer = Math.max(answer, len + 1);
      }
    }
    length[i][j] = answer;
    return answer;
  }

  private boolean validCord(int[][] matrix, int i, int j) {
    return (0 <= i && i < matrix.length &&
        0 <= j && j < matrix[0].length);
  }
}
