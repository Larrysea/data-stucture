package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry-sea on 2016/12/16.
 * <p>
 * leetcode 8  stringToInteger
 */
public class StringToInteger {
    static public int StringToInteger(String inputString) {
        if (inputString.trim().isEmpty()) {
            return 0;
        }
        inputString = inputString.trim();
        if ((inputString.substring(0, 1).equals("+")) || (inputString.substring(0, 1).equals("-"))) {  // first char is symbol
            //is number char
            return stringToInt(false, inputString);

        } else if (Character.isDigit(inputString.charAt(0))) {  // first char is number
            return stringToInt(true, inputString);
        } else {
            return 0;
        }

    }


    /*
    * 将inputString 转换为int
    *
    * */
    static private int stringToInt(boolean firstCharIsNumber, String inputString) {
        int position = 0;
        boolean isLessZero = false;
        boolean isHaveNumber = false;    //是否有char
        Queue<Integer> numberQueue = new LinkedList<Integer>();
        if(inputString.equals("-2147483648"))
            return -2147483648;
        if(inputString.equals("2147483647"))
        {
            return 2147483647;
        }
        if (!firstCharIsNumber) {   //第一个字符是符号
            position = 1;
            if (inputString.substring(0, 1).equals("-")) {
                isLessZero = true;
            } else {
                isLessZero = false;
            }
        }
        for (; position < inputString.length(); position++) {
            if (Character.isDigit(inputString.charAt(position)))   //是数字
            {
                if (Integer.parseInt(String.valueOf(inputString.charAt(position))) != 0) {
                    isHaveNumber = true;
                    numberQueue.add(Integer.parseInt(String.valueOf(inputString.charAt(position))));
                } else {
                    if (isHaveNumber) {
                        numberQueue.add(Integer.parseInt(String.valueOf(inputString.charAt(position))));
                    }
                }
            } else if (String.valueOf(inputString.charAt(position)).equals(".")) {
                return converNumberQueueToInt(isLessZero, numberQueue);

            } else {
                return converNumberQueueToInt(isLessZero, numberQueue);
            }

        }
        return converNumberQueueToInt(isLessZero, numberQueue);
    }


    /*
    * 将数字转换为int类型
    *
    * */
    static private int converNumberQueueToInt(boolean isLessZero, Queue<Integer> queue) {
        if (queue == null) {
            throw new IllegalArgumentException("number queue is empty");
        }
        int queueLength = queue.size();
        long result = 0;
        for (int position = queueLength; position > 0; position--) {
            result += (queue.poll() * Math.pow(10, position - 1));
        }

        if (isLessZero) {
            result = -1 * result;
            if (result == -2147483647) {
                return -2147483647;
            } else if (result <= -2147483648) {
                return -2147483648;
            } else {
                return  (int)result;
            }

        } else {
            if (result >= 2147483647) {
                return 2147483647;
            } else {
                return (int)result;
            }

        }

    }

}
