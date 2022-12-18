package com.leetcode.dynamicprogramming;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * @author sudhir on 05-Jul-2020
 * @see <a href="https://leetcode.com/problems/longest-palindromic-substring/">
 * https://leetcode.com/problems/longest-palindromic-substring/</a>
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        // if the input string is empty, return empty string
        if (n == 0) {
            return "";
        }
        // dp[i][j] represents whether the substring from indices i to j is a palindrome or not
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int start = 0;
        int end = 0;
        int maxLen = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((j - i) == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                }
                if (dp[i][j] && maxLen < ((j - i) + 1)) {
                    maxLen = j - i + 1;
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s1 = "";
        String s2 = "cbbd";
        String s3 = "babad";
        System.out.println(lps.longestPalindrome(s1));
        System.out.println(lps.longestPalindrome(s2));
        System.out.println(lps.longestPalindrome(s3));
    }
}
