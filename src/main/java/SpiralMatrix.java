import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * https://leetcode.com/problems/spiral-matrix/
 */
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return Collections.emptyList();
    }

    Mover mover = new Mover(0, -1, matrix.length, matrix[0].length);

    ArrayList<Integer> ans = new ArrayList<>();
    while(true) {
      Position pos = mover.nextStep();
      if (pos == null) break;
      ans.add(matrix[pos.x][pos.y]);
    }

    return ans;
  }

  private class Position {
    int x, y;
    Position(int x, int y) {
      this.x = x; this.y = y;
    }
  }

  private class Mover {

    private final int dx[] = {0, 1, 0, -1};
    private final int dy[] = {1, 0, -1, 0};

    private final int d_min_x[] = {1, 0, 0, 0};
    private final int d_max_y[] = {0, -1, 0, 0};
    private final int d_max_x[] = {0, 0, -1, 0};
    private final int d_min_y[] = {0, 0, 0, 1};


    private Position currentPos;
    private int direction = 0;
    private int minX, maxX, minY, maxY;

    Mover(int x, int y, int rows, int cols) {
      currentPos = new Position(x, y);
      minX = minY = 0;
      maxX = rows - 1;
      maxY = cols - 1;
    }

    Position nextStep() {
      for(int i = 0; i < 2; i++) {
        Position newPos = new Position(currentPos.x + dx[direction], currentPos.y + dy[direction]);
        if (minX <= newPos.x && newPos.x <= maxX &&
            minY <= newPos.y && newPos.y <= maxY) {
          currentPos = newPos;
          return currentPos;
        }

        minX += d_min_x[direction];
        maxX += d_max_x[direction];
        minY += d_min_y[direction];
        maxY += d_max_y[direction];

        direction = (direction + 1) % 4;
      }
      return null;
    }
  }
}
