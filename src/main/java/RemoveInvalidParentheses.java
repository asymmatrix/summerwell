import java.util.ArrayList;
import java.util.List;


/**
 *  https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {
  private static final char[] PAR = {'(', ')'};
  private static final char[] PAR_REV = {')', '('};

  public List<String> removeInvalidParentheses(String s) {
    List<String> answer = new ArrayList<>();
    remove(s, 0, 0, answer, PAR);
    return answer;
  }

  private void remove(String s, int cursor, int lastRemovalIndex, List<String> answer, char[] par) {
    int stack = 0;
    int i;
    for (i = cursor; i < s.length(); i++) {
      if (s.charAt(i) == par[0]) stack++;
      if (s.charAt(i) == par[1]) stack--;
      if (stack < 0) break;
    }

    if (stack < 0) {
      for (int j = i; j >= lastRemovalIndex; j--) {
        if (s.charAt(j) == par[1] && (j == 0 || s.charAt(j - 1) != par[1])) {
          String newStr = s.substring(0, j) + s.substring(j + 1, s.length());
          remove(newStr, i, j, answer, par);
        }
      }
    } else {
      if (par[0] == '(') {
        remove(reverse(s), 0, 0, answer, PAR_REV);
      } else {
        addToAnswer(s, answer, par);
      }
    }
  }

  private String reverse(String s) {
    return new StringBuilder(s).reverse().toString();
  }

  private void addToAnswer(String s, List<String> answer, char[] par) {
    answer.add(par[0] == '(' ? s : reverse(s));
  }
}
