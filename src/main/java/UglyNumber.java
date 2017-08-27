/**
 * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {
  private final int[] PRIME_FACTORS = {2, 3, 5};
  public boolean isUgly(int num) {
    if (num <= 0) return false;
    if (num == 1) return true;
    for(int i = 0; i < PRIME_FACTORS.length; i++) {
      while(num % PRIME_FACTORS[i] == 0) {
        num /= PRIME_FACTORS[i];
      }
    }
    return num == 1;
  }
}
