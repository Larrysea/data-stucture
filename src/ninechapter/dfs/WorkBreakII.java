package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * 通过深搜找出所有可能组成结果的集合
 *
 * @author
 * @create 2018-04-02 下午11:32
 **/
public class WorkBreakII {


    public static void main(String[] args) {
        String str = "lintcode";
        String[] array = {"de", "ding", "co", "code", "lint"};

        String str1 = "a";

        Set<String> dict = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
//            dict.add(array[i]);
        }
        dict.add("");
        PrintUtil.printStringList(wordBreak(str1, dict));
    }


    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return result;
        }
        HashMap<String, List<String>> resultMap = new HashMap<>();
        result = helper(s, wordDict, resultMap);
        return result;
    }

    /**
     * @param s         需要拆解的单词
     * @param dict      词典
     * @param resultMap 结果map
     * @return
     */
    //找出结果
    private static List<String> helper(String s, Set<String> dict, HashMap<String, List<String>> resultMap) {
        //如果结果map中有则直接进行取出来返回
        if (resultMap.containsKey(s)) {
            return resultMap.get(s);
        }
        List<String> list = new ArrayList<>();
        int length = s.length();
        //如果该字符串长度为0
        if (length == 0) {
            list.add("");
        } else {
            //开始进行切割,位置要从1 开始切割否则会出现死循环，在字典中存在空的词时出现
            for (int i = 1; i <= length; i++) {
                String left = s.substring(0, i);

                //如果词典中不包含左半部分则继续
                if (!dict.contains(left)) {
                    continue;
                }

                //寻找右边所有的结果集
                List<String> rightWreakList = helper(s.substring(i, length), dict, resultMap);

                if (rightWreakList.size() == 0) {
                    continue;
                }

                for (String rightWord : rightWreakList) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(left);
                    if (i != length && i != 0) {
                        sb.append(" ");
                    }
                    sb.append(rightWord);
                    list.add(sb.toString());
                }

            }
        }


        resultMap.put(s, list);
        return list;
    }

}
