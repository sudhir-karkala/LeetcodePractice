package com.leetcode.queues;

import java.util.*;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * @author sudhir on 11-May-2020
 */
public class SlidingWindowMaximum {
    // Approach: Using Deque: leetcode runtime: 33 ms
    public int[] maxSlidingWindow(int[] nums, int k) {
        // deque is used to hold indices of the elements. Two kinds of operations are performed:
        // 1. the first element of the deque is always the maintained as the maximum of the current window. For every
        // incoming element we check if the element pointed by the index at the front is part of the current window.
        // If not, we remove that entry from the front, else we do nothing.

        // 2. When we encounter smaller elements, we keep enqueuing them at the rear end by comparing with the rear elements.
        // When we encounter element that is larger than the element pointed by the rear index,
        // then keep dequeuing the indices from rear until we find an index whose element is larger than the incoming element
        // or till the queue is empty and then insert the current element's index
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        int[] result = new int[nums.length - k + 1];
        for (int i = 1; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result[0] = nums[deque.peekFirst()];

        for (int i = k; i < nums.length; i++) {
            // check if the front element is part of the current window and remove if it's not
            if (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }
            // check if rear element is smaller than the incoming element and poll them accordingly.
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    // Approach: Using brute force: leetcode runtime: 94 ms
    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int[] result;
        if (nums.length > 0) {
            int start = 0;
            result = new int[nums.length - k + 1];
            for (int i = 0; i <= nums.length - k; i++) {
                int maxEle = nums[i];
                for (int j = i + 1; j - i < k; j++) {
                    if (nums[j] > maxEle) {
                        maxEle = nums[j];
                    }
                }
                result[start++] = maxEle;
            }
        } else {
            result = new int[0];
        }
        return result;
    }

    // Approach: Using max heap: leetcode runtime: 15 ms
    class Pair {
        int element;
        int index;

        public Pair(int element, int index) {
            this.element = element;
            this.index = index;
        }
    }

    public int[] maxSlidingWindowUsingMaxHeap(int[] nums, int k) {
        ArrayList<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new Pair(nums[i], i));
        }

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.valueOf(o2.element).compareTo(Integer.valueOf(o1.element));
            }
        });
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            priorityQueue.add(pairs.get(i));
        }
        result[0] = priorityQueue.peek().element;
        for (int i = k; i < nums.length; i++) {
            // remove out of window elements
            while (!priorityQueue.isEmpty() && (i - k) >= priorityQueue.peek().index) {
                priorityQueue.poll();
            }
            priorityQueue.add(pairs.get(i));
            result[i - k + 1] = priorityQueue.peek().element;
        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(s.maxSlidingWindowBruteForce(nums, k)));
        System.out.println(Arrays.toString(s.maxSlidingWindowUsingMaxHeap(nums, k)));
    }
}
