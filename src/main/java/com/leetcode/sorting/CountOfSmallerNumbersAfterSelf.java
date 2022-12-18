package com.leetcode.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements
 * to the right of nums[i].
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * <p>
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * <p>
 * To the right of 2 there is only 1 smaller element (1).
 * <p>
 * To the right of 6 there is 1 smaller element (1).
 * <p>
 * To the right of 1 there is 0 smaller element.
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 *
 * @author sudhir on 24-Aug-2020
 */
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        // add the input nums[] into pairs
        List<Pair> newNums = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            newNums.add(new Pair(nums[i], i));
            // initialize result list to hold value 0
            result.add(0);
        }

        // perform merge sort on newNums
        mergeSort(newNums, result, 0, nums.length - 1);
        return result;
    }

    private void mergeSort(List<Pair> newNums, List<Integer> result, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(newNums, result, start, mid);
            mergeSort(newNums, result, mid + 1, end);
            merge(newNums, result, start, mid, end);
        }
    }

    private void merge(List<Pair> newNums, List<Integer> result, int start, int mid, int end) {
        List<Pair> left = new ArrayList<>();
        List<Pair> right = new ArrayList<>();
        for (int i = start; i <= mid; i++) {
            left.add(newNums.get(i));
        }
        for (int i = mid + 1; i <= end; i++) {
            right.add(newNums.get(i));
        }
        int i = 0;
        int j = 0;
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int k = 0;
        for (k = start; k <= end; k++) {
            if (i < n1 && j < n2) {
                // if this condition is met, then it means, there were j number of elements
                // that were smaller than ith element, so we add this count to ith element.
                if (left.get(i).value <= right.get(j).value) {
                    result.set(left.get(i).index, result.get(left.get(i).index) + j);
                    newNums.set(k, left.get(i));
                    i++;
                } else {
                    newNums.set(k, right.get(j));
                    j++;
                }
            } else {
                break;
            }
        }
        while (i < n1) {
            // if there are pending elements in left array, then it means all of those are greater than
            // j elements on the right that are already consumed. so we add this count to the
            // ith element.
            newNums.set(k, left.get(i));
            result.set(left.get(i).index, result.get(left.get(i).index) + j);
            i++;
            k++;
        }
        while (j < n2) {
            newNums.set(k, right.get(j));
            j++;
            k++;
        }
    }

    /**
     * We need this class object to store the corresponding index of the element
     * so that we can update the count at that particular index in the result list
     */
    static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        CountOfSmallerNumbersAfterSelf c = new CountOfSmallerNumbersAfterSelf();
        int[] nums1 = {5, 2, 6, 1};
        System.out.println(c.countSmaller(nums1));
    }
}
