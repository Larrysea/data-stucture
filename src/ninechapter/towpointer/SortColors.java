package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 将颜色进行排序
 *
 * @author
 * @create 2018-03-18 下午10:54
 **/
public class SortColors {


    public static void main(String[] args) {
        int[] testCase1 = {1, 0, 1, 2};
//        sortColors(testCase1);
        int[] testCase2 = {2, 0, 0, 1, 2, 0, 2};
        sortColors(testCase2);
        PrintUtil.printArray(testCase2);

    }


    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public static void sortColors(int[] nums) {
        // write your code here
        int right = nums.length - 1;
        int left = 0;
        int start = 0;

        while (start <= right) {
//            //如果大于1 则移动到数组右边
            if (nums[start] == 2) {
                swap(nums, start, right);
                right--;
            }
            // 如果等于1 则不进行移动
            else if (nums[start] == 1) {
                start++;
            }
            // 如果等于0 ，则移动到数组左边同时指针移动
            else {
                swap(nums, start, left);
                left++;
                start++;
            }

        }


    }


    private static void swap(int[] nums, int num1, int num2) {
        int temp = nums[num1];
        nums[num1] = nums[num2];
        nums[num2] = temp;
    }
}
