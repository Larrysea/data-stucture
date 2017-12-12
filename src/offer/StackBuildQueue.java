package offer;

import java.util.Stack;

/**
 * Created by Larry-sea on 2017/1/21.
 *
 * 通过两个栈构建一个对列
 */
public class StackBuildQueue {
    Stack<Integer> stack1 = new Stack<Integer>();        //输入栈
    Stack<Integer> stack2 = new Stack<Integer>();        //输出栈


    //直接将将数据存放到输入栈中
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() throws Exception{
        //当输出栈为空则将输入栈的数据存储到输出栈中
        if (stack2.size() == 0) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        //如果输出栈不为空则将输出栈的的数据直接输出
        if (!stack2.empty()) {
            return  stack2.pop();
        }else
        {
            throw  new Exception("stack is empty cant pop");
        }

    }
}
