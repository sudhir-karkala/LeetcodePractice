package com.leetcode.linkedlists;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * This implementation uses merge sort.
 *
 * @author sudhir on 30-Apr-2020
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head, slow = head, mid = slow;
        while (fast != null && fast.next != null) {
            mid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        mid.next = null; // cut the list in the middle

        // nodes from head to mid will form left part of the list
        // nodes from slow to end will form right part of the list
        // sort left and right parts recursively
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        //merge left and right parts
        ListNode result = merge(left, right);
        return result;
    }

    // this will be sorted merge operation
    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode result;
        if (left.val < right.val) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }
}
