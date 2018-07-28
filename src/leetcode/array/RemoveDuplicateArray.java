package leetcode.array;

import data_stucture.PrintUtil;

/**
 * 从数组中移除重复的数
 * <p>
 * leetcode 26 题
 *
 * @author
 * @create 2018-07-28 10:01 PM
 **/
public class RemoveDuplicateArray {


    public static void main(String[] args) {
        int[] testCase1 = {1, 1, 2};

        int[] testCase2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int[] testCase3 = {1, 1, 1, 1, 1};

        int[] testCase4 = {};

        PrintUtil.print(removeDuplicates(testCase1));

        PrintUtil.print(removeDuplicates(testCase2));

        PrintUtil.print(removeDuplicates(testCase3));

        PrintUtil.print(removeDuplicates(testCase4));


        TestCircleTimes();

    }

    public static int removeDuplicates(int[] nums) {


        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[k] != nums[i]) {
                nums[++k] = nums[i];
            }
        }

        int count = 0;

        for (int i = k + 1; i < nums.length; i++) {
            nums[i] = 0;
            count++;
        }


        return nums.length - count;

    }


    private static  void TestCircleTimes() {

        int count = 0;
        for (int i = 2; i < 10; i++) {
            count++;
        }
        System.out.println(count);
    }
}
