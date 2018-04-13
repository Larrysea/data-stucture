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
        int[] test1 = {1, 7, 9, -1, -1, -1};
        int[] test2 = {4, 8};
        mergeSortedArrayII(test1, 3, test2, 2);
        PrintUtil.printArray(test1);
    }

    //调用系统排序方法，不够好
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int startIndex = m;

        int count = 0;
        while (count < n) {
            A[startIndex++] = B[count++];
        }
        Arrays.sort(A);
    }

    //通过两个指针的解决方法
    public static void mergeSortedArrayII(int[] A, int m, int[] B, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }

        //如果还有剩下的一方
        while (i >= 0) {
            A[index--] = A[i--];
        }

        while (j >= 0) {
            A[index--] = B[j--];
        }

    }


}
