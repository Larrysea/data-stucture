package ninechapter.common_datastructure;

import java.util.Stack;

/**
 * 两个栈构成队列
 *
 * @author
 * @create 2018-04-10 上午1:15
 **/
public class TwiStackBuildQueue {

    //该题思路因为队列和栈的完全相反，但是反反得正，所以出的顺序就是在出一次栈，顺序就调整过来了。


    //输入栈
    Stack<Integer> inputStack;

    //输出栈
    Stack<Integer> outputStack;

    public TwiStackBuildQueue() {
        // do intialization if necessary
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        inputStack.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (outputStack.isEmpty()) {
            inputToOutputStack(inputStack, outputStack);
        }
        return outputStack.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (outputStack.isEmpty()) {
            inputToOutputStack(inputStack, outputStack);
        }
        return outputStack.peek();
    }

    //输入栈转到输出栈中去
    private void inputToOutputStack(Stack input, Stack output) {
        //
        while (!input.isEmpty()) {
            outputStack.push(inputStack.pop());
        }
    }
}
