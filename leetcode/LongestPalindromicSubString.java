package leetcode;

/**
 * Created by Larry-sea on 2016/12/10.
 * <p>
 * 最长的回文数
 */
public class LongestPalindromicSubString {


    static public String getLongestPalindromicSubString(String inputString) {
        String resultString = "";
        String maxString = "";
        String reverseMaxString="";
        int maxLength = 0;
        String lastString = "";
        String tempString;
        maxString = getLongestPalindromicString(inputString, resultString, maxString, maxLength);
        reverseMaxString=getLongestPalindromicString(reverString(inputString), resultString, maxString, maxLength);
        if(reverseMaxString.length()>maxString.length())
        {
            return reverseMaxString;
        }
        resultString = "";

        return maxString;
    }

    private static String getLongestPalindromicString(String inputString, String resultString, String maxString, int maxLength) {
        String tempString;
        String lastString;
        for (int nextPosition = 0; nextPosition < inputString.length(); nextPosition++) {
            resultString += inputString.charAt(nextPosition);
            if (isPalindromicString(resultString)) {
                if (resultString.length() > maxLength) {
                    maxLength = resultString.length();
                    maxString = resultString;
                }
            }

            if (resultString.length() > 1 && (tempString=judgeIsPalindromicSubString(resultString))!=null) {
                lastString=resultString;
                resultString=tempString;
                if (resultString.length() > maxLength) {
                    maxLength = resultString.length();
                    maxString = resultString;
                }
                resultString=lastString;
            }

        }
        return maxString;
    }


    /*
    *
    * 检查是否是回文数
    *
    * */
    static public boolean isPalindromicString(String inputString) {

        if (inputString.length() == 1) {
            return true;
        }
        if (inputString.length() % 2 == 0) {

            //如果字符串是偶数长度的字符串则进行拆半判断是否是对称字符串
            if (inputString.substring(0, inputString.length() / 2).equals(reverString(inputString.substring(inputString.length() / 2)))) {
                return true;
            } else {
                return false;
            }
            //如果是奇数字符串则通过去除中间的那个字符之后判断是否是对称字符串
        } else {
            if (inputString.substring(0, inputString.length() / 2).equals(reverString(inputString.substring((inputString.length() / 2) + 1)))) {
                return true;
            } else {
                return false;
            }

        }
    }


    /*
    * 反转字符串
    *
    * */
    static public String reverString(String normalString) {
        String reverString = "";
        for (int position = normalString.length() - 1; position >= 0; position--) {
            reverString += normalString.charAt(position);
        }
        return reverString;
    }

    /**
     * @param inputString
     * @return 判断现在subString 中是否存在回文字符串
     */
    static public String judgeIsPalindromicSubString(String inputString) {
        String subString = "";
        String lastCharacter = "";
        if (inputString.length() > 1) {
            lastCharacter = inputString.substring(inputString.length() - 1);
            if (inputString.substring(0,inputString.length()-1).contains(lastCharacter)) {
                subString = inputString.substring(inputString.indexOf(lastCharacter));
                if (isPalindromicString(subString)) {
                    return subString;
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } else {
            throw new IllegalArgumentException("inputString legth cant less 1");
        }
    }

   static public class Solution {
        private int lo, maxLen;

        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s;

            for (int i = 0; i < len-1; i++) {
                extendPalindrome(s, i, i);      //assume odd length, try to extend Palindrome as possible
                extendPalindrome(s, i, i+1); //assume even length.
            }
            return s.substring(lo, lo + maxLen);
        }

        private void extendPalindrome(String s, int j, int k) {
            while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
            }
            if (maxLen < k - j - 1) {
                lo = j + 1;
                maxLen = k - j - 1;
            }
        }}

}
