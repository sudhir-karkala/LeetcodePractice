package com.leetcode.linkedlists;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. <br/>
 * The most significant digit comes first and each of their nodes contain a single digit. <br/>
 * Add the two numbers and return it as a linked list.<br/>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.<br/>
 * Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * @author sudhir on 29-Apr-2020
 */
public class AddTwoNumbersII {
    private ListNode result; // used by approach 3
    private ListNode cur; // used by approach 3
    private ListNode head1, head2; // used by approach 3
    private int carry;

    // approach 1: reverse the two lists and then add numbers of both the lists, creating new nodes and then reverse the resultant list
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode l3 = null;
        ListNode head = null;
        // reverse l1
        l1 = reverse(l1);
        // reverse l2
        l2 = reverse(l2);
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
        // reverse the resultant linked list
        head = reverse(head);
        return head;
    }

    // this utility method to reverse the list is used by approach 1.
    private ListNode reverse(ListNode l1) {
        if (l1 == null || l1.next == null) {
            return l1;
        }
        ListNode cur = l1;
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

    // approach 2: using stacks.
    public ListNode addTwoNumbersUsingStacks(ListNode l1, ListNode l2) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ListNode p = l1;
        while (p != null) {
            st1.push(p.val);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            st2.push(p.val);
            p = p.next;
        }
        int sum = 0;
        int carry = 0;
        ListNode head = null;
        while (!st1.isEmpty() || !st2.isEmpty() || carry > 0) {
            if (!st1.isEmpty()) {
                sum += st1.pop();
            }
            if (!st2.isEmpty()) {
                sum += st2.pop();
            }
            sum += carry;
            carry = sum / 10;
            ListNode c = new ListNode(sum % 10);
            if (head == null) {
                head = c;
            } else {
                c.next = head;
                head = c;
            }
            sum = 0;
        }
        return head;
    }

    // approach 3: using recursion and no extra space
    public ListNode addTwoNumbersUsingRecursion(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        head1 = l1;
        head2 = l2;
        int size1 = getSize(head1);
        int size2 = getSize(head2);
        if (size1 == size2) {
            addTwoLists(head1, head2);
        } else {
            if (size1 < size2) {
                head1 = l2;
                head2 = l1;
            }
            ListNode p = head1;
            int diff = Math.abs(size1 - size2);
            while (diff > 0) {
                cur = p;
                p = p.next;
                diff--;
            }
            addTwoLists(p, head2);
            // perform the addition of remaining first list and carry
            handleCarry(head1);
        }
        if (carry > 0) {
            pushToResult(carry);
        }
        return result;
    }

    // after adding two lists of same size, we need to handle any carry which we received and then add the carry
    // to the remaining part of bigger list
    private void handleCarry(ListNode head1) {
        if (head1 != cur) {
            handleCarry(head1.next);
        }
        int sum = head1.val + carry;
        carry = sum / 10;
        pushToResult(sum % 10);
    }

    // add two lists of same size
    private void addTwoLists(ListNode p, ListNode q) {
        if (p == null) {
            return;
        }
        // make recursive calls till we reach the last node of both the lists
        addTwoLists(p.next, q.next);
        // now we add corresponding values and handle carry
        int sum = p.val + q.val + carry;
        carry = sum / 10;
        pushToResult(sum % 10);
    }

    // construct a new node for sum value and keep appending the node to the list of nodes
    private void pushToResult(int val) {
        ListNode newNode = new ListNode(val);
        if (result == null) {
            result = newNode;
        } else {
            newNode.next = result;
            result = newNode;
        }
    }

    // returns the size of the list
    private int getSize(ListNode p) {
        ListNode q = p;
        int count = 0;
        while (q != null) {
            count++;
            q = q.next;
        }
        return count;
    }
}
