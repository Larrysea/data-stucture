package ninechapter.dfs;

import com.sun.tools.corba.se.idl.IncludeGen;
import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 全排列问题
 *
 * @author
 * @create 2018-02-26 上午8:32
 **/
public class Permutation {

    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {

        if (nums == null) {
            return new ArrayList<List<Integer>>();
        }

        if (nums.length == 0) {
            new ArrayList<>();
        }

        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();

        Set<Integer> set = new HashSet<Integer>();
        helper(nums, result, combination, set);

        return result;
    }


    private static void helper(int[] nums, List<List<Integer>> result, List<Integer> combination, Set<Integer> numSet) {
        if (combination.size() == nums.length) {
            result.add(new ArrayList<>(combination));
        }


        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                continue;
            }
            combination.add(nums[i]);
            numSet.add(nums[i]);
            helper(nums, result, combination, numSet);
            combination.remove(combination.size() - 1);
            numSet.remove(nums[i]);
        }

    }


    public static void main(String[] args) {
        int[] testCase1 = {1, 1};
        PrintUtil.print(permute(testCase1));

    }

}
