package com.leetcode.dynamicprogramming;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none)
 * of the characters without disturbing the relative positions of the remaining characters.
 * (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * <p>
 * It's guaranteed the answer fits on a 32-bit signed integer.
 *
 * @author sudhir on 19-Jul-2020
 * @see <a href = "https://leetcode.com/problems/distinct-subsequences/">
 * https://leetcode.com/problems/distinct-subsequences/</a>
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        // dp[i][j] represents the number of unique ways in sequence s[0..(i-1)], to form a subsequence that is identical
        // to the sequence t[0..(j-1)]
        int[][] dp = new int[m + 1][n + 1];
        // dp[0][0] means number of ways in empty sequence to form empty sequence t which is 1(do nothing).
        dp[0][0] = 1;
        // for every row i, dp[i][0] is number of ways in sequence s[0..(i-1)] to form empty sequence t which is 1.
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // There are two cases when A[i-1] matches with B[i-1].
                // 1. dp[i - 1][j - 1] => We need to include number of ways excluding (i-1)th character in s
                // and (j-1)th character in t since we match those two characters.
                // 2. dp[i - 1][j] => We need to include number of ways excluding (i-1)th character in s
                // since we don't match those two characters, which means that it still has original number of distinct subsequences.

                // example: consider s(rabbb) and t(rabb).
                // s(....b) matches with t(...b).
                // total ways will include number of ways wrt s(rabbb) and t(rab) which are "ra_bb" and "rab_b" totalling 2.
                // and number of ways wrt s(rabb) and t(rabb) which are "rabb_" totalling 1.
                // so total number of ways = 3.
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    // dp[i - 1][j] => We need to include number of ways excluding (i-1)th character in s when
                    // there is no match
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        DistinctSubsequences d = new DistinctSubsequences();
        String S = "babgbag";
        String T = "bag";
        System.out.println(d.numDistinct(S, T));
    }
}
