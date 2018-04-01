package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合数
 *
 * @author
 * @create 2018-04-01 下午7:22
 **/
public class Combinations {


    public static void main(String[] args) {
        PrintUtil.print(combine(4, 2));

    }

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public static List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (n == 0) {
            return results;
        }
        if (k == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        helper(results, new ArrayList<Integer>(), k, n, 1);

        return results;
    }


    //
    private static void helper(List<List<Integer>> results, List<Integer> list, int k, int n, int startIndex) {

        if (list.size() == k) {
            results.add(new ArrayList<>(list));
        }

        for (int i = startIndex; i <= n; i++) {
            list.add(i);
            helper(results, list, k, n, i + 1);
            list.remove(list.size() - 1);
        }
    }


}
