/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsAndCows {
  public String getHint(String secret, String guess) {
    if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0) {
      return "0A0B";
    }

    int bullsCount = 0;
    int[] bullsDigitCount= new int[10];
    for(int i = 0; i < secret.length() && i < guess.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bullsCount++;
        bullsDigitCount[secret.charAt(i) - '0']++;
      }
    }

    int[] secretDigitCount = countDigit(secret);
    int[] guessDigitCount = countDigit(guess);

    int cowsCount = 0;
    for(int i = 0; i <= 9; i++) {
      cowsCount += Math.min(secretDigitCount[i], guessDigitCount[i]) - bullsDigitCount[i];
    }

    return String.format("%dA%dB", bullsCount, cowsCount);
  }

  private int[] countDigit(String str) {
    int[] digitCount = new int[10];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c >= '0' && c <= '9') {
        digitCount[c - '0']++;
      }
    }
    return digitCount;
  }
}
