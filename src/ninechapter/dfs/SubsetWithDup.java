package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 求子集，但是子集中存在重复的元素，但是结果子集不能出现重复。
 *
 * @author
 * @create 2018-02-27 上午12:47
 **/
public class SubsetWithDup {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if (nums == null) {
            return new ArrayList<>();
        }

        if (nums.length == 0) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> combination = new ArrayList<Integer>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //标记是否走过此处，如果已经来过则忽略的作用
        boolean visitedArray[] = new boolean[nums.length];
        Arrays.sort(nums);
        permutation(nums, 0, visitedArray, combination, result);

        return result;
    }


    public static void permutation(int[] nums, int startIndex, boolean[] visted, List<Integer> combination, List<List<Integer>> result) {
        result.add(new ArrayList<>(combination));

        int pre = Integer.MIN_VALUE;
        for (int i = startIndex; i < nums.length; i++) {
            if (visted[i] || nums[i] == pre) {
                continue;
            }
            pre = nums[i];
            visted[i] = true;
            combination.add(nums[i]);
            permutation(nums, i + 1, visted, combination, result);
            combination.remove(combination.size() - 1);
            visted[i] = false;
        }
    }


    public static void main(String[] args) {
        int testCase1[] = {1, 2, 2};
        int testCase2[] = {1, 2};
        PrintUtil.print(subsetsWithDup(testCase1));
//        PrintUtil.print(subsetsWithDup(testCase2));

    }


}
