package com.leetcode.dynamicprogramming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 * @author sudhir on 05-Jul-2020
 * @see <a href="https://leetcode.com/problems/longest-palindromic-subsequence/">
 * https://leetcode.com/problems/longest-palindromic-subsequence/</a>
 */
public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp[i][j] represents longest palindromic subsequence in the index range (i..j)
        int[][] dp = new int[n][n];
        // sub sequences of length 1 are always palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // check of sub sequences of length 2 or greater
        // This fills the dp array in the diagonal and upper diagonal region as we don't need lower diagonal region.
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String a1 = "bebeeed";
        System.out.println(lps.longestPalindromeSubseq(a1));
    }
}
