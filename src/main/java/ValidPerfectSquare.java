public class ValidPerfectSquare {
  public boolean isPerfectSquare(int val) {
    long num = val;
    if (num < 0) num = -num;
    if (num == 0 || num == 1 || num == 4) return true;
    if (num == 3) return false;
    long i = 0;
    long j = num / 2;
    while(i < j) {
      if (i * i == num || j * j == num) return true;
      long mid = (i + j) / 2;
      long x = mid * mid;
      if (x == num) return true;
      else if (x > num)
        j = mid - 1;
      else
        i = mid + 1;
    }
    return false;
  }
}
