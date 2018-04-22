package offer;

import data_stucture.PrintUtil;

/**
 * 连续最大子数组和
 *
 * @author
 * @create 2018-04-22 下午11:48
 **/
public class MaxSubArray {


    public static void main(String[] args) {
        int[] testCase1 = {1, -2, 3, 10, -4, 7, 2, -5};
        PrintUtil.print(FindGreatestSumOfSubArray(testCase1));
    }

    public static int FindGreatestSumOfSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //如果一个前面的连续和都开始起相反的作用，则抛弃这些让最大值变小的结果，重新开始
            if (sum <= 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            max = Math.max(sum, max);
        }

        return max;
    }
}
