import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 */
public class CountOfSmallerNumbersAfterSelf {
  public List<Integer> countSmaller(int[] nums) {

    Integer[] result = new Integer[nums.length];
    BstNode root = null;
    for (int i = nums.length - 1; i >= 0; i--) {
      AddNodeReturn ret = addNode(root, nums[i]);
      root = ret.node;
      result[i] = ret.answer;
    }
    return Arrays.asList(result);
  }

  private AddNodeReturn addNode(BstNode root, int key) {
    if (root == null) {
      root = new BstNode(key);
      return new AddNodeReturn(root, 0);
    }

    AddNodeReturn ret = new AddNodeReturn(root, 0);

    if (key == root.key) {
      root.occurrence++;
      ret.answer = root.leftTreeNodeCount;
    } else if (key < root.key) {
      AddNodeReturn retTemp = addNode(root.left, key);
      root.left = retTemp.node;
      root.leftTreeNodeCount++;
      ret.answer = retTemp.answer;
    } else {
      AddNodeReturn retTemp = addNode(root.right, key);
      root.right = retTemp.node;
      ret.answer = root.leftTreeNodeCount + root.occurrence + retTemp.answer;
    }

    return ret;
  }

  class AddNodeReturn {
    BstNode node;
    int answer;
    AddNodeReturn(BstNode node, int answer) {
      this.node = node;
      this.answer = answer;
    }
  }

  class BstNode {
    int key;
    int occurrence;
    int leftTreeNodeCount;
    BstNode left;
    BstNode right;
    BstNode(int key) {
      this.key = key;
      this.occurrence = 1;
      this.leftTreeNodeCount = 0;
      this.left = null;
      this.right = null;
    }
  }
}
