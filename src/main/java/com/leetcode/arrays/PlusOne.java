package com.leetcode.arrays;

import com.leetcode.utilities.FastReader;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * <li>
 * Example 1:
 * </li>
 * <li>
 * Input: [1,2,3]
 * </li>
 * <li>
 * Output: [1,2,4]
 * </li>
 * <li>
 * Explanation: The array represents the integer 123.
 * </li>
 * </p>
 * <p>
 * <li>
 * Example 2:
 * </li>
 * <li>
 * Input: [4,3,2,1]
 * </li>
 * <li>
 * Output: [4,3,2,2]
 * </li>
 * <li>
 * Explanation: The array represents the integer 4321.
 * </li>
 * </p>
 *
 * @author sudhir on 11-Jan-2020
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int sum = digits[digits.length - 1] + 1;
        int carry = sum / 10;
        result[digits.length] = sum % 10;
        int index = digits.length - 2;
        while (index >= 0) {
            sum = digits[index];
            sum = sum + carry;
            result[index + 1] = sum % 10;
            carry = sum / 10;
            index--;
        }
        if (carry > 0) {
            result[0] = carry;
        }
        if (result[0] == 0) {
            int[] finalresult = new int[digits.length];
            System.arraycopy(result, 1, finalresult, 0, digits.length);
            return finalresult;
        }
        return result;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = fr.nextInt();
        }
        int[] result = plusOne(digits);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        fr.close();
    }
}
