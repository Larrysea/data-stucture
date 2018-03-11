package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.HashMap;

/**
 * 计算一个数组中所有可能配对的数组
 *
 * @author
 * @create 2018-03-11 下午8:50
 **/
public class TwoSumUniquePairs {


    public static void main(String[] args) {

        int[] testCase1 = {1, 1, 2, 45, 46, 46};
        PrintUtil.print(twoSum6(testCase1, 47));

        int[] testCase2 = {7, 11, 11, 1, 2, 3, 0, 22, 0, 22};
        PrintUtil.print(twoSum6(testCase2, 22));

        int[] testCase3 = {107, 0, 107, 0, 107, 0, 0, 0, 0, 0, 0, 0, 0, 107, 0, 107, 107, 106, 1, 1, 9, 98, 9, 97, 11, 1001, 2001, -91, 201, 203, 201, 999, 345, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 5, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 101, 1, 1, 1, 1, 1, 1, 1, 1};
        PrintUtil.print(twoSum6(testCase3, 107));


    }


    /**
     * @param nums:   an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public static int twoSum6(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int resultCount = 0;
        HashMap<Integer, Boolean> resultMap = new HashMap<Integer, Boolean>();
        //开始进行搜索匹配
        for (int i = 0; i < nums.length; i++) {

            if (resultMap.get(nums[i]) != null && !resultMap.get(nums[i])) {
                resultCount++;
                //将符合条件的key和value都放近map避免重复，因为  1  0  和 0  1 是一堆结果集。
                resultMap.put(nums[i], true);
                resultMap.put(target - nums[i], true);
                continue;
            }


            if (!resultMap.containsKey(target - nums[i])) {
                resultMap.put(target - nums[i], false);
            }

        }

        return resultCount;

    }
}
