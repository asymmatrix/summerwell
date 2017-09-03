/**
 * https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 */
public class MaximumXORofTwoNumbersInAnArray {
  public int findMaximumXOR(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    BitTrie root = new BitTrie();
    for (int n : nums) insertBitTrie(root, n);

    int answer = Integer.MIN_VALUE;
    for(int n : nums) {
      int temp = findMaxXor(root, n);
      answer = Math.max(temp, answer);
    }

    return answer;
  }

  class BitTrie {
    BitTrie[] children = new BitTrie[2];
  }

  private void insertBitTrie(BitTrie root, int n) {
    BitTrie currentNode = root;
    for (int i = 31; i >= 0; i--) {
      int bit = getBit(n, i);
      if (currentNode.children[bit] == null) {
        currentNode.children[bit] = new BitTrie();
      }
      currentNode = currentNode.children[bit];
    }
  }

  private int findMaxXor(BitTrie root, int n) {
    BitTrie currentNode = root;
    int sum = 0;
    for (int i = 31; i >= 0; i--) {
      int bit = getBit(n, i);
      int xor = 0;
      if (currentNode.children[not(bit)] != null) {
        bit = not(bit);
        xor = 1;
      }
      sum = (sum << 1) | xor;
      currentNode = currentNode.children[bit];
    }
    return sum;
  }

  static private int getBit(int num, int bitPos) {
    return (num >> bitPos) & 1;
  }

  static private int not(int bit) {
    return (~bit) & 1;
  }
}
