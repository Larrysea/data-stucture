package offer;

import data_stucture.PrintUtil;

/**
 * 找出独一无二的字符串
 *
 * @author
 * @create 2018-04-18 下午11:50
 **/
public class UniqueChar {


    public static void main(String[] args) {
        String testCase1 = "aabbccedfgaa";
        String testCase2 = "NXWtnzyoHoBhUJaPauJaAitLWNMlkKwDYbbigdMMaYfkVPhGZcrEwp";
//        PrintUtil.print('a' - 'A');
        PrintUtil.print(FirstNotRepeatingChar(testCase2));
    }

    //考虑大小写字母混用的情况
    public static int FirstNotRepeatingChar(String str) {

        if (str.length() <= 0) {
            return -1;
        }

        int[] charArray = new int[52];

        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                index = str.charAt(i) - 'A';
            } else {
                index = str.charAt(i) - 'a' + 26;
            }
//            PrintUtil.print((char) str.charAt(i));
            charArray[index]++;
        }


        for (int i = 0; i < str.length(); i++) {
            int cIndex = 0;
            if (Character.isUpperCase(str.charAt(i))) {
                cIndex = str.charAt(i) - 'A';
            } else {
                cIndex = str.charAt(i) - 'a' + 26;
            }
            if (charArray[cIndex] == 1) {
                return i;
            }
        }

        return -1;
    }
}
