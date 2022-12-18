package com.leetcode.strings;

/**
 * An encoded string S is given.  To find and write the decoded string to a tape,
 * the encoded string is read one character at a time and the following steps are taken:<br/>
 * If the character read is a letter, that letter is written onto the tape.<br/>
 * If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.<br/>
 * Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.<br/>
 * Note:<br/>
 * 2 <= S.length <= 100 <br/>
 * S will only contain lowercase letters and digits 2 through 9. <br/>
 * S starts with a letter. <br/>
 * 1 <= K <= 10^9 <br/>
 * The decoded string is guaranteed to have less than 2^63 letters.
 *
 * @author sudhir on 03-May-2020
 */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String S, int K) {
        int n = S.length();
        long size = 0;// long type because the size can go upto 2^63 letters.
        // find the size of the encrypted string
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(S.charAt(i))) {
                size = size * (S.charAt(i) - '0');
            } else {
                size++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            K = (int) (K % size);
            if (K == 0 && Character.isLetter(S.charAt(i))) {
                return "" + S.charAt(i);
            }
            if (Character.isDigit(S.charAt(i))) {
                size /= (S.charAt(i) - '0');
            } else {
                size--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        DecodedStringAtIndex d = new DecodedStringAtIndex();
        String s1 = "a2345678999999999999999";
        int k1 = 1;
        String s2 = "leet2code3";
        int k2 = 10;
        String s3 = "ha22";
        int k3 = 5;
        System.out.println(d.decodeAtIndex(s1, k1));
        System.out.println(d.decodeAtIndex(s2, k2));
        System.out.println(d.decodeAtIndex(s3, k3));
    }
}
