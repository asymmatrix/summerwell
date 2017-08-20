/**
 *  https://leetcode.com/problems/rotate-function/
 */
public class RotateFunction {
  public int maxRotateFunction(int[] A) {

    if (A == null || A.length <= 1) {
      return 0;
    }

    int additionForNext = 0;
    int previouse = 0;
    for (int i = 0; i < A.length; i++) {
      if (i < A.length - 1) {
        additionForNext += A[i];
      }
      previouse += i * A[i];
    }

    int max = previouse;
    for (int i = A.length - 1; i >= 1; i--) {
      previouse = previouse + additionForNext - A[i] * (A.length - 1);
      if (previouse > max ) {
        max = previouse;
      }
      additionForNext = additionForNext + A[i] - A[i - 1];
    }
    return max;
  }
}
