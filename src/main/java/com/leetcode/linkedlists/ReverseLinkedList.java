package com.leetcode.linkedlists;

/**
 * @author sudhir on 29-Apr-2020
 */
public class ReverseLinkedList {
    // iterative approach to reverse the linked list
    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // recursive approach to reverse the linked list
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rest = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
}
