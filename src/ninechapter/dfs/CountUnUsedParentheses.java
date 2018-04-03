package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 找出最小的删除括号数能够组成的合法表达式。
 *
 * @author
 * @create 2018-04-03 下午11:21
 **/
public class CountUnUsedParentheses {

    public static void main(String[] args) {
        String testString = "()())()";
        PrintUtil.printStringList(removeInvalidParentheses(testString));

    }

    private static StringBuilder sb = new StringBuilder();

    /**
     * @param s: The input string
     * @return: Return all possible results
     */
    public static List<String> removeInvalidParentheses(String s) {
        // Write your code here
        List<String> result = new ArrayList<String>();

        //该算法思路，首先找出多余的括号数量，然后通过动态规划删除尝试删除不同位置的的括号，然后判断是否是合法的括号表达式，如果是则添加到结果中去

        int left = 0;
        int right = 0;
        //开始进行统计
        for (int i = 0; i < s.length(); i++) {
            //如果等于左括号则左括号数量加一
            if (s.charAt(i) == '(') {
                left++;
            }
            //如果匹配到右括号，但是左括号数量不为0 ，则首先减少左括号数量，如果左括号数量为0，则右括号数量加一
            if (s.charAt(i) == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }

            }
        }

        helper(result, left, right, 0, s);

        return result;
    }

    //搜索着去删除多余的括号

    private static void helper(List<String> result, int left, int right, int start, String s) {

        //如果左右两边括号都等于0
        if (left == 0 && right == 0) {
            //判断是否是合法字符串，感觉这一步有点多余，待会测试的时候看是否可以去掉
            if (isValid(s)) {
                result.add(s);
                return;

            }

        }

        //开始尝试删除多余的括号
        for (int i = start; i < s.length(); i++) {
            //如果两个括号相同则忽略掉，删除这两个相邻括号中的任意一个括号都是可以的
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            sb.delete(0, sb.length());
            //如果有多余的左括号，则开始尝试删除操作
            if (s.charAt(i) == '(' && left > 0) {
                sb.append(s.substring(0, i));
                sb.append(s.substring(i + 1));
                helper(result, left - 1, right, i, sb.toString());
            }
            sb.delete(0, sb.length());
            if (s.charAt(i) == ')' && right > 0) {
                sb.append(s.substring(0, i));
                sb.append(s.substring(i + 1));
                helper(result, left, right - 1, i, sb.toString());
            }


        }


    }


    //判断该字符串是否是合法字符串
    private static boolean isValid(String s) {
        //括号数量的记录
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

}
