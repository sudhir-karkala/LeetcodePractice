package com.leetcode.recursionandbacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 *
 * @author sudhir on 05-Jul-2020
 * @see <a href="https://leetcode.com/problems/palindrome-partitioning/">
 * https://leetcode.com/problems/palindrome-partitioning/</a>
 */
public class PalindromePartitioning {
    // Backtracking approach
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int n = s.length();
        partition(s, n, result, temp, 0);
        return result;
    }

    private void partition(String s, int len, List<List<String>> result, List<String> temp, int start) {
        if (start == len) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < len; i++) {
            String str = s.substring(start, i + 1);
            if (isPalindrome(str)) {
                temp.add(str);
                partition(s, len, result, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning pp = new PalindromePartitioning();
        String s1 = "aab";
        System.out.println(pp.partition(s1));
    }
}
