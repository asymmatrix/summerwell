/**
 * https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 */
public class MinimumAbsoluteDifferenceinBST {

  private int prev = -1;
  private int answer = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    inOrder(root);
    return answer;
  }

  private void inOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    inOrder(root.left);
    if (prev >= 0) {
      int temp = root.val - prev;
      answer = Math.min(answer, temp);
    }
    prev = root.val;
    inOrder(root.right);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
