package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 合并两个独立数组
 *
 * @author
 * @create 2018-04-13 下午11:12
 **/
public class MergeTwoArray {


    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, -1, -1, -1};
        int[] test2 = {4, 5};
        mergeSortedArray(test1, 3, test2, 2);
        PrintUtil.printArray(test1);
    }


    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int startIndex = m;

        int count = 0;
        while (count < n) {
            A[startIndex++] = B[count++];
        }
        Arrays.sort(A);

    }
}
