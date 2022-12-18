package com.leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * @author sudhir on 07-Mar-2020
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum(candidates, result, temp, target, 0, 0);
        return result;
    }

    private void combinationSum(int[] candidates, List<List<Integer>> result, List<Integer> temp, int target, int sum, int i) {
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (i >= candidates.length || sum > target) {
            return;
        }
        temp.add(candidates[i]);
        sum += candidates[i];
        combinationSum(candidates, result, temp, target, sum, i);
        sum -= temp.get(temp.size() - 1);
        temp.remove(temp.size() - 1);
        combinationSum(candidates, result, temp, target, sum, i + 1);
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(combinationSum.combinationSum(candidates1, target1));
        System.out.println(combinationSum.combinationSum(candidates2, target2));
    }
}
