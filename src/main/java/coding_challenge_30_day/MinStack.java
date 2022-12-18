package coding_challenge_30_day;

import java.util.Stack;

/**
 * @author sudhir on 21-Apr-2020
 */
public class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!mainStack.isEmpty()) {
            int x = mainStack.pop();
            if (!minStack.isEmpty() && minStack.peek() == x) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (mainStack.isEmpty()) {
            return -1;
        }
        return mainStack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
