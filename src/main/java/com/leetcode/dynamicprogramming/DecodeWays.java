package com.leetcode.dynamicprogramming;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1, 'B' -> 2 ... 'Z' -> 26 <br/>
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * @author sudhir on 12/6/20
 * @see <a href="https://leetcode.com/problems/decode-ways/">https://leetcode.com/problems/decode-ways/</a>
 */
public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        // ways[i] represents number of ways to decode considering (i - 1)th indexed character in the string.
        // Number of ways will include ways to decode considering (i - 1)th character as single character
        // and (i - 2)(i - 1)th character as a pair. so ways[i] = ways[i-1] + ways[i-2]
        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;
        if (s.charAt(0) == '0') {
            ways[1] = 0;
        }
        for (int i = 2; i <= n; i++) {
            // considering 2 character pair=> (i-2):(i-1)
            if (s.charAt(i - 2) != '0' && ((s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2') && s.charAt(i - 1) <= '6'))) {
                ways[i] += ways[i - 2];
            }
            // consider one character (i-1)
            if (s.charAt(i - 1) != '0') {
                ways[i] += ways[i - 1];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s1 = "012";
        String s2 = "12";
        System.out.println(d.numDecodings(s1));
        System.out.println(d.numDecodings(s2));
    }
}
