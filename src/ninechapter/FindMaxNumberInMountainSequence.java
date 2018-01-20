package ninechapter;

import data_stucture.PrintUtil;

/**
 * 找出一个山峰序列中最大的数。
 *
 * @author
 * @create 2018-01-20 下午11:14
 **/
public class FindMaxNumberInMountainSequence {
    public static void main(String[] args) {
        int test[]={1,2,4,8,6,3};
        int test1[]={10,9,8,7};
//        PrintUtil.print(mountainSequence(test));
        PrintUtil.print(mountainSequence(test1));

    }


    /*
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public static  int mountainSequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return nums[mid];
            }
            //递增曲线上
            else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else  {
                end = mid;
            }
        }

        if (nums[start] > nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }

    }
}
