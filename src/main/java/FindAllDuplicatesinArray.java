import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindAllDuplicatesinArray {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return result;
    }

    for (int i = 0; i < nums.length; i++) {
      int cntIndex = getNumber(nums[i] ) - 1;
      nums[cntIndex] = increaseCount(nums[cntIndex]);
    }

    for (int i = 0; i < nums.length; i++) {
      if (getCount(nums[i]) == 2) {
        result.add(i + 1);
      }
    }
    return result;
  }


  private int increaseCount(int data) {
    int cnt = data >> 30;
    cnt++;
    return (cnt << 30) | (data & 0x3FFFFFFF);
  }

  private int getCount(int data) {
    return (data >> 30) & 0x3;
  }

  private int getNumber(int data) {
    return data & 0x3FFFFFFF;
  }
}
