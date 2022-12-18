package com.leetcode.dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

/**
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * <p>
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence,
 * find the length of the longest fibonacci-like subsequence of A.  If one does not exist, return 0.
 * <p>
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A,
 * without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 *
 * @author sudhir on 13-Jul-2020
 * @see <a href="https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/">
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/</a>
 */
public class LengthOfLongestFibonacciSubsequence {
    // Brute force solution that takes O((n^2)log m) time, where m is the maximum value in A.
    public int lenLongestFibSubseq(int[] A) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i]);
        }
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int f1 = A[i];
                int f2 = A[j];
                int len = 2;
                while (set.contains(f1 + f2)) {
                    int f3 = f1 + f2;
                    f1 = f2;
                    f2 = f3;
                    len++;
                    maxLen = Math.max(len, maxLen);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestFibonacciSubsequence l = new LengthOfLongestFibonacciSubsequence();
        int[] a1 = {2, 8, 11, 14, 19, 26, 34, 37, 43, 52};
        System.out.println(l.lenLongestFibSubseq(a1));
    }
}
