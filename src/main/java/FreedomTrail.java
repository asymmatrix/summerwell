import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * https://leetcode.com/problems/freedom-trail/
 */
public class FreedomTrail {
  private final int NO_RESULT = -1;
  public int findRotateSteps(String ring, String key) {
    if (key == null || key.length() == 0) {
      return 0;
    }

    if (ring == null || ring.length() == 0) {
      return NO_RESULT;
    }

    Map<Character, Set<Integer>> charLoc = new HashMap<>();
    for (int i = 0; i < ring.length(); i++) {
      char c = ring.charAt(i);
      if (!charLoc.containsKey(c)) {
        charLoc.put(c, new HashSet<>());
      }
      charLoc.get(c).add(i);
    }

    int[][] dp = new int [key.length()][ring.length()];

    for (int k = key.length() - 1; k >= 0; k--) {
      char keyChar = key.charAt(k);
      if (!charLoc.containsKey(keyChar)) {
        return NO_RESULT;
      }

      for (int r : charLoc.get(keyChar)) {
        if (k == key.length() - 1) {
          dp[k][r] = 1;
        } else {
          int min = Integer.MAX_VALUE;
          char keyCharNext = key.charAt(k + 1);
          for (int rnext : charLoc.get(keyCharNext)) {
            int temp = ringDist(r, rnext, ring.length()) + dp[k + 1][rnext] + 1;
            min = Math.min(temp, min);
          }
          dp[k][r] = min;
        }
      }
    }

    int answer = Integer.MAX_VALUE;
    for (int r : charLoc.get(key.charAt(0))) {
      int temp = ringDist(0, r, ring.length()) + dp[0][r];
      answer = Math.min(temp, answer);
    }

    return answer;
  }

  private int ringDist(int x, int y, int ringLength) {
    int d = Math.abs(x - y);
    return Math.min(ringLength - d, d);
  }
}
