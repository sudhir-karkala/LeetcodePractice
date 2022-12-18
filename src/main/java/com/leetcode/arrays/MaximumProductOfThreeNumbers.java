package com.leetcode.arrays;

/**
 * Given an integer array nums,
 * find three numbers whose product is maximum and return the maximum product.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * <p>
 * Output: 6
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,4]
 * <p>
 * Output: 24
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [-1,-2,-3]
 * <p>
 * Output: -6
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 10^4
 * <p>
 * -1000 <= nums[i] <= 1000
 *
 * @author sudhir on 18-Nov-2020
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        max1 = nums[0];
        min1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        // if all 3 numbers are negative, then the prod is negative.
        // so we take care to see that we choose 2 numbers min1, min2
        // which can possibly go negative and max1 which can possibly go positive.
        // so we take max(max1 * max2 * max3, min1 * min2 * max1)
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public static void main(String[] args) {
        MaximumProductOfThreeNumbers m = new MaximumProductOfThreeNumbers();
        int nums1[] = {1, 2, 3, 4};
        System.out.println(m.maximumProduct(nums1));
    }
}
