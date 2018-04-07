package ninechapter.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 求出n皇后所有的结果数
 *
 * @author
 * @create 2018-04-07 下午2:13
 **/
public class NQueenII {


    private static int resultCount = 0;


    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        // write your code here


        List<List<String>> result = new ArrayList<List<String>>();
        if (n == 0) {

            return 0;
        }

        dfs(new ArrayList<Integer>(), n);

        return resultCount;

    }

    private static void dfs(List<Integer> path, int n) {

        //判断是否满足条件如果满足添加到结果中去
        if (path.size() == n) {
            resultCount++;
            return;
        }

        //开始dfs查找

        for (int i = 0; i < n; i++) {
            if (!isValidAnswer(path, i)) {
                continue;
            }

            path.add(i);
            dfs(path, n);
            path.remove(path.size() - 1);
        }

    }


    //判断下一个排列是否有效
    private static boolean isValidAnswer(List<Integer> path, int nextRowIndex) {
        //判断是否是在同一列
        for (int i = 0; i < path.size(); i++) {
            //同一列
            if (nextRowIndex == path.get(i)) {
                return false;
            }


            //判断是否在斜对角的情况

            if (path.size() - i == Math.abs(nextRowIndex - path.get(i))) {
                return false;
            }
        }

        return true;

    }


}
