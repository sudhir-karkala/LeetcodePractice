package com.leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Given a collection of distinct numbers, return all possible permutations.
 * </p>
 * Example: [1,2,3] will have the following permutations: [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
 *
 * @author sudhir on 07-Mar-2020
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permutation(result, nums, 0);
        return result;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private void permutation(List<List<Integer>> result, int[] nums, int start) {
        if (start >= nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (Integer n : nums) {
                temp.add(n);
            }
            result.add(temp);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permutation(result, nums, start + 1);
            swap(nums, start, i);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(permutations.permute(nums));
    }
}
