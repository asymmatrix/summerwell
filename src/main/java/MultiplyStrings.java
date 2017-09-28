/**
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
  public String multiply(String num1, String num2) {
    if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
      return "";
    }

    String result = "0";
    for(int i = 0; i < num2.length(); i++) {
      int digit = num2.charAt(i) - '0';
      result = add(mult(result, 10), mult(num1, digit));
    }

    return result;
  }

  private String add(String a, String b) {
    if (a.length() == 1 && a.charAt(0) == '0') return b;
    if (b.length() == 1 && b.charAt(0) == '0') return a;

    StringBuilder sb = new StringBuilder();
    int carry = 0;

    int ia = a.length() - 1;
    int ib = b.length() - 1;

    while(ia >= 0 || ib >= 0) {
      int num_a = ia >= 0 ? a.charAt(ia--) - '0' : 0;
      int num_b = ib >= 0 ? b.charAt(ib--) - '0' : 0;
      int x = num_a + num_b + carry;
      sb.append(toChar(x % 10));
      carry = x / 10;
    }

    if (carry > 0) {
      sb.append(toChar(carry));
    }

    return sb.reverse().toString();
  }

  private String mult(String a, int b) {
    if (b == 0) return "0";
    if (a.length() == 1 && a.charAt(0) == '0') return "0";
    if (b == 10) return a + "0";

    StringBuilder sb = new StringBuilder();

    int carry = 0;
    for(int i = a.length() - 1; i >= 0; i--) {
      int x = a.charAt(i) - '0';
      int currentDigit = (x * b + carry) % 10;
      carry = (x * b + carry) / 10;
      sb.append(toChar(currentDigit));
    }

    if (carry > 0) {
      sb.append(toChar(carry));
    }

    return sb.reverse().toString();
  }

  private char toChar(int digit) {
    return (char)('0' + digit);
  }
}
