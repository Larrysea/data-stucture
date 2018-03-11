package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 删除重复的数
 *
 * @author
 * @create 2018-03-08 下午11:10
 **/
public class Duplication {

    public static void main(String[] args) {
        int[] testCase1 = {1, 3, 1, 4, 4, 2};
        PrintUtil.print(deduplication(testCase1));
    }


    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public static int deduplication(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int start = 0;

        int deleteCount = 0;

        //通过
        while (start < nums.length) {
            //查找以后的每个数组是否存在相等的数，如果存在则移位
            int startIndex = start + 1;
            while (startIndex < nums.length - 1) {
                if (nums[start] == nums[startIndex]) {
                    deleteCount++;
                    //将重复的数给挤掉
                    while (startIndex < nums.length - 1) {
                        nums[startIndex] = nums[startIndex + 1];
                        startIndex++;
                    }
                }
                startIndex++;
            }
            start++;

        }

        return nums.length - deleteCount;

    }


}
