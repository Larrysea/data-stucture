package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的数枚举，要求不重复。数组中可能存在重复的数，例如 1，2，2
 * <p>
 * 最后可能的枚举结果是：1 2 2 ， 2 2 1 ， 2 1 2
 *
 * @author
 * @create 2018-02-26 下午1:06
 **/
public class PermuationII {


    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {

        // write your code here
        //如果数组为空，给出的排列也是一整个空排列，返回时[]
        if (nums == null) {
            return new ArrayList<>();
        }

        //但是如果数组是长度为空，则空也是一个子结果，也有子排列，所有返回结果是[ [空结果] ]
        if (nums.length == 0) {
            ArrayList<List<Integer>> result  = new ArrayList<List<Integer>>();
            result.add(new ArrayList<>());
            return result;
        }
        Arrays.sort(nums);
        List<Integer> combination = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        boolean[] vistedArray = new boolean[nums.length];
        permutationII(nums, combination, result, vistedArray);

        return result;
    }


    private static void permutationII(int[] num, List<Integer> combination, List<List<Integer>> result, boolean[] vistedArray) {
        //长度相等的时候则添加到结果集中
        if (combination.size() == num.length) {
            result.add(new ArrayList<>(combination));
        }

        int pre = Integer.MIN_VALUE;

        for (int i = 0; i < num.length; i++) {

            //如果数相同则不进行枚举，因为结果一样
            if (vistedArray[i] || pre == num[i]) {
                continue;
            }
            pre = num[i];

            vistedArray[i] = true;
            combination.add(num[i]);
            permutationII(num, combination, result, vistedArray);
            combination.remove(combination.size() - 1);
            vistedArray[i] = false;
        }
    }


    public static void main(String[] args) {
        int testCase1[] = {2, 2, 1};
        PrintUtil.print(permuteUnique(testCase1));
        int testCase2[] = {};
        PrintUtil.print(permuteUnique(testCase2).toString());

    }
}
