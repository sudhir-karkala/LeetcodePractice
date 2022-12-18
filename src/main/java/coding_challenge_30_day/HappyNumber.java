package coding_challenge_30_day;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is "happy".<br/>
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.<br/>
 * Return True if n is a happy number, and False if not.<br/>
 *
 * @author sudhir on 21-Apr-2020
 */
public class HappyNumber {
    /*
        Input: 19
        Output: true
        Explanation:
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1
     */
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
}
