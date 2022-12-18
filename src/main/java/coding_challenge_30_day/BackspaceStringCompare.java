package coding_challenge_30_day;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * @author sudhir on 21-Apr-2020
 */
public class BackspaceStringCompare {
    /*
        1.
        Input: S = "ab##", T = "c#d#"
        Output: true
        Explanation: Both S and T become ""

        2.
        Input: S = "a#c", T = "b"
        Output: false
        Explanation: S becomes "c" while T becomes "b".

        3.
        Input: S = "ab#c", T = "ad#c"
        Output: true
        Explanation: Both S and T become "ac".
     */

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int m = S.length();
        int n = T.length();
        int i = 0;
        while (i < m) {
            if (S.charAt(i) != '#') {
                st1.push(S.charAt(i));
            } else {
                if (!st1.isEmpty()) {
                    st1.pop();
                }
            }
            i++;
        }
        i = 0;
        while (i < n) {
            if (T.charAt(i) != '#') {
                st2.push(T.charAt(i));
            } else {
                if (!st2.isEmpty()) {
                    st2.pop();
                }
            }
            i++;
        }
        while (!st1.isEmpty() && !st2.isEmpty()) {
            if (st1.pop() != st2.pop()) {
                return false;
            }
        }
        if (!st1.isEmpty() || !st2.isEmpty()) {
            return false;
        }
        return true;
    }
}
