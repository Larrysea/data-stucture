package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

/**
 * 字符串转整型
 *
 * @author
 * @create 2018-04-21 上午12:25
 **/
public class StringToInt {

    public static void main(String[] args) {
        PrintUtil.print(StrToInt("+2147483647"));
        PrintUtil.print(StrToInt("+123"));
        PrintUtil.print(StrToInt("-123"));

        PrintUtil.print('0');
        PrintUtil.print(StrToInt("-2147483648"));
        PrintUtil.print(StrToInt("214748367"));

    }

    //字符串转为整形
    public static int StrToInt(String str) {

        int number = 0;

        int index = 0;


        boolean isPositive = true;

        if (str.length() == 0) {
            return 0;
        }

        if (str.charAt(0) == '+') {
            isPositive = true;
        }
        if (str.charAt(0) == '-') {
            isPositive = false;
        }

        if (str.charAt(0) - 48 == 0) {
            return 0;
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (i == 0 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
                break;
            }

            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '+' && str.charAt(i) != '-') {
                return 0;
            } else {
                //如果为正数
                if (isPositive) {
                    number += (str.charAt(i) - 48) * Math.pow(10, index);
                }
                //如果为负数
                else {
                    number += -1 * ((str.charAt(i) - 48) * Math.pow(10, index));
                }
                index++;
            }
        }

        if (!isPositive) {
            number = -1 * Math.abs(number);
        }

        return number;

    }


}
