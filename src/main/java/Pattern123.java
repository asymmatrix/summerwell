import java.util.Stack;


/**
 * https://leetcode.com/problems/132-pattern/
 */
public class Pattern123 {
  public boolean find132pattern(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }

    Stack<Seg> stack = new Stack<>();


    for(int n : nums) {
      if (stack.empty() || n < stack.peek().min) {
        stack.push(new Seg(n, n));
        continue;
      }

      if (n > stack.peek().min) {
        if (n < stack.peek().max) return true;

        Seg seg = stack.pop();
        seg.max = n;

        while(!stack.empty()) {
          if (stack.peek().min < n && n < stack.peek().max) return true;
          if (n >= stack.peek().max) {
            stack.pop();
          } else {
            break;
          }
        }

        stack.push(seg);
      }
    }

    return false;
  }


  class Seg{
    int min, max;
    public Seg(int min, int max){
      this.min = min;
      this.max = max;
    }
  }
}
