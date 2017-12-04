package codeprviewandata;

import java.util.Stack;

/**
 * Created by Larry-sea on 2017/10/14.
 * <p>
 * 栈和对列第一题
 */
public class MinStack {


    //最小的栈
    public static void main() {


    }


    class Minstack {
        Stack<Integer> numberStack = new Stack<>();

        Stack<Integer> minStack = new Stack<>();

        public void push(int number) {
            numberStack.push(number);

        }


        public int pop() {
            return numberStack.pop();
        }


    }

    ;


}
