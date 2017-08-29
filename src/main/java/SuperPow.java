

/**
 * https://leetcode.com/problems/super-pow/
 */
public class SuperPow {

  private final int MAGIC_NUMBER = 1337;

  public int superPow(int a, int[] b) {
    if (b == null || b.length == 0) {
      return 1;
    }

    int[][] power = preComputePower();

    int answer = 1;
    int tenPower = a % MAGIC_NUMBER;
    for(int i = b.length - 1; i >= 0; i--) {
      int x = power[tenPower][b[i]] % MAGIC_NUMBER;

      answer = (answer * x) % MAGIC_NUMBER;
      tenPower = power[tenPower][10] % MAGIC_NUMBER;
    }

    return answer;
  }

  private int[][] preComputePower() {
    int[][] power = new int[MAGIC_NUMBER][11];
    for(int b = 0; b < power.length; b++) {
      for (int e = 0; e < power[0].length; e++) {
        if (b == 0) {
          power[b][e] = 0;
        } else if (e == 0) {
          power[b][e] = 1;
        } else {
          power[b][e] = (power[b][e - 1] * b) % MAGIC_NUMBER;
        }
      }
    }

    return power;
  }
}
