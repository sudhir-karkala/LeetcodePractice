package com.leetcode.sorting;

/**
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ? j), inclusive.
 * <p>
 * Note:
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 * <p>
 * Example:
 * <p>
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * <p>
 * Output: 3
 * <p>
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^4
 *
 * @author sudhir on 23-Aug-2020
 */
public class CountOfRangeSum {
    private int countOfRangeSum;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        countOfRangeSum = 0;
        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        mergeSort(prefixSum, 0, n, lower, upper);
        return countOfRangeSum;
    }

    private void mergeSort(long[] nums, int start, int end, int lower, int upper) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid, lower, upper);
            mergeSort(nums, mid + 1, end, lower, upper);
            int rangeStart = mid + 1;
            int rangeEnd = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (rangeEnd <= end && nums[rangeEnd] - nums[i] <= upper) {
                    rangeEnd++;
                }
                while (rangeStart <= end && nums[rangeStart] - nums[i] < lower) {
                    rangeStart++;
                }
                countOfRangeSum += (rangeEnd - rangeStart);
            }
            merge(nums, start, mid, end);
        }
    }

    private void merge(long[] nums, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        long[] left = new long[n1];
        long[] right = new long[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = nums[i + start];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = nums[i + mid + 1];
        }
        // begin: logic to merge two sorted arrays
        int i = 0;
        int j = 0;
        int k = 0;
        for (k = start; k <= end; k++) {
            if (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    nums[k] = left[i++];
                } else {
                    nums[k] = right[j++];
                }
            } else {
                break;
            }
        }
        // at the end of for loop, if there are elements in either of the arrays,
        // we will add them to the array.
        // if the sentinel element is used, there is no need for this step
        // as there won't be any left over elements.
        while (i < n1) {
            nums[k++] = left[i++];
        }
        while (j < n2) {
            nums[k++] = right[j++];
        }
        // end: logic to merge two sorted arrays
    }

    public static void main(String[] args) {
        CountOfRangeSum c = new CountOfRangeSum();
        int[] a1 = {1, 2, 3};
        int b1 = 4;
        int c1 = 6;
        System.out.println(c.countRangeSum(a1, b1, c1));
        int[] a2 = {1, 1, 1};
        int b2 = 1;
        int c2 = 3;
        System.out.println(c.countRangeSum(a2, b2, c2));
    }
}
