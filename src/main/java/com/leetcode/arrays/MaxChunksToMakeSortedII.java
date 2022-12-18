package com.leetcode.arrays;

/**
 * Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions),
 * and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 *
 * @author sudhir on 01-Aug-2020
 * @see <a href="https://leetcode.com/problems/max-chunks-to-make-sorted-ii/">
 * https://leetcode.com/problems/max-chunks-to-make-sorted-ii/</a>
 */
public class MaxChunksToMakeSortedII {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], arr[i]);
        }
        int i = 0;
        int chunks = 0;
        int curmax = Integer.MIN_VALUE;
        while (i < n) {
            curmax = Math.max(curmax, arr[i]);
            i++;
            while (i < n && curmax > suffix[i]) {
                curmax = Math.max(curmax, arr[i]);
                i++;
            }
            chunks++;
        }
        return chunks;
    }

    public static void main(String[] args) {
        MaxChunksToMakeSortedII mII = new MaxChunksToMakeSortedII();
        int[] a1 = {2, 1, 3, 4, 4};
        int[] a2 = {5, 4, 3, 2, 1};
        int[] a3 = {3, 4, 1, 2, 5, 7, 6};
        int[] a4 = {3, 2, 2};
        int[] a5 = {2, 0, 1, 2};
        int[] a6 = {6, 4, 5, 4, 8, 10, 8, 8, 11, 11, 12, 12, 12, 15, 17};
        int[] a7 = {5, 1, 1, 8, 1, 6, 5, 9, 7, 8};
        System.out.println(mII.maxChunksToSorted(a1));
        System.out.println(mII.maxChunksToSorted(a2));
        System.out.println(mII.maxChunksToSorted(a3));
        System.out.println(mII.maxChunksToSorted(a4));
        System.out.println(mII.maxChunksToSorted(a5));
        System.out.println(mII.maxChunksToSorted(a6));
        System.out.println(mII.maxChunksToSorted(a7));
    }
}
