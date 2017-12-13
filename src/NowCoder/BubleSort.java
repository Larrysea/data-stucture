package NowCoder;

import common_util.CommonUtil;

/**
 * Created by Larry-sea on 2017/12/13.
 * 冒泡排序
 */
public class BubleSort {

    public static void main(String[] args) {


        int[] array = {1, 3, 2, 5, 6, 9};
        CommonUtil.printArray(bubbleSort(array, 6));
    }

    /*
    * 冒泡排序算法思想，每一次将该数组中最大的数字排在最后面
    * 通过n^2 次筛选最终排出该数组
    *
    * */
    public static int[] bubbleSort(int[] A, int n) {
        // write code here
        for (int index = n - 1; index > 0; index--) {
            for (int j = 0; j < index; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = temp;
                }
            }
        }
        return A;
    }


}
