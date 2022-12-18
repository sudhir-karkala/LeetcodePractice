package com.leetcode.arrays;

import com.leetcode.utilities.FastReader;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d]
 * if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.
 * Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 * <p>
 * Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * Output: 1
 * </p>
 *
 * @author sudhir on 12-Jan-2020
 */
public class NumberOfEquivalentDominoPairs {
    /**
     * Note that this brute force solution is just for reference as it gives time limit exceeded error in the platform.
     *
     * @param dominoes
     * @return total
     */
    public static int numEquivDominoPairsBruteForce(int[][] dominoes) {
        int total = 0;
        int m = dominoes.length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                //compare dominoes[i] with dominoes[j]
                if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) || (dominoes[i][1] == dominoes[j][0] && dominoes[i][0] == dominoes[j][1])) {
                    total++;
                }
            }
        }
        return total;
    }

    /**
     * This solution is accepted in the platform as the time complexity is O(n)
     *
     * @param dominoes
     * @return total
     */
    public static int numEquivDominoPairsEfficient(int[][] dominoes) {
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] domino = dominoes[i];
            int key = Math.max(domino[0], domino[1]) * 10 + Math.min(domino[0], domino[1]);
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        for (Integer value : map.values()) {
            total = total + (value * (value - 1) / 2);
        }
        return total;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int m = fr.nextInt();
        int n = 2;
        int[][] dominoes = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dominoes[i][j] = fr.nextInt();
            }
        }
        System.out.println(numEquivDominoPairsBruteForce(dominoes));
        System.out.println(numEquivDominoPairsEfficient(dominoes));
        fr.close();
    }
}
