package leetcode.array;

/**
 * Created by Larry-sea on 2017/10/10.
 */
public class MaximumSwap {

    int testNumber = 2736;

    static int testNumber1 = 9973;

    static int testNumber2 = 81099;

    static int testNumber3 = 199989999;

    public static void main(String[] args) {
        // System.out.println(findMax(99738, 2));
        maximumSwap(testNumber3);
    }


    public static int maximumSwap(int num) {
        int length = String.valueOf(num).length();
        int[] numberArray = new int[String.valueOf(num).length()];
        int index = length - 1;
        int copyNum = num;
        while (copyNum != 0) {
            int digit = copyNum % 10;
            copyNum = copyNum / 10;
            numberArray[index] = digit;
            --index;
        }

        for (int i = 0; i < length; i++) {
            if (numberArray[i] < 9) {
                int maxIndex = findMax(num, i);
                if (numberArray[maxIndex] > numberArray[i] && maxIndex > i) {
                    int temp = numberArray[i];
                    numberArray[i] = numberArray[maxIndex];
                    numberArray[maxIndex] = temp;
                    break;
                }
            }
        }
        int number = 0;
        for (int i = 0; i < numberArray.length; i++) {
            number += numberArray[i] * (Math.pow(10, numberArray.length - i - 1));
        }
        return number;
    }


    /**
     * @param number
     * @return 最大数的下标
     */
    public static int findMax(int number, int startIndex) {
        String numberStr = String.valueOf(number);
        int length = numberStr.length();
        int[] numberArray = new int[length];
        int j = length - 1;

        while (number != 0) {
            numberArray[j] = number % 10;
            number = number / 10;
            j--;
        }
        int max = -1;
        int index = -1;
        for (int i = startIndex; i < numberArray.length; i++) {
            if (numberArray[i] >= max) {
                index = i;
                max = numberArray[i];
            }

        }
        return index;
    }


}
