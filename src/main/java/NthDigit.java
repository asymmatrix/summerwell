/**
 * https://leetcode.com/problems/nth-digit/
 */
public class NthDigit {

  public int findNthDigit(int n) {
    long[] digitCount = this.calcDigitCount();
    long[] startNumber = this.calcStartNumber();

    int digits = -1;
    for(int i = 1; i < digitCount.length; i++) {
      if (digitCount[i] >= n) {
        digits = i;
        break;
      }
    }

    if (digits == -1) {
      // invalid input
      return -1;
    }

    n -= digitCount[digits - 1];

    long start = startNumber[digits];
    int offset = (n - 1) / digits;
    Long number = start + offset;
    int numberDigitOffset = (n - 1) % digits;
    return number.toString().charAt(numberDigitOffset) - '0';
  }

  static private long[] calcDigitCount() {
    long[] count = new long[11];
    long tenPower = 1;
    for (int d = 1; d < count.length; d++) {
      count[d] = count[d - 1] + 9 * tenPower * d;
      tenPower *= 10;
    }
    return count;
  }

  static private long[] calcStartNumber() {
    long[] start = new long[11];
    long tenPower = 1;
    for (int d = 1; d < start.length; d++) {
      start[d] = tenPower;
      tenPower *= 10;
    }
    return start;
  }
}
