import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/can-i-win/
 */
public class CanIWin {
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

    int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
    if (sum < desiredTotal) {
      return false;
    }
    if (desiredTotal <= 0) {
      return true;
    }

    HashMap<Integer, Boolean> cache = new HashMap<>();
    return win(getBits(maxChoosableInteger), desiredTotal, true, cache);
  }

  private boolean win(int bits, int total, boolean firstPlayer, Map<Integer, Boolean> cache) {
    if (cache.containsKey(bits)) {
      return cache.get(bits);
    }

    if (total <= 0) {
      return false;
    }

    if (bits == 0) {
      return !firstPlayer;
    }

    boolean canOtherPlayWin = true;
    for(int i = 0; i < 32; i++) {
      if (isBitOn(bits, i)) {
        boolean temp = win(turnBitOff(bits, i), total - i - 1, !firstPlayer, cache);
        if (!temp) {
          canOtherPlayWin = false;
          break;
        }
      }
    }

    cache.put(bits, !canOtherPlayWin);
    return !canOtherPlayWin;
  }

  int getBits(int maxChoosableInteger) {
    int bits = 0;
    for(int i = 0; i < maxChoosableInteger; i++) {
      bits |= (1 << i);
    }
    return bits;
  }

  int turnBitOff(int bits, int i) {
    return bits & (~(1 << i));
  }

  boolean isBitOn(int bits, int i) {
    return (bits & (1 << i)) != 0;
  }
}
