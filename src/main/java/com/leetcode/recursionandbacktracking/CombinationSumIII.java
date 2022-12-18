package com.leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * Given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * <li>
 * Note: All numbers will be positive integers.
 * </li>
 * <li>
 * The solution set must not contain duplicate combinations.
 * </li>
 *
 * @author sudhir on 07-Mar-2020
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.sort(candidates);
        combinationSum(candidates, result, temp, k, n, 0, 0);
        return result;
    }

    private void combinationSum(int[] candidates, List<List<Integer>> result, List<Integer> temp, int k, int target, int start, int s) {
        if (target == 0 && s == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            s++;
            combinationSum(candidates, result, temp, k, target - candidates[i], i + 1, s);
            temp.remove(temp.size() - 1);
            s--;
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSum = new CombinationSumIII();
        int k1 = 3;
        int n1 = 7;
        int k2 = 3;
        int n2 = 9;
        System.out.println(combinationSum.combinationSum3(k1, n1));
        System.out.println(combinationSum.combinationSum3(k2, n2));
    }
}
