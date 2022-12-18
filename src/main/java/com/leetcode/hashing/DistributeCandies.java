package com.leetcode.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an integer array with even length, where different numbers in this array represent
 * different kinds of candies. <br/>
 * Each number means one candy of the corresponding kind. You need to distribute these candies equally
 * in number to brother and sister. <br/>
 * Return the maximum number of kinds of candies the sister could gain.
 *
 * @author sudhir on 2/6/20
 */
public class DistributeCandies {
    /**
     * Approach 1: Solution with O(n) time and O(n) space.
     *
     * @param candies
     * @return
     */
    public int distributeCandies(int[] candies) {
        // The maximum no. of unique candies which the girl can obtain could be at most n/2.
        // Further, in case the number of unique candies are below n/2, to maximize the number of unique candies
        // that the girl will obtain, we'll assign all the unique candies to the girl.
        // Thus, in such a case, the number of unique candies the girl gets is equal to the
        // total number of unique candies in the given candies array.
        Set<Integer> uniqueCandies = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            uniqueCandies.add(candies[i]);
        }
        int uniqueCandiesCount = uniqueCandies.size();
        return Math.min(uniqueCandiesCount, candies.length / 2);
    }

    /**
     * Approach 2: Solution with O(nlogn) time and O(1) space
     * This uses sorting to find the number of unique candies and returns min(unique, n/2) as the answer.
     *
     * @param candies
     * @return
     */
    public int distributeCandies2(int[] candies) {
        Arrays.sort(candies);
        int uniqueCandiesCount = 1;
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > candies[i - 1]) {
                uniqueCandiesCount++;
            }
        }
        return Math.min(uniqueCandiesCount, candies.length / 2);
    }

    public static void main(String[] args) {
        DistributeCandies d = new DistributeCandies();
        int[] a1 = {1, 1, 2, 2, 3, 3};
        int[] a2 = {1, 1, 2, 3};
        System.out.println(d.distributeCandies(a1));
        System.out.println(d.distributeCandies(a2));
    }
}
