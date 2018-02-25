package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文字符串划分
 *
 * @author
 * @create 2018-02-25 下午8:55
 **/
public class PalinromePartitioning {

    public static void main(String [] args) {
        String testCase1 = "aab";
        PrintUtil.printStringListList(partition(testCase1));
    }


    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public static List<List<String>> partition(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return new ArrayList<List<String>>();
        }

        List<String> combination = new ArrayList<String>();

        List<List<String>> result = new ArrayList<List<String>>();

        helper(s, 0, result, combination);

        return result;

    }


    private static void helper(String s, int startIndex, List<List<String>> result, List<String> combination) {
        //如果已经遍历到尾部则结束该次深度遍历
        if (startIndex == s.length()) {
            result.add(new ArrayList<String>(combination));
        }

        for (int i = startIndex; i < s.length(); i++) {
            String nextString = s.substring(startIndex, i + 1);

            if (!isPalindromeString(nextString)) {
                continue;
            }
            //该方向上迈出第一步
            combination.add(nextString);
            //在该子方向上继续进行探索
            helper(s, i + 1, result, combination);
            //返回第一个路口
            combination.remove(combination.size() - 1);
        }

    }


    private static boolean isPalindromeString(String judgeStr) {
        if (judgeStr == null || judgeStr.length() == 0) {
            return true;
        }

        //进行循环判断是否一直相等
        for (int i = 0, j = judgeStr.length() - 1; i < j; i++, j--) {
            //分别从两个方向判断字符是否相等
            if (judgeStr.charAt(i) != judgeStr.charAt(j)) {
                return false;
            }
        }

        return true;

    }
}
