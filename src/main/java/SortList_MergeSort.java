/**
 * https://leetcode.com/problems/sort-list/
 */
public class SortList_MergeSort {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    // split
    ListNode pSlow = head;
    ListNode pFast = head;
    ListNode leftEnd = null;
    while(pSlow != null && pFast != null && pFast.next != null) {
      leftEnd = pSlow;
      pSlow = pSlow.next;
      pFast = pFast.next.next;
    }

    leftEnd.next = null;

    // sort
    ListNode left = sortList(head);
    ListNode right = sortList(pSlow);


    return merge(left, right);
  }

  ListNode merge(ListNode left, ListNode right) {
    ListNode head = new ListNode(-1);
    ListNode tail = head;

    while(left != null && right != null) {
      if (left.val <= right.val) {
        tail.next = left;
        left = left.next;
      } else {
        tail.next = right;
        right = right.next;
      }
      tail = tail.next;
    }
    if (left != null) tail.next = left;
    if (right != null) tail.next = right;
    return head.next;
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
}
