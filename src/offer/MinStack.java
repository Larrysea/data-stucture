package offer;

import java.util.Stack;

/**
 * Created by Larry-sea on 2017/3/24.
 * <p>
 * 包含最小函数的栈
 */
public class MinStack {

    /**
     * 最小栈的辅助栈
     */
    Stack<Integer> minStack = new Stack<Integer>();

    /**
     * 主要是stack
     */
    Stack<Integer> stack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);

        //如果最小栈为空或者是node小于最小栈的栈顶则
        if (minStack.size() == 0 || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (stack != null && minStack != null && stack.size() > 0 && minStack.size() > 0) {
            stack.pop();
            minStack.pop();
        }

    }

    public int top() {
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);

        System.out.println(minStack.min());

        minStack.push(3);
        System.out.println(minStack.min());

        minStack.push(2);
        System.out.println(minStack.min());

        minStack.push(2);
        System.out.println(minStack.min());

        minStack.push(3);
        System.out.println(minStack.min());

        minStack.push(0);
        System.out.println(minStack.min());

    }

}
