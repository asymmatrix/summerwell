import java.util.Arrays;


/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInMatrix_SortDp {

  private final int[] DELTA_i = {-1, 1, 0, 0};
  private final int[] DELTA_j = {0, 0, -1, 1};

  public int longestIncreasingPath(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int length[][] = new int[matrix.length][matrix[0].length];
    Point[] points = getSortedPoints(matrix);

    int maxLength = 1;
    for (Point point : points) {
      length[point.i][point.j] = 1;
      for(int d = 0; d < DELTA_i.length; d++) {
        int adj_i = point.i + DELTA_i[d];
        int adj_j = point.j + DELTA_j[d];
        if (!validCord(matrix, adj_i, adj_j)) {
          continue;
        }
        int adj_val = matrix[adj_i][adj_j];
        if (matrix[point.i][point.j] > adj_val) {
          length[point.i][point.j] = Math.max(length[point.i][point.j], length[adj_i][adj_j] + 1);
          maxLength = Math.max(maxLength, length[point.i][point.j]);
        }
      }
    }

    return maxLength;
  }

  private boolean validCord(int[][] matrix, int i, int j) {
    return (0 <= i && i < matrix.length &&
            0 <= j && j < matrix[0].length);
  }

  private Point[] getSortedPoints(int[][] matrix) {
    Point[] points = new Point[matrix.length * matrix[0].length];
    int cursor = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        points[cursor++] = new Point(i, j, matrix[i][j]);
      }
    }

    Arrays.sort(points, (a, b) -> a.val - b.val);

    return points;
  }

  private class Point {
    int i, j, val;
    Point(int i, int j, int val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }
  }
}
