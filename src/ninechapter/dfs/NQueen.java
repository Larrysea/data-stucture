package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * n皇后问题
 *
 * @author
 * @create 2018-04-07 下午12:16
 **/
public class NQueen {

    public static void main(String[] args) {
        PrintUtil.printStringListList(solveNQueens(4));

    }

    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public static List<List<String>> solveNQueens(int n) {
        // write your code here

        //结题思路，该题的条件是王后不能相互攻击，也就是不能再同一行，或者同一列，或者是斜对角，也就是在递归的时候判断是否会遇到这三种条件，如果遇到了，则不算重新来过。这个问题有一个就是肯定及时每一行放一个王后，然后和树的遍历一样去解决

        List<List<String>> result = new ArrayList<List<String>>();
        if (n == 0) {

            return result;
        }

        dfs(result, new ArrayList<Integer>(), n);

        return result;

    }

    private static void dfs(List<List<String>> result, List<Integer> path, int n) {

        //判断是否满足条件如果满足添加到结果中去
        if (path.size() == n) {
            result.add(constructAnswer(path));
            return;
        }

        //开始dfs查找

        for (int i = 0; i < n; i++) {
            if (!isValidAnswer(path, i)) {
                continue;
            }

            path.add(i);
            dfs(result, path, n);
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


    private static List<String> constructAnswer(List<Integer> path) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < path.size(); j++) {
                if (path.get(i) == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }

        return result;
    }


}
