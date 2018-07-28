package leetcode.array;

import data_stucture.PrintUtil;

/**
 * @author
 * @create 2018-07-24 11:20 PM
 * <p>
 * 移动数组中的0 到数组的末尾
 **/
public class MoveZero {
    static int[] testCase1 = {0, 1, 0, 3, 12};
    static int[] testCase2 = {0, 0, 2, 2, 0, 0};
    static int[] testCase3 = {0, 0, 2, 2};

    static int[] testCase4 = {2, 2, 0, 0};
    static int[] testCase5 = {0, 0, 0, 0};
    static int[] testCase6 = {1, 2, 3, 4};


    public static void main(String[] args) {
//        moveZeroes(testCase1);
//        moveZeroes(testCase2);
//        moveZeroes(testCase3);
//        moveZeroes(testCase4);
//        moveZeroes(testCase5);
//        moveZeroes(testCase6);


        moveZeroesII(testCase1);
        moveZeroesII(testCase2);
        moveZeroesII(testCase3);
        moveZeroesII(testCase4);
        moveZeroesII(testCase5);
        moveZeroesII(testCase6);

    }


    public static void moveZeroesII(int[] nums) {
        int noneZeroIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[noneZeroIndex++] = nums[i];
            }
        }

        for (int i = noneZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }

        PrintUtil.printArray(nums);

    }

    // 测试用例1： [0,1,0,3,12]
    // 测试用例2： [0,0,2,2,0,0]
    // 测试用例3:  [0,0,2,2]
    // 测试用例4： [2,2,0,0]

    public static void moveZeroes(int[] nums) {
        int front = 0;

        int noneZeroIndex = 0;


        PrintUtil.printArray(nums);
    }
}
