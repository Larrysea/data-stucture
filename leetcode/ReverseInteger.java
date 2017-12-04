package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Larry-sea on 2016/12/14.
 */
public class ReverseInteger {

    static public int reverse(int number) {
        int result = 0;
        boolean isLessZero = false;
        if (number < 0) {
            isLessZero = true;
        }
        if (number < 9) {
            return number;
        }
        number = Math.abs(number);
        String intString = String.valueOf(number);
        String tempString = "";

        for (int position = intString.length() - 1; position >= 0; position--) {
            tempString += intString.charAt(position);
        }
        try {
            if (isLessZero) {
                result = -1 * Integer.parseInt(tempString);
            } else {
                result = Integer.parseInt(tempString);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return Integer.reverse(number);
    }

    static public int reverseBetter(int parm) {
        int result = 0;
        Queue<Integer> integerQueue = new LinkedList<Integer>();
        Stack<Integer> involutionStack = new Stack<Integer>();
        int volution = 0;
        int numberLength = 0;
        boolean isLessZero = false;

        if (parm <= -2147483648 || parm >= 2147483647) {
            return 0;
        }
        if (parm < 0) {
            isLessZero = true;
            parm = Math.abs(parm);
        }
        if (parm < 9) {
            return parm;
        }
        while (parm / 10 != 0) {
            integerQueue.add(parm % 10);
            involutionStack.add(volution);
            volution++;
            parm = parm / 10;
        }
        integerQueue.add(parm);
        involutionStack.add(volution);
        numberLength = involutionStack.size();
        for (int position = 0; position < numberLength; position++) {
            result += integerQueue.poll() * (Math.pow(10, involutionStack.pop()));
        }
        if (isLessZero) {

            result = -1 * result;
            if (result <= -2147483648) {
                return 0;
            } else {
                return result;
            }
        } else {
            if (result >= 2147483647) {
                return 0;
            } else {
                return result;
            }

        }
    }
}
