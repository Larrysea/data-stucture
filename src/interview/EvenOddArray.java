package interview;

import data_stucture.PrintUtil;

/**
 * 偶数在前奇数在后的数组
 *
 * @author
 * @create 2018-05-29 11:01 PM
 **/
public class EvenOddArray {

    public static void main(String[] args) {

        int[] test = {1, 3, 5, 7, 2, 4, 6, 8, 9};
        makeEvenOddArray(test);
        PrintUtil.printArray(test);
    }


    private static void makeEvenOddArray(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        int temp = 0;
        while (leftIndex < rightIndex) {
            while (array[leftIndex] % 2 == 0) {
                leftIndex++;
            }

            while (array[rightIndex] % 2 != 0) {
                rightIndex--;
            }

            if (leftIndex < rightIndex) {
                temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
            }

        }
        System.out.println("left" + leftIndex + "right" + rightIndex);
    }

}
