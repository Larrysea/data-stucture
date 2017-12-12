package offer;

import sun.rmi.runtime.Log;

/**
 * Created by Larry-sea on 2017/3/15.
 * <p>
 * offer 上面的题目 输入一个数组输出使的奇数位于偶数前面
 *
 * 32sm 629kx
 */
public class ReorderArray {

    public static int[] reOrderArray(int[] array) {


        int oddLength = countOddLength(array);
        int evenLength = array.length - oddLength;

        int oddIndex=0;
        int evenIndex=0;
        int even[] = new int[evenLength];

        int odd[] = new int[oddLength];
        for (int i = 0; i < array.length; i++) {
            //偶数情况
            if (array[i] % 2 == 0) {
                even[evenIndex] = array[i];
                evenIndex++;
            }
            //奇数情况
            else {
                odd[oddIndex] = array[i];
                oddIndex++;
            }

        }

        for (int oddPosition = 0; oddPosition < odd.length; oddPosition++) {
            array[oddPosition] = odd[oddPosition];

        }

        for (int evenPosition = 0; evenPosition < even.length; evenPosition++) {

            array[evenPosition+oddLength] = even[evenPosition];
        }

        return array;
    }


    public static void main(String[] args) {

        int inputArray[] = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(inputArray);
        System.out.println(inputArray);
    }


    public static int countOddLength(int[] array) {
        int oddLength = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                oddLength++;
            }

        }
        return oddLength;
    }
}
