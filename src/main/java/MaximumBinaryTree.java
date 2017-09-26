/**
 * https://leetcode.com/problems/maximum-binary-tree/
 */
public class MaximumBinaryTree {
  public TreeNode constructMaximumBinaryTree(int[] nums) {

    return construct(nums, 0, nums.length);
  }

  private TreeNode construct(int[] nums, int begin, int end) {
    if (begin >= end) return null;
    int rootIndex = findMax(nums, begin, end);
    TreeNode root = new TreeNode(nums[rootIndex]);
    root.left = construct(nums, begin, rootIndex);
    root.right = construct(nums, rootIndex + 1, end);
    return root;
  }

  private int findMax(int[] nums, int begin, int end) {
    int index = begin;
    int max = nums[begin];

    for(int i = begin + 1; i < end; i++) {
      if (nums[i] > max) {
        max = nums[i];
        index = i;
      }
    }

    return index;
  }


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
