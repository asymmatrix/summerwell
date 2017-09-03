import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class PacificAtlanticWaterFlow {
  private final int[] di = {0, 0, 1, -1};
  private final int[] dj = {1, -1, 0, 0};

  public List<int[]> pacificAtlantic(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return Collections.emptyList();
    }

    ArrayList<int[]> pacificBoundary = new ArrayList<>();
    ArrayList<int[]> atlanticBoundary = new ArrayList<>();

    for (int i = 0; i < matrix.length; i++) {
      pacificBoundary.add(new int[] {i, 0});
      atlanticBoundary.add(new int[] {i, matrix[0].length - 1});
    }
    for (int j = 0; j < matrix[0].length; j++) {
      pacificBoundary.add(new int[] {0, j});
      atlanticBoundary.add(new int[] {matrix.length - 1, j});
    }

    boolean[][] pacificAccess = new boolean[matrix.length][matrix[0].length];
    dfs(matrix, pacificBoundary, pacificAccess);

    boolean[][] atlanticAccess = new boolean[matrix.length][matrix[0].length];
    dfs(matrix, atlanticBoundary, atlanticAccess);

    ArrayList<int[]> answer = new ArrayList<>();
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (pacificAccess[i][j] && atlanticAccess[i][j]) {
          answer.add(new int[] {i, j});
        }
      }
    }

    return answer;
  }

  private void dfs(int[][] matrix, List<int[]> boundary, boolean[][] access) {

    Queue<int[]> queue = new LinkedList<>();
    for(int[] cell : boundary) {
      access[cell[0]][cell[1]] = true;
      queue.add(cell);
    }

    while(!queue.isEmpty()) {
      int[] cell = queue.poll();
      for (int d = 0; d < 4; d++) {
        int adj_i = cell[0] + di[d];
        int adj_j = cell[1] + dj[d];
        if (0 <= adj_i && adj_i < matrix.length &&
            0 <= adj_j && adj_j < matrix[0].length &&
            !access[adj_i][adj_j] &&
            matrix[cell[0]][cell[1]] <= matrix[adj_i][adj_j]) {
          queue.add(new int[] {adj_i, adj_j});
          access[adj_i][adj_j] = true;
        }
      }
    }
  }

}
