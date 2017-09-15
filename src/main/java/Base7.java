/**
 * https://leetcode.com/problems/base-7/
 */
public class Base7 {
  public String convertToBase7(int num) {
    if (num == 0) return "0";

    String sign = "";
    if (num < 0) {
      sign = "-";
      num = -num;
    }

    StringBuilder sb = new StringBuilder();
    while(num > 0) {
      sb.append(num % 7);
      num /= 7;
    }
    sb.reverse();
    return sign + sb.toString();
  }
}
