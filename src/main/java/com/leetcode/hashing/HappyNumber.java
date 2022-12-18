package com.leetcode.hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle
 * which does not include 1. <br/>
 * Those numbers for which this process ends in 1 are happy numbers.<br/>
 * Return True if n is a happy number, and False if not.
 *
 * @author sudhir on 3/6/20
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        int sumOfSquares = 0;
        Set<Integer> set = new HashSet<>();
        while (n > 1) {
            sumOfSquares = 0;
            while (n > 0) {
                int digit = n % 10;
                sumOfSquares += (digit * digit);
                n /= 10;
            }
            if (set.contains(sumOfSquares)) {
                return false;
            }
            set.add(sumOfSquares);
            n = sumOfSquares;
        }
        return true;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        int num = 19;
        System.out.println(happyNumber.isHappy(num));
    }
}
