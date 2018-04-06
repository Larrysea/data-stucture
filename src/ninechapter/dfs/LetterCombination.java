package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字母组合问题
 *
 * @author
 * @create 2018-04-06 下午3:17
 **/
public class LetterCombination {


    public static void main(String[] args) {
        PrintUtil.printStringList(letterCombinations("22"));

    }


    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        List<Integer> digitList = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            digitList.add(Integer.valueOf(digits.substring(i, i + 1)));

        }

        List<String> wordList = new ArrayList<>();

        for (int i = 0; i < digitList.size(); i++) {
            wordList.add(findAllCharacter(digitList.get(i)));
        }


        if (digitList.size() > 0) {
            helper(result, new StringBuilder(), 0, wordList, digits);
        }

        return result;
    }


    private static void helper(List<String> result, StringBuilder next, int index, List<String> wordList, String digits) {
        if (index == digits.length()) {
            result.add(next.toString());
            return;
        }
        //组合的第一个数在第一个词中遍历，下一个词就在第二个词中遍历
        for (int i = 0; i < wordList.get(index).length(); i++) {
            next.append(wordList.get(index).charAt(i));
            helper(result, next, index + 1, wordList, digits);
            next.deleteCharAt(next.length() - 1);
        }

    }


    //找到所有字符串
    private static String findAllCharacter(int number) {
        switch (number) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
        }
        return "";
    }
}
