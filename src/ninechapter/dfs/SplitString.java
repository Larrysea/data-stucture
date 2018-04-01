package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 分割字符串
 *
 * @author
 * @create 2018-04-01 下午4:14
 **/
public class SplitString {


    public static void main(String[] args) {
        String inputString = "123";
        PrintUtil.printStringListList(splitString(inputString));
    }


    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public static List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> results = new ArrayList<>();

        if (s == null) {
            return results;
        }
        //等于0
        else if (s.length() == 0) {
            results.add(new ArrayList<>());
            return results;
        }
        helper(s, 0, results, new ArrayList<String>());

        return results;

    }


    private static void helper(String s, int index, List<List<String>> results, List<String> result) {
        if (index == s.length()) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = index; i < index + 2 && i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            result.add(temp);
            helper(s, i + 1, results, result);
            result.remove(result.size() - 1);
        }
    }
}
