package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 找出数组中所有组成对但是小于target的总和。
 *
 * @author
 * @create 2018-03-15 下午11:56
 **/
public class LessTargetCount {

    //
    public static void main(String[] args) {
        int[] testCase1 = {2, 7, 11, 15};
        int[] testCase2 = {1, 0, -1};
        int target = 24;
        PrintUtil.print(twoSum5(testCase2, 0));
        PrintUtil.print(twoSum5II(testCase1, 24));
    }


    /**
     * @param nums:   an array of integer
     * @param target: an integer
     * @return: an integer
     */
    public static int twoSum5(int[] nums, int target) {

        int pairCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] + nums[j] <= target) {
                    pairCount++;
                }

            }

        }
        return pairCount;
    }


    //计算两数之和
    public static int twoSum5II(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);
        int count = 0;

        while (left < right) {

            int value = nums[left] + nums[right];

            if (value > target) {
                right--;
            } else {
                count += right - left;
                left++;
            }
        }

        return count;
    }

}
