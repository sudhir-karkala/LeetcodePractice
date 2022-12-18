package com.leetcode.dynamicprogramming;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.<br/>
 * '*' Matches any sequence of characters (including the empty sequence).<br/>
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.<br/>
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 *
 * @author sudhir on 02-Jul-2020
 * @see <a href="https://leetcode.com/problems/wildcard-matching/">
 * https://leetcode.com/problems/wildcard-matching/</a>
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        WildcardMatching w = new WildcardMatching();
        String s1 = "xaylmz";
        String p1 = "x?y*z";
        System.out.println(w.isMatch(s1, p1));
        String s2 = "adceb";
        String p2 = "*a*b";
        System.out.println(w.isMatch(s2, p2));
        String s3 = "acdcb";
        String p3 = "a*c?b";
        System.out.println(w.isMatch(s3, p3));
    }
}
