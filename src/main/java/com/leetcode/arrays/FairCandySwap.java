package com.leetcode.arrays;

import com.leetcode.utilities.FastReader;

/**
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 * <ul>
 * <li>
 * Example 1:
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 * </li>
 * <li>
 * Example 2:
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 * </li>
 * <li>
 * Example 3:
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 * </li>
 * <li>
 * Example 4:
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 * </li>
 * </ul>
 *
 * @author sudhir on 11-Jan-2020
 */
public class FairCandySwap {
    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] result = new int[2];
        int sumA = 0;
        int sumB = 0;
        for (Integer num : A) {
            sumA += num;
        }
        for (Integer num : B) {
            sumB += num;
        }
        for (Integer a : A) {
            for (Integer b : B) {
                if (sumA - a + b == sumB - b + a) {
                    result[0] = a;
                    result[1] = b;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int m = fr.nextInt();
        int n = fr.nextInt();
        int[] a = new int[m];
        int[] b = new int[n];
        for (int i = 0; i < m; i++) {
            a[i] = fr.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = fr.nextInt();
        }
        int[] ans = fairCandySwap(a, b);
        System.out.print(ans[0] + " " + ans[1]);
        fr.close();
    }
}
