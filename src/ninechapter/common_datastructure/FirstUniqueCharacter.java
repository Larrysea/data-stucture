package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.HashMap;

/**
 * 第一次出现的字符
 *
 * @author
 * @create 2018-04-08 下午11:54
 **/
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        PrintUtil.print((char)firstUniqChar("abaccdeff"));
    }


    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public static char firstUniqChar(String str) {
        // Write your code here
        //通过一个hashset来进行添加，如果添加到那个字符的时候添加失败则返回该字符。空间复杂度为O(n),有没有O(1)的解法
        //通过一遍遍历将每个字母出现的次数记录到hashMap中再次遍历字符串的时候取出该值出现的次数如果是1则立即返回

        if (str.length() == 0) {
            return ' ';
        }


        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            if (charCount.containsKey(str.charAt(i))) {
                charCount.put(str.charAt(i), charCount.get(str.charAt(i)) + 1);
            } else {
                charCount.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (charCount.get(str.charAt(i)) != null && charCount.get(str.charAt(i)) == 1) {
                return (char) str.charAt(i);
            }
        }

        return ' ';

    }
}
