package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中找结果集合，但是前提每个数只能使用一次。
 *
 * @author
 * @create 2018-02-25 下午3:40
 **/
public class CombinationSumII {


    /*
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public static List<List<Integer>> combinationSum(int[] num, int target) {
        //如果为空则返回空
        if (num.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(num, 0, target, combination, result);
        return result;
    }

    //该算法思想,
    //判断当前数是否小于 满足的结果，如果小于，递归求解目标数减去当前数的集合，最终得到结果
    //三要素
    //递归定义   ----  递归的拆解   ---- 递归的出口
    private static void helper(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> result) {
        //出口
        if (target == 0) {
            if (!result.contains(new ArrayList<>(combination))) {
                result.add(new ArrayList(combination));
            }
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            //判断当前的数是否大于结果如果是跳出循环
            if (candidates[i] > target) {
                break;
            }

            combination.add(candidates[i]);
            //计算剩余的结果集
            helper(candidates, i + 1, target - candidates[i], combination, result);
            //回溯
            combination.remove(combination.size() - 1);
        }

    }


    public static void main(String[] args) {
        int[] testCase1 = {2, 3, 6, 7};
        int[] testCase2 = {10, 1, 6, 7, 2, 1, 5};
//        PrintUtil.print(combinationSum(testCase1, 7));
        PrintUtil.print(combinationSum(testCase2, 8));

    }
}
