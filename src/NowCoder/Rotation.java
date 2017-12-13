package NowCoder;

/**
 * Created by Larry-sea on 2017/12/12.
 */
public class Rotation {
    /*
    * 代码逻辑：
    * 1 判断两个字符串为不为空，长度是不是合理范围
    * 2 判断两个字符串是否长度是否相等
    * 3 构建两个字符串拼接好的字符
    * 4 拼接而成的字符串拼接看是否相等，如果相等则判断是否包含
    * 5 如果包含则返回true，否则返回false
    *
    *
    *
    * */


    public static boolean chkRotation(String A, int lena, String B, int lenb) {
        // write code here
        if (A == null || B == null || lena <= 0 || lenb <= 0) {
            return false;
        }
        String doubleString = A + A;
        return doubleString.contains(B);

    }

    public static void main(String[] args) {
        boolean result1 = chkRotation("", 6, "", 5);
        boolean result2 = chkRotation("cdab", 4, "abcd", 4);
        System.out.println(result1);
        System.out.println(result2);
    }

}
