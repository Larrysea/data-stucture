package offer;

import data_stucture.PrintUtil;

/**
 * 坐旋转字符串
 *
 * @author
 * @create 2018-04-20 上午12:58
 **/
public class LeftRotateString {

    public static void main(String[] args) {
        PrintUtil.print(LeftRotateString("abcXYZdef", 3));
    }

    public static String LeftRotateString(String str, int n) {

        if (str.length() == 0 || n == 0) {
            return str;
        }

        int realMove = 0;
        //移动位数大于实际长度
        if (n > str.length()) {
            realMove = n % str.length();
        } else {
            realMove = n;
        }

        String cuteString = str.substring(0, realMove);

        str = str.substring(realMove);

        str = str + cuteString;

        return str;
    }
}
