package com.leetcode.linkedlists;

/**
 * Sort a linked list using insertion sort.
 *
 * @author sudhir on 30-Apr-2020
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // this is the pointer to the sorted list which is the new head.
        ListNode sorted = null;
        ListNode cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            // pass the pointer to the sorted list to the method where it is updated if needed.
            sorted = sortedInsert(cur, sorted);
            cur = next;
        }
        return sorted;
    }

    // method which performs sorted insert and returns the pointer to the sorted list
    private ListNode sortedInsert(ListNode toInsert, ListNode sorted) {
        if (sorted == null || sorted.val >= toInsert.val) { // node to be inserted will be the first node
            toInsert.next = sorted;
            sorted = toInsert;
        } else { // otherwise search for the appropriate position and insert the node
            ListNode cur = sorted;
            while (cur.next != null && cur.next.val <= toInsert.val) {
                cur = cur.next;
            }
            toInsert.next = cur.next;
            cur.next = toInsert;
        }
        return sorted;
    }
}
