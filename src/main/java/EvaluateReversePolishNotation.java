import java.util.Arrays;
import java.util.Stack;


/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class EvaluateReversePolishNotation {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<> ();

    for(String str : tokens) {
      if (isOperator(str)) {
        int y = stack.pop();
        int x = stack.pop();
        stack.push(eval(x, y, str));
      } else {
        stack.push(Integer.parseInt(str));
      }
    }

    return stack.pop();
  }

  private boolean isOperator(String token) {
    char ch = token.charAt(0);
    return token.length() == 1 && (ch == '+' || ch == '-' || ch == '*' || ch == '/');
  }

  private int eval(int x, int y, String op) {
    if (op.charAt(0) == '+') return x + y;
    if (op.charAt(0) == '-') return x - y;
    if (op.charAt(0) == '*') return x * y;
    if (op.charAt(0) == '/') return x / y;
    return 0;
  }
}
