/**
 * https://leetcode.com/problems/sort-list/
 */
public class SortList_QuickSort {

  public ListNode sortList(ListNode head) {
    ListNode[] sorted = sortHelper(head);
    return sorted == null ?  null : sorted[0];
  }

  private ListNode[] sortHelper(ListNode head) {
    if (head == null) {
      return null;
    }

    if (head.next == null) {
      return new ListNode[] {head, head};
    }

    // partition
    ListBuilder leftBldr = new ListBuilder();
    ListBuilder rightBldr = new ListBuilder();

    int pivot = head.val;
    ListNode p = head.next;

    while(p != null) {
      ListNode pNext = p.next;
      if (p.val < pivot) leftBldr.addLast(p);
      else rightBldr.addLast(p);
      p = pNext;
    }

    if (leftBldr.getHead() == null) leftBldr.addLast(head);
    else rightBldr.addLast(head);

    // sort
    ListNode[] leftSorted = sortHelper(leftBldr.getHead());
    ListNode[] rightSorted = sortHelper(rightBldr.getHead());

    if (leftSorted == null) return rightSorted;
    if (rightSorted == null) return leftSorted;

    leftSorted[1].next = rightSorted[0];
    return new ListNode[] { leftSorted[0], rightSorted[1] };
  }

  private class ListBuilder {
    private ListNode head;
    private ListNode tail;

    void addLast(ListNode node) {
      node.next = null;
      if (head == null) {
        head = node;
        tail = node;
      } else {
        tail.next = node;
        tail = node;
      }
    }

    ListNode getHead() {
      return this.head;
    }
  }

  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

}
