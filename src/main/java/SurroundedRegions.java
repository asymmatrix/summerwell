import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * https://leetcode.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

  private final char O = 'O';
  private final char X = 'X';

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return;
    }

    final int height = board.length;
    final int width = board[0].length;

    HashSet<Long> visited = new HashSet<>();
    Queue<Long>  queue = new LinkedList<>();


    for(int i = 0; i < height; i++) {
      if (board[i][0] == O) {
        long v = encode(i, 0);
        visited.add(v);
        queue.offer(v);
      }

      if (board[i][width - 1] == O) {
        long v = encode(i, width - 1);
        visited.add(v);
        queue.offer(v);
      }
    }

    for(int j = 1; j < width - 1; j++) {
      if (board[0][j] == O) {
        long v = encode(0, j);
        visited.add(v);
        queue.offer(v);
      }

      if (board[height - 1][j] == O) {
        long v = encode(height - 1, j);
        visited.add(v);
        queue.offer(v);
      }
    }


    final int[] dx = {1, -1, 0, 0};
    final int[] dy = {0, 0, -1, 1};

    while(!queue.isEmpty()) {
      long v = queue.poll();
      int x = decode_x(v);
      int y = decode_y(v);

      for(int i = 0; i < 4; i++) {
        int adj_x = x + dx[i];
        int adj_y = y + dy[i];
        long adj_v = encode(adj_x, adj_y);

        if (0 <= adj_x && adj_x < height && 0 <= adj_y && adj_y < width &&
            board[adj_x][adj_y] == O && !visited.contains(adj_v)) {
          visited.add(adj_v);
          queue.offer(adj_v);
        }
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        long v = encode(i, j);
        if (board[i][j] == O && !visited.contains(v)) {
          board[i][j] = X;
        }
      }
    }
  }

  private long encode(int x, int y) {
    return ((long)x << 32) | y;
  }

  private int decode_x(long v) {
    return (int)(v >> 32) & 0xFFFFFFFF;
  }

  private int decode_y(long v) {
    return (int)(v & 0xFFFFFFFF);
  }
}
