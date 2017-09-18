import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * https://leetcode.com/problems/palindrome-pairs/
 */
public class PalindromePairs {
  public List<List<Integer>> palindromePairs(String[] words) {

    Map<String, Integer> index = new HashMap<String, Integer>();
    for(int i = 0; i < words.length; i++) {
      index.put(words[i], i);
    }

    List<List<Integer>> answer = new ArrayList<>();
    for(int i = 0; i < words.length; i++) {
      String word = words[i];

      for(int len = 0; len <= word.length(); len++) {
        String left = word.substring(0, len);
        String right = word.substring(len, word.length());
        if (isPalindrome(left)) {
          String prefix = new StringBuffer(right).reverse().toString();
          int j = index.getOrDefault(prefix, -1);
          if (j >= 0 && j != i) {
            answer.add(Arrays.asList(j, i));
          }
        }
        if (right.length() > 0 && isPalindrome(right)) {
          String suffix = new StringBuffer(left).reverse().toString();
          int j = index.getOrDefault(suffix, -1);
          if (j >= 0 && j != i) {
            answer.add(Arrays.asList(i, j));
          }
        }
      }
    }

    return answer;
  }

  private boolean isPalindrome(String str) {
    int start = 0;
    int end = str.length() - 1;

    while(start <= end) {
      if (str.charAt(start) != str.charAt(end)) return false;
      start++;
      end--;
    }

    return true;
  }
}
