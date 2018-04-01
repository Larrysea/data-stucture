package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 求子集。
 *
 * @author
 * @create 2018-04-01 下午11:02
 **/
public class SubSets {


    public static void main(String[] args) {
        int[] testParam1 = {1, 2, 3};
        PrintUtil.print(subsets(testParam1));

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();

        if (nums == null) {
            return results;
        }
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        Arrays.sort(nums);

        helper(nums, results, new ArrayList<Integer>(), 0);

        return results;
    }


    private static void helper(int nums[], List<List<Integer>> results, List<Integer> list, int startIndex) {
        results.add(new ArrayList<>(list));
        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, results, list, i + 1);
            list.remove(list.size() - 1);
        }

    }


}
