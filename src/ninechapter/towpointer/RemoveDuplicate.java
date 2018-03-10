package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 移除重复的数    好好查看题意，这道题有两个重要要求，一个返回有多少个独立的数，第二个要将这些不同的数放在数组头部
 *
 * @author
 * @create 2018-03-10 下午9:09
 **/
public class RemoveDuplicate {


    public static void main(String[] args) {
        int[] array = {1, 3, 1, 4, 4, 2};

        int[] testCase2 = {2, 2};

        int[] testCase3 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        PrintUtil.println(deduplication(array) + "");
        PrintUtil.print(deduplication(testCase2));

        PrintUtil.println(deduplication(testCase3) + "");

    }


    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public static int deduplication(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 0;
        //排序，将重复的数放在一起
        Arrays.sort(nums);


        for (int i = 1; i < nums.length; i++) {
            //比较上一个数是否和下一个数相同，如果不相同则数量加以，并且将此数放在数组头部
            if (nums[i - 1] != nums[i]) {
                count++;
                nums[count] = nums[i];
            }
        }

        return count + 1;
    }


}
