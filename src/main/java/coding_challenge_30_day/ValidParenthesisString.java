package coding_challenge_30_day;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:<br/>
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.<br/>
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.<br/>
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.<br/>
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.<br/>
 * An empty string is also valid.
 *
 * @author sudhir on 23-Apr-2020
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                st.push(s.charAt(i));
            } else {
                boolean foundParen = false;
                int stars = 0;
                while (!st.isEmpty()) {
                    char top = st.pop();
                    if (top == '(') {
                        foundParen = true;
                        break;
                    }
                    stars++;
                }
                // if '(' is not found and star is not present, then return false
                if (!foundParen && stars < 1) {
                    return false;
                } else if (!foundParen) {// means we found one or more stars. use one star to match '(' and decrement total star count by 1
                    stars--;
                }
                // we push remaining stars onto the stack
                while (stars > 0) {
                    st.push('*');
                    stars--;
                }
            }
            i++;
        }
        return validateStack(st);
    }

    // we will be having a stack of '(' and '*' characters or empty stack if all matchings are completed with ')' characters
    private boolean validateStack(Stack<Character> st) {
        int stars = 0;
        while (!st.isEmpty()) {
            char top = st.pop();
            if (top == '(') {
                if (stars > 0) { // means one or more stars are present before the occurrence of '(' which can be used for matching
                    stars--;
                } else { // stars might be present after '(' but that would be an invalid case. so we return false
                    return false;
                }
            } else {
                stars++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidParenthesisString v = new ValidParenthesisString();
        String s = "(*)";
        System.out.println(v.checkValidString(s));
    }
}
