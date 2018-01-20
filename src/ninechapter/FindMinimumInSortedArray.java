package ninechapter;

import data_stucture.PrintUtil;

/**
 * 在旋转数组中寻找最小的数
 *
 * @author
 * @create 2018-01-20 下午10:48
 **/
public class FindMinimumInSortedArray {

    public static void main(String[] args) {
        int test1[] = {6, 7, 8, 1, 2, 4, 5};
        PrintUtil.print(findMin(test1));
    }

    /*
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public static int findMin(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        // write your code here
        int start = 0;
        int end = nums.length-1;


        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[end];
        } else {
            return nums[start];
        }


    }


}
