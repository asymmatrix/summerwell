import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
  public int coinChange(int[] coins, int amount) {
    Map<Integer, Integer> map = new HashMap<>();
    return find(coins, amount, map);
  }

  private int find(int[] coins, int amount, Map<Integer, Integer> map) {
    if (amount < 0) {
      return -1;
    }
    if (amount == 0) {
      return 0;
    }

    Integer cache = map.get(amount);
    if (cache != null) {
      return cache;
    }

    int answer = -1;
    for (int coin : coins) {
      if (amount >= coin) {
        int temp = find(coins, amount - coin, map);
        if (temp >= 0) {
          if (answer < 0) answer = temp + 1;
          else answer = Math.min(answer, temp + 1);
        }
      }
    }
    map.put(amount, answer);
    return answer;
  }
}
