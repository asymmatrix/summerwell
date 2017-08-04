/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
public class RemoveDuplicateLetters {

  public String removeDuplicateLetters(String s) {
    if (s == null) {
      return "";
    }

    StringBuilder result = new StringBuilder();

    while(s.length() > 0) {

      int[] count = countCharNumbers(s);

      int minCharPos = 0;
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (ch < s.charAt(minCharPos)) {
          minCharPos = i;
        }
        count[ch - 'a']--;
        if (count[ch - 'a'] == 0) {
          break;
        }
      }

      Character minChar = s.charAt(minCharPos);
      result.append(minChar);
      s = s.substring(minCharPos + 1).replace(minChar.toString(), "");
    }

    return result.toString();
  }

  private int[] countCharNumbers(String s) {
    int[] count = new int [26];
    for(int i = 0; i < s.length(); i++) {
      if (isLowerCaseLetter(s.charAt(i))) {
        count[s.charAt(i) - 'a']++;
      }
    }
    return count;
  }

  private boolean isLowerCaseLetter(char c) {
    return c >= 'a' && c <= 'z';
  }
}
