import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/combinations/
 */
public class Combinations {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> answer = new ArrayList<>();
    List<Integer> buf = new ArrayList<>();
    combine(n, k, 1, buf, answer);
    return  answer;
  }

  private void combine(int n, int k, int min, List<Integer> buf, List<List<Integer>> answer) {
    if (k == 0) {
      ArrayList<Integer> temp = new ArrayList<>(buf.size());
      temp.addAll(buf);
      answer.add(temp);
      return;
    }

    for (int x = min; x <= n - k + 1; x++) {
      buf.add(x);
      combine(n, k - 1, x + 1, buf, answer);
      buf.remove(buf.size() - 1);
    }
  }
}
