import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/01-matrix/
 */
public class ZeroOneMatrix {

  private final int[] di = {1, -1, 0, 0};
  private final int[] dj = {0, 0, 1, -1};

  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return null;
    }

    int[][] answer = new int[matrix.length][matrix[0].length];
    for(int i = 0; i < answer.length; i++) {
      for (int j = 0; j < answer[0].length; j++) {
        answer[i][j] = -1;
      }
    }

    Queue<int[]> queue = new LinkedList<>();

    for(int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          answer[i][j] = 0;
          queue.offer(new int[] {i, j});
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      for(int d = 0; d < 4; d++) {
        int i = di[d] + curr[0];
        int j = dj[d] + curr[1];
        if (0 <= i && i < matrix.length && 0 <= j && j < matrix[0].length && answer[i][j] < 0) {
          answer[i][j] = answer[curr[0]][curr[1]] + 1;
          queue.offer(new int[] {i, j});
        }
      }
    }

    return answer;
  }
}
