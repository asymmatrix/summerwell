import java.util.ArrayList;


/**
 * https://leetcode.com/problems/diagonal-traverse/
 */
public class DiagonalTraverse {

  private final int[][] STEPS = new int[][] {{-1, 1}, {1, -1}};

  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return new int[] {};
    }

    int[] answer = new int[matrix.length * matrix[0].length];
    int cursor = 0;

    ArrayList<int[]> left_bottom = new ArrayList<>();
    for(int i = 0; i < matrix.length; i++) {
      left_bottom.add(new int[] {i, 0});
    }
    for(int j = 1; j < matrix[0].length; j++) {
      left_bottom.add(new int[] {matrix.length - 1, j});
    }

    ArrayList<int[]> top_right = new ArrayList<>();
    for(int j = 0; j < matrix[0].length; j++) {
      top_right.add(new int[] {0, j});
    }
    for(int i = 1; i < matrix.length; i++) {
      top_right.add(new int[] {i, matrix[0].length - 1});
    }

    ArrayList<int[]>[] boundaries = new ArrayList[] {left_bottom, top_right};
    int selector = 0;
    int boundary_index = 0;

    while(cursor < answer.length) {

      int[] pt = boundaries[selector].get(boundary_index);
      int[] step = STEPS[selector];

      while(0 <= pt[0] && pt[0] < matrix.length &&
            0 <= pt[1] && pt[1] < matrix[0].length) {
        answer[cursor++] = matrix[pt[0]][pt[1]];
        pt[0] += step[0];
        pt[1] += step[1];
      }

      selector = (selector + 1) % 2;
      boundary_index++;
    }

    return answer;
  }
}
