package ninechapter.basicpratice;

import data_stucture.PrintUtil;

/**
 * 最长回文子字符串
 *
 * @author
 * @create 2018-03-03 下午10:58
 **/
public class LongestPalindromeSubstring {


    public static void main(String[] args) {

        String testCase1 = "abcdzdcab";

        String testCase2 = "bb";

        String testCase4 = "abb";

        PrintUtil.println(longestPalindrome(testCase1));
        PrintUtil.print(longestPalindrome(testCase2));

    }


    public static String longestPalindrome(String source) {

        int longestLen = Integer.MIN_VALUE;

        String longestSubString = "";


        //进行循环
        for (int i = 0; i < source.length(); i++) {

            String s1 = findLongestStr(source, i, i);

            //解决回文字符串出现在两端的这种情况例如：abb 这种
            String s2 = findLongestStr(source, i, i + 1);

            //如果长度大于当前最长长度则更新结果
            if (s1.length() > longestLen) {
                longestLen = s1.length();
                longestSubString = s1;
            }

            if (s2.length() > longestLen) {
                longestLen = s2.length();
                longestSubString = s2;
            }
        }

        return longestSubString;

    }


    private static String findLongestStr(String source, int left, int right) {

        while (left >= 0 && right < source.length()) {
            //如果左右两边不相等，则跳出循环
            if (source.charAt(left) != source.charAt(right)) {
                break;

            }

            //如果相等则进行扩展
            left--;
            right++;

        }

        return source.substring(left + 1, right);


    }


}
