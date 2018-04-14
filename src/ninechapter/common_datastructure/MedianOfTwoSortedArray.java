package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

/**
 * 两个排序数组的中位数
 *
 * @author
 * @create 2018-04-14 下午6:00
 **/
public class MedianOfTwoSortedArray {


    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {2, 3, 4, 5};

        int[] c = {1, 2, 3};
        int[] d = {4, 5};
        PrintUtil.print(findMedianSortedArrays(a, b));
        PrintUtil.print(findMedianSortedArrays(c, d));

    }

    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        //结题思路，首先将两个数组进行合并，合并以后就可以算出中位数了

        int[] newArray = new int[A.length + B.length];

        int i = 0;
        int j = 0;

        int count = 0;
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                newArray[count++] = B[j++];

            } else {
                newArray[count++] = A[i++];
            }
        }

        while (i < A.length) {
            newArray[count++] = A[i++];
        }

        while (j < B.length) {
            newArray[count++] = B[j++];
        }
        double result = 0;

        int middle = newArray.length / 2;


        if (newArray.length % 2 == 0) {
            result = (newArray[middle] + newArray[middle - 1]) / 2d;
        } else {
            result = newArray[middle];
        }

        return result;

    }
}
