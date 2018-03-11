package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 将一个数组中的0全部移动到数组最后面的位置。
 *
 * @author
 * @create 2018-03-08 上午12:22
 **/
public class MoveZero {

    public static void main(String[] args) {
        int[] testCase1 = {0, 1, 0, 3, 12};
        moveZeroes(testCase1);
        PrintUtil.printArray(testCase1);

    }

    /*
     * @param nums: an integer array
     * @return:
     */
    public static void moveZeroes(int[] nums) {

        //开始
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] != 0) {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;

            }
            right++;

        }

    }

}
