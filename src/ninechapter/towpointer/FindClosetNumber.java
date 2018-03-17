package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 找出最接近目标数之和的组合，并返回该最小差值。
 *
 * @author
 * @create 2018-03-17 下午10:18
 **/
public class FindClosetNumber {

    public static void main(String[] args) {

        int[] testCase1 = {-1, 2, 1, -4};
        int[] testCase2 = {0, 1, 2};
        PrintUtil.print(twoSumClosest(testCase1, 4));
        PrintUtil.print(twoSumClosest(testCase2, 0));

    }


    /**
     * @param nums:   an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public static int twoSumClosest(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        //是否大于target
        boolean biggerThanTarget = false;

        while (left < right) {

            //如果小于target就增加，大于target就减小，不断靠近target，并且记录每次的查值
            if (nums[left] + nums[right] < target) {
                biggerThanTarget = false;
            } else if (nums[left] + nums[right] >= target) {
                biggerThanTarget = true;
            }

            int value = Math.abs(target - (nums[left] + nums[right]));
            if (value < diff) {
                diff = value;
            }
            if (biggerThanTarget) {
                right--;
            } else {
                left++;

            }
        }

        return diff;


    }


}
