package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * 词汇拼接
 *
 * @author
 * @create 2018-04-02 上午12:07
 **/
public class WordBreak {

    public static void main(String[] args) {
        String str = "lintcode";
        String str1 = "catsanddog";
        String str2 = "a";
        String str3 = "aaab";
        String str4 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";


        Set<String> dict = new HashSet<>();
        String[] array = {"de", "ding", "co", "code", "lint"};
        String[] array1 = {"cat", "cats", "and", "sand", "dog"};
        String[] array2 = {"a", "b"};
        String[] array3 = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};

        for (int i = 0; i < array3.length; i++) {
            dict.add(array3[i]);
        }
//        PrintUtil.print(findLastCharacter(str, "lint"));
        PrintUtil.printStringList(wordBreak(str4, dict));
    }


    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here


        //通过深度搜索获取的序列结果
        List<String> result = new ArrayList<>();
        //哈希图
        HashMap<String, Boolean> vistedMap = new HashMap<>();

        if (wordDict.size() == 0) {
            return result;
        }

        List<String> firstWordList = findFirstWord(s, wordDict);
        //
        for (String str : firstWordList) {
            helper(s, result, wordDict, str, vistedMap);
        }

        return result;
    }


    //找到第一个单词
    private static List<String> findFirstWord(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        for (String str : wordDict) {
            if (str.length() > 0 && s.length() > 0 && str.charAt(0) == s.charAt(0)) {
                result.add(str);
                System.out.println("第0层循环");

            }
        }
        return result;
    }


    //
    private static void helper(String s, List<String> result, Set<String> dict, String word, HashMap<String, Boolean> vistedMap) {
        String temp = word.replaceAll(" ", "");
        if (temp.equals(s)) {
            result.add(word);
        }
        for (String str : findNeighbors(findLastCharacter(s, word), dict)) {
            word += " " + str;
            helper(s, result, dict, word, vistedMap);
            word = word.substring(0, word.lastIndexOf(" "));
            System.out.println("第一层循环");

        }

    }


    //找出下一步的所有可能性,找到邻居
    private static List<String> findNeighbors(Character lastChar, Set<String> dict) {
        List<String> result = new ArrayList<>();
        for (String str : dict) {
            if (str.charAt(0) == lastChar) {
                result.add(str);
                System.out.println("第二层循环");
            }
        }

        return result;
    }


    private static Character findLastCharacter(String src, String word) {
        String trimStr = word.replaceAll(" ", "");
        if (src.length() > trimStr.length() && src.contains(trimStr)) {
            int endIndex = src.indexOf(trimStr) + trimStr.length();
            return src.charAt(endIndex);
        }

        return ' ';
    }

}
