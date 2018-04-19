package offer;

import data_stucture.PrintUtil;

/**
 * 翻转句子
 *
 * @author
 * @create 2018-04-20 上午1:24
 **/
public class ReverseSentence {
    public static void main(String[] args) {
        PrintUtil.print(ReverseSentence("student. a am I"));
        PrintUtil.print(ReverseSentence("  "));
    }

    public static String ReverseSentence(String str) {

        if (str.trim().equals("")) {
            return str;
        }

        String firstReverseWord = reverseWord(str);

        String[] array = firstReverseWord.split(" ");

        for (int i = 0; i < array.length; i++) {
            array[i] = reverseWord(array[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                result.append(" ");
            }
            result.append(array[i]);
        }

        return result.toString();

    }


    private static String reverseWord(String word) {
        StringBuilder builder = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            builder.append(word.charAt(i));
        }

        return builder.toString();
    }


}
