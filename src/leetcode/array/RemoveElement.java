package leetcode.array;

import data_stucture.PrintUtil;

/**
 * 移除重复元素
 * <p>
 * <p>
 * <p>
 * leetcode 27 题
 *
 * @author
 * @create 2018-07-28 11:08 PM
 **/
public class RemoveElement {


    static int testCase1[] = {3, 2, 2, 3};
    static int testCase2[] = {1, 1, 1, 1};
    static int testCase3[] = {0, 1, 2, 2, 3, 0, 4, 2};

    public static void main(String[] args) {

        PrintUtil.print(removeElement(testCase1, 3));

        PrintUtil.print(removeElement(testCase2, 1));

        PrintUtil.print(removeElement(testCase3, 2));

    }


    public static int removeElement(int[] nums, int val) {

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }

        int count = 0;

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
            count++;
        }

        return nums.length - count;

    }
}
