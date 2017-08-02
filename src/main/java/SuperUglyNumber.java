/**
 * https://leetcode.com/problems/super-ugly-number/description/
 */
public class SuperUglyNumber {

  public int nthSuperUglyNumber(int n, int[] primes) {
    if (n < 1 || primes == null || primes.length == 0) {
      return -1;
    }

    int[] cursor = new int[primes.length];
    int[] uglyNum = new int[n];
    int uglyCnt = 0;
    uglyNum[uglyCnt++] = 1;

    while(uglyCnt < n) {
      int nextUrlyNum = -1;
      int indexOfPrimeToMove = -1;
      for (int i = 0; i < primes.length; i++) {
        if (nextUrlyNum > 0 && primes[i] >= nextUrlyNum) {
          break;
        }
        int tmp = primes[i] * uglyNum[cursor[i]];
        if (nextUrlyNum < 0 || nextUrlyNum > tmp) {
          nextUrlyNum = tmp;
          indexOfPrimeToMove = i;
        }
      }

      if (nextUrlyNum > uglyNum[uglyCnt - 1]) {
        uglyNum[uglyCnt++] = nextUrlyNum;
      }
      cursor[indexOfPrimeToMove]++;
    }

    return uglyNum[n - 1];
  }
}
