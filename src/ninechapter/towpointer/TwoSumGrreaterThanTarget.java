package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 给出一个数组找出数组中所有大于结果的数组之和。
 *
 * @author
 * @create 2018-03-17 下午8:08
 **/
public class TwoSumGrreaterThanTarget {


    public static void main(String[] args) {
        int[] testCase1 = {2, 7, 11, 15};
        int target1 = 24;
        PrintUtil.print(twoSum2(testCase1, target1));
    }

    /**
     * @param nums:   an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public static int twoSum2(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);

        int count = 0;
        while (left < right) {
            int value = nums[left] + nums[right];

            if (value <= target) {
                left++;
            } else {
                count += right - left;
                right--;
            }

        }

        return count;
    }
}
