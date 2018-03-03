package ninechapter.basicpratice;

import data_stucture.PrintUtil;

import java.io.CharArrayReader;

/**
 * 验证是否是回文字符串
 *
 * @author
 * @create 2018-03-03 下午6:18
 **/
public class ValidPalindrome {


    public static void main(String[] args) {
        String testCase1 = "A man, a plan, a canal: Panama";
        String testCase2 = "race a car";

        String testCase3 = ".a";


        String testCase4 = ".,";

        String testCase5 = "aa";

        PrintUtil.isTrue(isPalindrome(testCase1));
        PrintUtil.isTrue(isPalindrome(testCase2));
        PrintUtil.isTrue(isPalindrome(testCase3));
        PrintUtil.isTrue(isPalindrome(testCase4));
        PrintUtil.isTrue(isPalindrome(testCase5));
    }

    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            //如果范围不满足则一直向后移动直到找到满足的即可
            while (start < s.length() && !isValid(s.charAt(start))) {
                start++;
            }

            //如果直接移动到数组最后一个位置，代表数组没有合法的数
            if (start == s.length()) {
                return true;
            }

            //范围不满足一直向前移动
            while (end >= 0 && !isValid(s.charAt(end))) {
                end--;
            }

            //如果字母不相等继续向后移动
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                start++;
                end--;
            }

        }
        //能够正常结束循环代是回文数
        return end <= start;
    }

    public static boolean isValid(Character a) {
        if (Character.isDigit(a) || Character.isLetter(a)) {
            return true;
        }
        return false;
    }

}
