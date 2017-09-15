/**
 * https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {
  public int rob(TreeNode root) {
    Robbery r = robRecursively(root);
    return Math.max(r.exclude, r.include);
  }

  Robbery robRecursively(TreeNode root) {
    if (root == null) {
      return new Robbery(0, 0);
    }

    Robbery left = robRecursively(root.left);
    Robbery right = robRecursively(root.right);

    int include = root.val + left.exclude + right.exclude;
    int exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);
    return new Robbery(include, exclude);
  }


  private class Robbery {
    int include, exclude;
    Robbery (int inc, int exc) {
      this.include = inc;
      this.exclude = exc;
    }
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
