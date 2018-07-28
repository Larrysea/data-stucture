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
        moveZeroes(testCase1);
        moveZeroes(testCase2);
        moveZeroes(testCase3);
        moveZeroes(testCase4);
        moveZeroes(testCase5);
        moveZeroes(testCase6);



        moveZeroesII(testCase1);
        moveZeroesII(testCase2);
        moveZeroesII(testCase3);
        moveZeroesII(testCase4);
        moveZeroesII(testCase5);
        moveZeroesII(testCase6);

    }


    public static void moveZeroesII(int[] nums) {

        int noneZeroLength = 0;

        int noneZeroArray[] = new int[nums.length];

        //统计出非0项的元素
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                noneZeroArray[noneZeroLength++] = nums[i];
            }
        }

        //如果i 不等于0
        for (int i = 0; i < noneZeroLength; i++) {
            nums[i] = noneZeroArray[i];
        }

        for (int i = noneZeroLength; i < nums.length; i++) {
            nums[i] = 0;
        }
        PrintUtil.printArray(nums);

    }

    // 测试用例1： [0,1,0,3,12]
    // 测试用例2： [0,0,2,2,0,0]
    // 测试用例3:  [0,0,2,2]
    // 测试用例4： [2,2,0,0]

    public static void moveZeroes(int[] nums) {
//        int countZero = 0;
//
//        //统计出0的个数
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                countZero++;
//            }
//        }
//
//        int i = 0;
//
//        //移动一遍，将每个数移动直到前面是非0项
//        for (int k = 0; k < nums.length; ) {
//            if (nums[k] == 0) {
//                //如果是0 则覆盖该项
//                for (int j = k; j + 1 < nums.length; j++) {
//                    nums[j] = nums[j + 1];
//                }
//            } else {
//                k++;
//            }
//        }
//
//        //将移动的数组尾部进行符0 操作
//        for (int noneZeroIndex = nums.length - countZero; noneZeroIndex < nums.length; noneZeroIndex++) {
//            nums[noneZeroIndex] = 0;
//        }

//        PrintUtil.printArray(nums);
    }
}
