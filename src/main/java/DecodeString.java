/**
 * https://leetcode.com/problems/decode-string/
 */
public class DecodeString {
  public String decodeString(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    for(int start = 0; start < s.length(); ) {
      start = decode(s, start, sb);
    }

    return sb.toString();
  }

  private int decode(String s, int start, StringBuilder sb) {
    if (!isNumber(s.charAt(start))) {
      while (start < s.length() && isAlphabet(s.charAt(start))) {
        sb.append(s.charAt(start));
        start++;
      }
      return start;
    }

    // find the repeating number
    int occurrence = 0;
    while(start < s.length() && isNumber(s.charAt(start))) {
      occurrence = occurrence * 10 + (s.charAt(start) - '0');
      start++;
    }

    int end = findMatchingBracket(s, start);
    StringBuilder subSB = new StringBuilder();

    for (int i = start + 1; i < end; ) {
      i = decode(s, i, subSB);
    }

    for (int o = 0; o < occurrence; o++) {
      sb.append(subSB);
    }

    return end + 1;

  }

  private boolean isNumber(char c) {
    return c >= '0' && c <= '9';
  }

  private boolean isAlphabet(char c) {
    return !isNumber(c) && c != '[' && c != ']';
  }

  private int findMatchingBracket(String s, int openBracketIndex) {
    int num = 0;
    for (int i = openBracketIndex; i < s.length(); i++) {
      if (s.charAt(i) == '[') num ++;
      else if (s.charAt(i) == ']') num--;
      if (num == 0) {
        return i;
      }
    }
    return s.length();
  }
}
