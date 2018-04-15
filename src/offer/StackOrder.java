package offer;

import data_stucture.PrintUtil;

import java.util.Stack;

/**
 * 判断一个栈序列是否合法
 *
 * @author
 * @create 2018-04-15 下午10:56
 **/
public class StackOrder {


    public static void main(String[] args) {
        int[] inputOrder = {1, 2, 3, 4, 5};
        int[] outputOrder = {4, 3, 5, 1, 2};
        int[] outPutOrder1 = {4, 5, 3, 2, 1};
        PrintUtil.print(IsPopOrder(inputOrder, outPutOrder1) + "");
    }


    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> pushStack = new Stack<Integer>();

        int outIndex = 0;

        //算法思路，首相将

        for (int i = 0; i < popA.length; i++) {


            //如果不等于则将输入栈中的数往辅助栈中加入，直到等于了为止。前提是输入栈没有用尽.
            while (pushStack.size() == 0 || (popA[i] != pushStack.peek() && outIndex < pushA.length)) {
                pushStack.push(pushA[outIndex++]);
            }

            //如果相等直接pop
            if (popA[i] == pushStack.peek()) {
                pushStack.pop();
                continue;
            }

            if (outIndex == pushA.length && pushStack.size() != 0) {
                return false;
            }

        }

        return true;
    }
}
