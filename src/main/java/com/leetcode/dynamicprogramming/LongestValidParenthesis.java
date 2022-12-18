package com.leetcode.dynamicprogramming;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * @author sudhir on 27-Apr-2020
 * @see <a href="https://leetcode.com/problems/longest-valid-parentheses/">
 * https://leetcode.com/problems/longest-valid-parentheses/</a>
 */
public class LongestValidParenthesis {
    public int longestValidParentheses(String s) {
        // Here len[i] represents the length of the longest valid substring ending at ith index
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] len = new int[n];
        len[0] = 0;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // We do so because the ending "()" portion is a valid substring anyhow
                    // and leads to an increment of 2 in the length of the just previous valid substring's length.
                    len[i] = (i - 2 >= 0 ? len[i - 2] : 0) + 2;
                } else if (s.charAt(i - 1) == ')') {
                    if ((i - len[i - 1]) > 0 && s.charAt(i - len[i - 1] - 1) == '(') {
                        // The reason behind this is that if the 2nd last ')' was a part of a valid substring (say sub_s),
                        // for the last ')' to be a part of a larger substring, there must be a corresponding starting '('
                        // which lies before the valid substring of which the 2nd last ')' is a part (i.e. before sub_s).
                        // Thus, if the character before sub_s happens to be '(', we update the dp[i] as an addition of 2
                        // in the length of sub_s which is dp[i - 1]. To this, we also add the length of the valid substring
                        // just before the term "(,sub_s,)" , i.e. dp[i - dp[i - 1] - 2].
                        len[i] = len[i - 1] + 2 + ((i - len[i - 1] - 2) >= 0 ? len[i - len[i - 1] - 2] : 0);
                    }
                }
            }
            ans = Math.max(ans, len[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestValidParenthesis l = new LongestValidParenthesis();
        String s1 = "((())";
        System.out.println(l.longestValidParentheses(s1));
    }
}
