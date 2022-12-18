package com.leetcode.arrays;

/**
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the
 * product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [10, 5, 2, 6], k = 100
 * <p>
 * Output: 8
 * <p>
 * Explanation: The 8 subarrays that have product less than 100 are:
 * [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * <p>
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * <p>
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 *
 * @author sudhir on 18-Nov-2020
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // use sliding window with two pointers to count number of subarrays
        // satisfying the condition.
        int product = 1;
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < nums.length) {
            product = product * nums[end];
            while (start < end && product >= k) {
                product /= nums[start];
                start++;
            }
            if (product < k) {
                count += end - start + 1;
            }
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK s = new SubarrayProductLessThanK();
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println(s.numSubarrayProductLessThanK(nums1, k1));
    }
}
