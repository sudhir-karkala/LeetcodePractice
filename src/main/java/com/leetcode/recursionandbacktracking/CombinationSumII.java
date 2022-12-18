package com.leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author sudhir on 07-Mar-2020
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, result, temp, target, 0);
        return result;
    }

    private void combinationSum(int[] candidates, List<List<Integer>> result, List<Integer> temp, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // when we keep adding elements to the combination in a recursive manner,
            // it's correct to add next element with the same value as previous
            // because it can result in a valid combination (This is taken care as (i != start) will be false and element will be added successfully).
            // But once we complete recursion, we remove the last added element from the combination and then try with the next element.
            // (Here (i != start) will be true and duplicate check will be done).
            // Here if the next element has the same value, then the subsequent recursive calls results in the same combination
            // which is a duplicate combination.
            // Hence we filter out those cases.
            if (i != start && (candidates[i - 1] == candidates[i])) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            combinationSum(candidates, result, temp, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII combinationSum = new CombinationSumII();
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(combinationSum.combinationSum2(candidates1, target1));
        System.out.println(combinationSum.combinationSum2(candidates2, target2));
    }
}
