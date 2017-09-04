
/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 */
public class ReconstructOriginalDigitsFromEnglish {
  public String originalDigits(String s) {
    int[] charCount = new int[26];
    for(Character c : s.toCharArray()) {
      charCount[c - 'a']++;
    }

    int[] digitCount = new int[10];

    // 'z' == '0'
    digitCount[0] = charCount['z' - 'a'];

    // 'w' == '2'
    digitCount[2] = charCount['w' - 'a'];

    // 'x' == '6'
    digitCount[6] = charCount['x' - 'a'];

    // 'u' == '4'
    digitCount[4] = charCount['u' - 'a'];

    // 'g' == '8'
    digitCount[8] = charCount['g' - 'a'];

    // 's' - 'x' == '7';
    digitCount[7] = charCount['s' - 'a'] - charCount['x' - 'a'];

    // 'f' - 'u' == '5'
    digitCount[5] = charCount['f' - 'a'] - charCount['u' - 'a'];

    // 'o' - '0' - '2' - '4' == '1';
    digitCount[1] = charCount['o' - 'a'] - digitCount[0] - digitCount[2] - digitCount[4];

    // 'i' - '5' - '6' - '8' == '9'
    digitCount[9] = charCount['i' - 'a'] - digitCount[5] - digitCount[6] - digitCount[8];

    // 'h' - '8' == '3'
    digitCount[3] = charCount['h' - 'a'] - digitCount[8];

    StringBuffer answer = new StringBuffer();
    for(int i = 0; i <= 9; i++) {
      while (digitCount[i]-- > 0) {
        answer.append(i);
      }
    }
    return answer.toString();
  }
}
