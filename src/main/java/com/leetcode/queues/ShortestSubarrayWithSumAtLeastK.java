package com.leetcode.queues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.<br/>
 * If there is no non-empty subarray with sum at least K, return -1.<br/>
 * 1 <= K <= 10 ^ 9
 *
 * @author sudhir on 13-May-2020
 */
public class ShortestSubarrayWithSumAtLeastK {
    // special case: All numbers are positive i.e. A[i] >= 0. Time complexity: O(n)
    public int shortestSubarraySpecialCase(int[] A, int K) {
        int sum = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        for (int end = 0; end < A.length; end++) {
            sum += A[end];
            // while the sum is still >= K, we keep shrinking the window so that we get minimum length and update our answer
            while (sum >= K) {
                minLen = Math.min(end - start + 1, minLen);
                sum -= A[start];
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    // A[i] can be positive or negative: leetcode problem: Time complexity: O(n)
    public int shortestSubarray(int[] A, int K) {
        // deque maintains the indices of the prefixSum array
        Deque<Integer> deque = new LinkedList<>();
        // construct prefix-sum array of size (n + 1)
        int[] prefixSum = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < prefixSum.length; i++) {
            // since we need shortest subarray, we keep removing indices from the front of the queue
            // as long as the condition prefixSum[i] - prefixSum[deque.peekFirst()] >= K is satisfied
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= K) {
                minLen = Math.min(i - deque.peekFirst(), minLen);
                deque.pollFirst();
            }

            // we need to maintain increasing order of prefixSums in the queue. so we check the current prefixSum
            // with the sum at the peekLast() and keep polling the indices till we don't get such indices
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekLast()] <= 0) {
                deque.pollLast();
            }
            // offer the current index to the queue
            deque.offer(i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
