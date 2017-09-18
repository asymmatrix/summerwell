/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int i = 0;
    int j = digitCount(x) - 1;
    while(i < j) {
      if (extractDigit(x, i) != extractDigit(x, j)) return false;
      i++;
      j--;
    }
    return true;
  }

  private int digitCount(int x) {
    int count = 0;

    do {
      count++;
      x /= 10;
    } while (x != 0);

    return count;
  }

  private int extractDigit(int x, int pos) {
    return (x / (int)Math.pow(10, pos)) % 10;
  }
}
