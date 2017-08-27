import java.util.HashMap;


/**
 * https://leetcode.com/problems/integer-replacement/
 */
public class IntegerReplacement {
  public int integerReplacement(int n) {
    if (n <= 0) {
      return Integer.MAX_VALUE;
    }

    HashMap<Long, Integer> cache = new HashMap<>();
    cache.put(1L, 0);
    return calculate(n, cache);
  }

  private int calculate(long x, HashMap<Long, Integer> cache) {
    if(cache.containsKey(x)) return cache.get(x);
    int answer = Integer.MAX_VALUE;
    if (x % 2 == 0) {
      answer = 1 + calculate(x / 2, cache);
    } else {
      answer = 2 + Math.min(
          calculate((x - 1) / 2, cache),
          calculate((x + 1) / 2, cache));
    }
    cache.put(x, answer);
    return answer;
  }
}
