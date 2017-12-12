package leetcode;

import java.util.HashMap;

/**
 * Created by Larry-sea on 2016/11/10.
 *
 * 给出一个数组当然后给出一个值
 *例如 int {1，3,5,6}
 *
 * 目标值为7
 *
 * 然后返回结果集为  0,3
 *
 */
public class addTwoSum {

    static public int[] twoSum(int[] nums, int target) {
        for (int position = 0; position < nums.length; position++) {
            for (int nextPosition = position + 1; nextPosition < nums.length; nextPosition++) {
                if (target == nums[position] + nums[nextPosition]) {
                    return new int[]{position, nextPosition};
                }
            }
        }
        return new int[]{0, 0};
    }

    /*
    * 利用hashmap达到更好使用效率
    * 此方法效率为n
    *
    * */
    static public int[] twoSumBetter(int[] nums, int target) {
        HashMap<Integer, Integer> hashArray = new HashMap<>();
        int position;
        for (position = 0; position < nums.length; position++) {
            hashArray.put(nums[position], position);
        }
        for (position=0; position < nums.length; position++) {
            if (hashArray.containsKey(target - nums[position])&&hashArray.get(target-nums[position])!=position) {
                return new int[]{position, hashArray.get(target - nums[position])};
            }
        }
        return new int[]{0, 0};
    }


}
