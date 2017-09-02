import java.util.LinkedList;


/**
 * https://leetcode.com/problems/find-bottom-left-tree-value/
 */
public class FindBottomLeftTreeValue {
  public int findBottomLeftValue(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int answer = 0;

    while(!queue.isEmpty()) {
      TreeNode node = queue.pollFirst();
      answer = node.val;
      if (node.right != null) queue.offer(node.right);
      if (node.left != null) queue.offer(node.left);
    }

    return answer;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
