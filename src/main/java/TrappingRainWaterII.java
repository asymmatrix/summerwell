import java.util.PriorityQueue;


/**
 * https://leetcode.com/problems/trapping-rain-water-ii/
 */
public class TrappingRainWaterII {
  private final int[] dx = {0, 0, 1, -1};
  private final int[] dy = {1, -1, 0, 0};

  public int trapRainWater(int[][] heightMap) {
    if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
      return 0;
    }

    final int rows = heightMap.length;
    final int cols = heightMap[0].length;

    PriorityQueue<Cell> heap = new PriorityQueue<>(1, (Cell a, Cell b) -> a.h - b.h);
    boolean[][] visited = new boolean[rows][cols];

    for(int i = 0; i < rows; i++) {
      heap.offer(new Cell(i, 0, heightMap[i][0]));
      visited[i][0] = true;

      heap.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
      visited[i][cols - 1] = true;
    }

    for(int j = 0; j < cols; j++) {
      heap.offer(new Cell(0, j, heightMap[0][j]));
      visited[0][j] = true;

      heap.offer(new Cell(rows - 1, j, heightMap[rows - 1][j]));
      visited[rows - 1][j] = true;
    }

    int sum = 0;

    while(!heap.isEmpty()) {
      Cell c = heap.poll();
      for(int i = 0; i < dx.length; i++) {
        int x = c.x + dx[i];
        int y = c.y + dy[i];
        if (0 <= x && x < rows && 0 <= y && y < cols && !visited[x][y]) {
          visited[x][y] = true;
          sum += Math.max(0, c.h - heightMap[x][y]);
          heap.offer(new Cell(x, y, Math.max(c.h, heightMap[x][y])));
        }
      }
    }

    return sum;
  }

  private class Cell {
    int x, y, h;
    Cell(int x, int y, int h) {
      this.x = x; this.y = y; this.h = h;
    }
  }
}
