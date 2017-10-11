import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {
  public List<Integer> largestValues(TreeNode root) {

    ArrayList<Integer> answer = new ArrayList<>();
    if (root == null) {
      return answer;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);

    int max = Integer.MIN_VALUE;
    while(!queue.isEmpty()) {
      TreeNode curr = queue.poll();
      if (curr == null) {
        answer.add(max);
        max = Integer.MIN_VALUE;
        if (!queue.isEmpty()) {
          queue.offer(null);
        }
      } else {
        max = Math.max(max, curr.val);
        if (curr.left != null) queue.offer(curr.left);
        if (curr.right != null) queue.offer(curr.right);
      }
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
