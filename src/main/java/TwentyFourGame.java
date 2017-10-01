/**
 * https://leetcode.com/problems/24-game/
 */
public class TwentyFourGame {
  public boolean judgePoint24(int[] nums) {
    if (nums == null || nums.length == 0) {
      return false;
    }

    Fraction[] numbers = new Fraction[nums.length];
    for(int i = 0; i < nums.length; i++) {
      numbers[i] = new Fraction(nums[i], 1);
    }

    return judge(numbers);
  }

  private boolean judge(Fraction[] nums) {
    if (nums.length == 1) {
      return nums[0].equal(24);
    }

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {

        Fraction[] nextNums = new Fraction[nums.length - 1];
        int cursor = 0;
        for(int k = 0; k < nums.length; k++) {
          if (k != i && k != j) {
            nextNums[cursor++] = nums[k];
          }
        }

        if (i == j) continue;

        // +
        nextNums[cursor] = nums[i].add(nums[j]);
        if (judge(nextNums)) return true;

        // -
        nextNums[cursor] = nums[i].sub(nums[j]);
        if (judge(nextNums)) return true;

        // *
        nextNums[cursor] = nums[i].mult(nums[j]);
        if (judge(nextNums)) return true;

        // /
        if (!nums[j].equal(0)) {
          nextNums[cursor] = nums[i].div(nums[j]);
          if (judge(nextNums)) return true;
        }
      }
    }

    return false;
  }

  private class Fraction {
    private long denominator;
    private long numerator;

    Fraction(long n, long d) {
      this.numerator = n / gcd(n, d);
      this.denominator = d / gcd(n, d);
    }

    Fraction add(Fraction other) {
      long n = this.numerator * other.denominator + this.denominator * other.numerator;
      long d = this.denominator * other.denominator;
      return new Fraction(n, d);
    }

    Fraction sub(Fraction other) {
      long n = this.numerator * other.denominator - this.denominator * other.numerator;
      long d = this.denominator * other.denominator;
      return new Fraction(n, d);
    }

    Fraction mult(Fraction other) {
      long n = this.numerator * other.numerator;
      long d = this.denominator * other.denominator;
      return new Fraction(n, d);
    }

    Fraction div(Fraction other) {
      long n = this.numerator * other.denominator;
      long d = this.denominator * other.numerator;
      return new Fraction(n, d);
    }

    boolean equal(int num) {
      return numerator == num && denominator == 1;
    }

    private long gcd(long a, long b) {
      return b == 0 ? a : gcd(b, a % b);
    }
  }
}
