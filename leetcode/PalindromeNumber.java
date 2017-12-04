package leetcode;

/**
 * Created by Larry-sea on 2016/12/16.
 *
 * leetcode 9   判断一个字数字是否是回文数
 */
public class PalindromeNumber {

    //    static public void
    static public boolean isPalidrome(int number)
    {
           return isPalindromicString(String.valueOf(number));
    }


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


}
