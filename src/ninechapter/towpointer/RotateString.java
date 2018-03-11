package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 旋转数组
 *
 * @author
 * @create 2018-03-10 下午11:33
 **/
public class RotateString {


    public static void main(String[] args) {
        char[] testCase1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] inputCase = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] testCase2 = {'c', 'p', 'p', 'j', 'a', 'v', 'a', 'p', 'y'};
//        rotateString(testCase1, 0);
//        PrintUtil.printCharArray(testCase1);
//        testCase1 = inputCase;
        rotateString(testCase2, 25);
        PrintUtil.printCharArray(testCase2);
//        testCase1 = inputCase;
//
//        rotateString(testCase1, 2);
//        PrintUtil.printCharArray(testCase1);
//        testCase1 = inputCase;

//        rotateString(testCase1, 3);
//        PrintUtil.printCharArray(testCase1);

    }

    public static void rotateString(char[] str, int offset) {
        // write your code here

        if (str == null || str.length == 0 || offset == 0) {
            return;
        }

        if (offset >= str.length) {
            offset = offset % str.length;
        }

        char offsetArray[] = new char[offset];

        //首先取出需要旋转的数
        for (int i = 0; i < offset; i++) {
            offsetArray[offset - i - 1] = str[str.length - i - 1];
        }



        //然后将数组整体移动offset个位置
        for (int j = str.length - offset - 1; j >= 0; j--) {
            str[j + offset] = str[j];
        }

        for (int z = 0; z < offset; z++) {
            str[z] = offsetArray[z];
        }

    }
}
