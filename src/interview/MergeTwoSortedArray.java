package interview;

import data_stucture.PrintUtil;

/**
 * 合并两个排序数组
 *
 * @author
 * @create 2018-05-29 11:56 PM
 **/
public class MergeTwoSortedArray {


    public static void main(String[] args) {

        int[] arrayA = {1, 3, 5, 7, 9, 10};
        int[] arrayB = {2, 4, 6, 8, 10, 11};

        PrintUtil.printArray(mergeSortedArray(arrayA, arrayB));
    }

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public static int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null || B == null) {
            return null;
        }
        // write your code here
        int[] result = new int[A.length + B.length];
        int indexA = 0;
        int indexB = 0;
        int count = 0;
        while (indexA < A.length && indexB < B.length) {
            if (A[indexA] <= B[indexB]) {
                result[count++] = A[indexA];
                indexA++;
            } else {
                result[count++] = B[indexB];
                indexB++;
            }
        }

        while (indexA <= A.length - 1) {
            result[count++] = A[indexA++];
        }

        while (indexB <= B.length - 1) {
            result[count++] = B[indexB++];
        }
        return result;
    }
}
