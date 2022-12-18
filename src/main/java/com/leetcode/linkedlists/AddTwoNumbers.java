package com.leetcode.linkedlists;

/**
 * You are given two non-empty linked lists representing two non-negative integers. <br/>
 * The digits are stored in reverse order and each of their nodes contain a single digit.<br/>
 * Add the two numbers and return it as a linked list.<br/>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * @author sudhir on 29-Apr-2020
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode l3 = null;
        ListNode head = null;
        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            ListNode c = new ListNode(sum % 10);
            if (l3 == null) {
                l3 = c;
                head = l3;
            } else {
                l3.next = c;
                l3 = c;
            }
            sum = 0;
        }
        return head;
    }
}
