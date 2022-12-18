package com.leetcode.dynamicprogramming;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.<br/>
 * '.' Matches any single character.<br/>
 * '*' Matches zero or more of the preceding element.<br/>
 * The matching should cover the entire input string (not partial).<br/>
 * Note:<br/>
 * s could be empty and contains only lowercase letters a-z.<br/>
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Pattern cannot
 *
 * @author sudhir on 02-Jul-2020
 * @see <a href="https://leetcode.com/problems/regular-expression-matching/">
 * https://leetcode.com/problems/regular-expression-matching/</a>
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        // dp[i][j] represents the state where pattern is from 0th to (j-1)th index and text is from 0th to (i-1)th index
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                // if the pattern doesn't begin with '*', then it is a valid case.
                if ((j - 2) >= 0) {
                    dp[0][j] = dp[0][j - 2];
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    // if the pattern doesn't begin with '*', then it is a valid case.
                    if ((j - 2) >= 0) {
                        // consider 0th occurrence of (j-1)th character of s
                        dp[i][j] = dp[i][j - 2];
                        // consider 1 or more occurrence of (j-1)th character of s
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegularExpressionMatching r = new RegularExpressionMatching();
        String s1 = "aa";
        String p1 = ".*";
        System.out.println(r.isMatch(s1, p1));
        String s2 = "aab";
        String p2 = "c*a*b";
        System.out.println(r.isMatch(s2, p2));
    }
}
