package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 找出数组中两个数之和为target的下标
 *
 * @author
 * @create 2018-03-11 下午2:51
 **/
public class twoSum {


    public static void main(String[] args) {
        int[] testCase1 = {2, 7, 11, 15};
        int[] testCase2 = {1, 0, -1};
        int[] testCase3 = {1, 0, -1};
//        PrintUtil.printArray(twoSum(testCase1, 9));
//        PrintUtil.printArray(twoSum(testCase2, -1));
        PrintUtil.printArray(twoSum(testCase3, 0));

    }

    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        int result[] = new int[2];

        if (numbers.length == 0) {
            return result;
        }


        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {
                //如果两个数相加等于目标
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }

        }

        return result;

    }
}
