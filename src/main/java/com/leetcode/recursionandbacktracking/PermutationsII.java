package com.leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * </p>
 * Example : [1,1,2] have the following unique permutations: [1,1,2], [1,2,1], [2,1,1]
 *
 * @author sudhir on 07-Mar-2020
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
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
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, start, i);
                permutation(result, nums, start + 1);
                swap(nums, start, i);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsII permutations = new PermutationsII();
        int[] nums = {1, 1, 2, 3};
        System.out.println(permutations.permuteUnique(nums));
    }
}
