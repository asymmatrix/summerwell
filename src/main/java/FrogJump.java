import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;


/**
 * https://leetcode.com/problems/frog-jump/
 */
public class FrogJump {

  static private final int JUMP_DELTA[] = {-1, 0, 1};

  public boolean canCross(int[] stones) {
    Map<Pair<Integer, Long>, Boolean> dp = new HashMap<>();
    return canCrossDp(stones, 0,1, dp);
  }

  boolean canCrossDp(int[] stones, int startPos, long firstJumpUnit, Map<Pair<Integer, Long>, Boolean> dp) {
    if (startPos == stones.length - 1) {
      return true;
    }

    Pair<Integer, Long>  key = new Pair<>(startPos, firstJumpUnit);
    if (dp.containsKey(key)) {
      return dp.get(key);
    }

    int nextStartPos = landPositionIndex(stones, startPos, firstJumpUnit);
    if (nextStartPos < 0) {
      dp.put(key, false);
      return false;
    }

    boolean result = false;
    for(int delta: JUMP_DELTA) {
      long jump = firstJumpUnit + delta;
      if (jump > 0) {
        boolean r = canCrossDp(stones, nextStartPos, jump, dp);
        if (r) {
          result = true;
          break;
        }
      }
    }

    dp.put(key, result);
    return result;
  }

  private int landPositionIndex(int[] stones, int startPos, long jump) {
    int v = (int)(stones[startPos] + jump);
    return Arrays.binarySearch(stones, startPos, stones.length, v);
  }
}
