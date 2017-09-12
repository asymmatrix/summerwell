/**
 * https://leetcode.com/problems/total-hamming-distance/
 */
public class TotalHammingDistance {
  public int totalHammingDistance(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int[] oneCount = new int[32];

    for(int n : nums) {
      for(int i = 0; i < 32; i++) {
        if ((n & (1 << i)) != 0) {
          oneCount[i]++;
        }
      }
    }

    int answer = 0;

    for(int i = 0; i < oneCount.length; i++) {
      answer += (nums.length - oneCount[i]) * oneCount[i];
    }

    return answer;
  }
}
