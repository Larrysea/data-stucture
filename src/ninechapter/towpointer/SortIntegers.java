package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 排序整数
 *
 * @author
 * @create 2018-03-22 上午12:16
 **/
public class SortIntegers {


    public static void main(String[] args) {
        int testCase1[] = {3, 2, 1, 4, 5};

        int testCase2[] = {5, 3, 4, 2, 1};
        result = new int[testCase1.length];
        sortIntegers2(testCase2);
        PrintUtil.printArray(testCase2);
    }


    private static int[] result;

    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers2(int[] A) {


        // write your code here
        mergeSort(A, 0, A.length - 1);

    }


    public static void mergeSort(int[] array, int start, int end) {

        if (end <= start) {
            return;
        }
        int middleIndex = start + (end - start) / 2;

        //排序前半部分
        mergeSort(array, start, middleIndex);
        //排序后半部分
        mergeSort(array, middleIndex + 1, end);
        //合并排序结果
        merge(array, start, middleIndex, end);

    }


    private static void merge(int array[], int start, int middle, int end) {

        int left = start;

        int right = middle + 1;
        //将arraycopy到辅助数组中
        for (int index = left; index <= end; index++) {
            result[index] = array[index];
        }

        //将数组合并，需要考虑三个场景，左边数组用尽，右边数组用尽，两个相互比较左边大于右边的情况，和右边大于左边的情况
        for (int index = left; index <= end; index++) {
            //左边数组用尽的情况
            if (left > middle) {
                array[index] = result[right++];
            } else if (right > end) {
                array[index] = result[left++];
            }
            //左边数组小于右边数组
            else if (result[left] < result[right]) {
                array[index] = result[left++];
            } else {
                array[index] = result[right++];

            }
        }
    }


}
