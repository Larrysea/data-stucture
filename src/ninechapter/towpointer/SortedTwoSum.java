package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 排序的两数之和处理，时间复杂度为O(n)的解法
 *
 * @author
 * @create 2018-03-11 下午4:08
 **/
public class SortedTwoSum {

    public static void main(String[] args) {

        int[] testCase1 = {2, 7, 11, 15};
        PrintUtil.printArray(twoSum(testCase1, 9));

    }


    /**
     * @param nums:   an array of Integer
     * @param target: target = nums[index1] + nums[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] result = new int[2];

        int start = 0;

        int end = nums.length - 1;

        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result[0] = start+1;
                result[1] = end+1;
                return result;
            }

            //如果起点小于target 但是总和大于目标值，则移动缩小end
            if (nums[start] + nums[end] > target) {
                end--;
            }

            if (nums[start] + nums[end] < target) {
                start++;
            }


        }

        return new int[2];


    }
}
