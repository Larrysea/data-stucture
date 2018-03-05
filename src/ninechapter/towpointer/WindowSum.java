package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 窗口之和
 *
 * @author
 * @create 2018-03-06 上午12:54
 **/
public class WindowSum {


    public static void main(String[] args) {
        int[] testCase1 = {1, 2, 7, 8, 5};
        PrintUtil.printArray(winSum(testCase1, 3));


    }

    /**
     * @param nums: a list of integers.
     * @param k:    length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public static int[] winSum(int[] nums, int k) {
        // write your code here
        //如果数组长度为0
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int capacity = nums.length - k + 1;
        //结果数组
        int[] result = new int[capacity];

        int sum = 0;

        int leftPointer = 0;
        int rightPointer = k - 1;

        //初始化sum
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        //初始化第一个小数组
        result[0] = sum;

        int count = 1;
        while (rightPointer < nums.length - 1) {
            //窗口开始向右移位
            sum -= nums[leftPointer];
            rightPointer++;
            sum += nums[rightPointer];
            leftPointer++;
            result[count] = sum;
            count++;
        }

        return result;

    }
}
