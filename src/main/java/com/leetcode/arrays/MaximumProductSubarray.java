package com.leetcode.arrays;

/**
 * Given an integer array nums, find the contiguous subarray
 * within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * <p>
 * Output: 6
 * <p>
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @author sudhir on 18-Nov-2020
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int maxProd = curMax;
        for (int i = 1; i < nums.length; i++) {
            int temp = curMax;
            curMax = Math.max(nums[i], Math.max(curMax * nums[i],
                    curMin * nums[i]));
            curMin = Math.min(nums[i], Math.min(curMin * nums[i],
                    temp * nums[i]));
            maxProd = Math.max(maxProd, curMax);
        }
        return maxProd;
    }

    public static void main(String[] args) {
        MaximumProductSubarray m = new MaximumProductSubarray();
        int[] nums1 = {-4, -3, -2};
        System.out.println(m.maxProduct(nums1));
        int[] nums2 = {-2, 0, -1};
        System.out.println(m.maxProduct(nums2));
        int[] nums3 = {2, 3, -2, 4};
        System.out.println(m.maxProduct(nums3));
    }
}
