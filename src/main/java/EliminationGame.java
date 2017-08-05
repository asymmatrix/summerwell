/**
 * https://leetcode.com/problems/elimination-game/
 *
 * [n, D] = f(n, D, [n/2, !D])
 f(n, D, i) = {
   if (n == even AND D == R) {
     return i * 2 - 1
   }
  return i * 2
 }
 */

public class EliminationGame {
  public int lastRemaining(int n) {
    return lastRemainingRecursively(n, true);
  }

  private int lastRemainingRecursively(int n, boolean fromLeft) {
    if (n == 1) {
      return 1;
    }

    int index = lastRemainingRecursively(n/2, !fromLeft);
    return convertIndex(n, fromLeft, index);
  }

  private int convertIndex(int n, boolean fromLeft, int i) {
    if (n % 2 == 0 && !fromLeft) {
      return i * 2 - 1;
    }
    return i * 2;
  }
}
