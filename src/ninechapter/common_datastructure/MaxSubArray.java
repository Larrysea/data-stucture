package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

/**
 * 和最大的子数组
 *
 * @author
 * @create 2018-04-13 下午11:55
 **/
public class MaxSubArray {


    public static void main(String[] args) {
        int[] testCase1 = {-2, 2, -3, 4, -1, 2, 1, -5, 3};
        PrintUtil.print(maxSubArray(testCase1));
    }

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public static int maxSubArray(int[] nums) {
        // write your code here

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            //如果一个前面的连续和都开始起相反的作用，则抛弃这些让最大值变小的结果，重新开始
            if (sum < 0) {
                sum = 0;
            }

            sum += nums[i];
            sum = Math.max(sum, max);
        }

        return max;
    }
}
