package com.leetcode.arrays;

/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1],
 * we split the array into some number of "chunks" (partitions), and individually sort each chunk.
 * After concatenating them, the result equals the sorted array.
 *
 * @author sudhir on 01-Aug-2020
 * @see <a href="https://leetcode.com/problems/max-chunks-to-make-sorted/">
 * https://leetcode.com/problems/max-chunks-to-make-sorted/</a>
 */
public class MaxChunksToMakeSorted {
    /**
     * This is one method to solve this problem. Check another method to solve this problem
     *
     * @param arr input array
     * @return chunks
     */
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        int curmax = 0;
        int i = 0;
        int n = arr.length;
        while (i < n) {
            curmax = Math.max(curmax, arr[i]);
            i++;
            // when curmax becomes less than i, it means the current chunk is done, we break out of loop and increment chunks
            while (curmax >= i) {
                curmax = Math.max(curmax, arr[i]);
                i++;
            }
            chunks++;
        }
        return chunks;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted m = new MaxChunksToMakeSorted();
        int[] a1 = {1, 0, 2, 5, 3, 4};
        System.out.println(m.maxChunksToSorted(a1));
    }
}
