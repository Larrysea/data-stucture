package offer;

import data_stucture.PrintUtil;

/**
 * 连续最大子数组和
 *
 * @author
 * @create 2018-04-17 下午11:53
 **/
public class MaxSubSum {


    public static void main(String[] args) {
        int[] testCase = {6, -3, -2, 7, -15, 1, 2, 2};

        int[] testCase2 = {1, -2, 3, 10, -4, 7, 2, -5};

        PrintUtil.print(FindGreatestSumOfSubArray(testCase2));
    }

    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += array[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;

    }
}
