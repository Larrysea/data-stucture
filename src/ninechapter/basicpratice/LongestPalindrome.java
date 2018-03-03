package ninechapter.basicpratice;

import data_stucture.PrintUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 找出一个给定字符串能够组成的最长回文字符串
 *
 * @author
 * @create 2018-03-03 下午4:00
 **/
public class LongestPalindrome {

    public static void main(String[] args) {
        String testCase1 = "abccccdd";

        String testCase2 = "aaa";

        String testCase3 = "aaabb";

        String testCase4 = "aaab";

        String testCase5 = "NTrQdQGgwtxqRTSBOitAXUkwGLgUHtQOmYMwZlUxqZysKpZxRoehgirdMUgy";

        String testCase6 = "Aa";

//        PrintUtil.print(longestPalindrome(testCase1));
//
//        PrintUtil.print(longestPalindrome(testCase2));
//
//
//        PrintUtil.print(longestPalindrome(testCase3));
//
//        PrintUtil.print(longestPalindrome(testCase4));
        PrintUtil.print(longestPalindromeII(testCase6));
    }


    //记住两个点，string 对象的的获取长度方法是length()而不是length,因为String 是一个对象
    //还有一个点通过通过iterator 方法获取到的对象是一个基础类型的object对象而不是某个具体类型对象
    //因为map 中可以存在null 值所以可能为空，所傻需要判断是否为空


    /**
     * 自己的想法实现有问题，需要再次确认问题出在哪里
     *
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<String, Integer> charMap = new HashMap<String, Integer>();

        String key = "";
        //统计每个字母出现的次数，大写字母和小写字母需要区分开来
        for (int i = 0; i < s.length(); i++) {
            //如果已经包含了key
            key = String.valueOf(s.charAt(i));
            if (charMap.containsKey(key)) {
                charMap.put(key, charMap.get(key) + 1);
            } else {
                charMap.put(key, 1);
            }
        }

        int maxPalindromeLength = 0;
        Iterator iterator = charMap.entrySet().iterator();


        //其中存在的最长的奇数
        int longestOdd = Integer.MIN_VALUE;


        key = "";
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iterator.next();
            key = entry.getKey();
            //如果该key 对应的字符的数量是偶数则表示可以构成回文字符串
            if (entry.getValue() % 2 == 0) {
                maxPalindromeLength += entry.getValue();
            } else {
                if (longestOdd < charMap.get(key)) {
                    longestOdd = charMap.get(key);
                }
            }
        }

        //如果是即存在奇数的情况还有存在偶数的情况则


        if (maxPalindromeLength < s.length()) {
            return maxPalindromeLength + longestOdd;
        }

        return maxPalindromeLength;
    }


    //推荐算法
    public static int longestPalindromeII(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int removeSize = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }
        removeSize = set.size();

        if (removeSize > 0) {
            removeSize -= 1;
        }
        return s.length() - removeSize;
    }


}
