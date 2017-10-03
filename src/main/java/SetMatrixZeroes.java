/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
public class SetMatrixZeroes {
  public void setZeroes(int[][] matrix) {

    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return;
    }

    int zero_row = -1;
    int zero_col = -1;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          if (zero_row == -1) {
            zero_row = i;
            zero_col = j;
            fillZeroAndSetFlags(matrix, i, j);
            break;
          } else if (j != zero_col) {
            matrix[i][zero_col] |= 1;
            matrix[zero_row][j] |= 2;
          }
        }
      }
    }

    if (zero_row == -1 || zero_col == -1) {
      return;
    }

    for (int i = 0; i < matrix.length; i++) {
      if (i == zero_row) continue;
      for (int j = 0; j < matrix[0].length; j++) {
        if (j == zero_col) continue;
        if ((matrix[i][zero_col] & 1) > 0 ||
            (matrix[zero_row][j] & 2) > 0) {
          matrix[i][j] = 0;
        }
      }
    }

    fillZero(matrix, zero_row, zero_col);
  }

  private void fillZeroAndSetFlags(int[][] matrix, int zero_row, int zero_col) {
    for(int r = 0; r < matrix.length; r++) {
      if (matrix[r][zero_col] == 0) {
        matrix[r][zero_col] = 1;
      } else {
        matrix[r][zero_col] = 0;
      }
    }
    for(int c = 0; c < matrix[0].length; c++) {
      if (matrix[zero_row][c] == 0) {
        matrix[zero_row][c] = 2;
      } else {
        matrix[zero_row][c] = 0;
      }
    }
  }

  private void fillZero(int[][] matrix, int zero_row, int zero_col) {
    for(int r = 0; r < matrix.length; r++) {
      matrix[r][zero_col] = 0;
    }
    for(int c = 0; c < matrix[0].length; c++) {
      matrix[zero_row][c] = 0;
    }
  }
}
