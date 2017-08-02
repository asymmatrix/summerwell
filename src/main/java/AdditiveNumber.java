import java.math.BigInteger;


/**
 * https://leetcode.com/problems/additive-number/description/
 */
public class AdditiveNumber {
  public boolean isAdditiveNumber(String num) {
    if (num == null || num.isEmpty()) {
      return false;
    }

    for (int firstNumLen = 1; firstNumLen <= num.length() / 2 + 1; firstNumLen++) {
      if (isAdditiveNumber(num, 0, firstNumLen)) {
        return true;
      }
    }

    return false;
  }

  private boolean isAdditiveNumber(String num, int firstNumbStart, int firstNumLen) {
    if (firstNumbStart >= num.length() || num.charAt(firstNumbStart) == '0' && firstNumLen > 1) {
      return false;
    }

    int secondNumStart = firstNumbStart + firstNumLen;
    if (secondNumStart >= num.length()) {
      return false;
    }

    BigInteger firstNum = subStringToBigInteger(num, firstNumbStart, firstNumLen);

    for (int secondNumLen = 1; ; secondNumLen++) {
      if (num.charAt(secondNumStart) == '0' && secondNumLen > 1) {
        break;
      }
      int restLen = num.length() - (secondNumStart + secondNumLen);
      if (firstNumLen > restLen || secondNumLen > restLen) {
        break;
      }
      BigInteger secondNum = subStringToBigInteger(num, secondNumStart, secondNumLen);
      String sum = firstNum.add(secondNum).toString();
      String restStr = num.substring(secondNumStart + secondNumLen);
      if (sum.equals(restStr)) {
        return true;
      }
      if (restStr.startsWith(sum) && isAdditiveNumber(num, secondNumStart, secondNumLen)) {
        return true;
      }
    }
    return false;
  }

  private BigInteger subStringToBigInteger(String str, int start, int len) {
    return new BigInteger(str.substring(start, start + len));
  }
}
