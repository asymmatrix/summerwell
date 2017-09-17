/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

  int start, len;

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) return s;

    start = 0;
    len = 1;
    for (int i = 0; i < s.length(); i++) {
      expend(s, i, i);
      expend(s, i, i + 1);
    }

    return s.substring(start, start + len);
  }

  void expend(String s, int left, int right) {
    while (left >= 0 && right < s.length()) {
      if (s.charAt(left) != s.charAt(right)) break;
      left--;
      right++;
    }

    left++;
    right--;

    if (right - left + 1 > len) {
      start = left;
      len = right - left + 1;
    }
  }
}
