package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符串枚举，要求不重复
 *
 * @author
 * @create 2018-04-06 下午10:26
 **/
public class StringPermutation {

    public static void main(String[] args) {
        String test = "ecba";

        int[] array = new int[test.length()];
        for (int i = 0; i < test.length(); i++) {
            array[i] = test.charAt(i);
        }

        char[] charArray = test.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < test.length(); i++) {
//            charArray[i] = (char) array[i];
        }
//        PrintUtil.printCharArray(charArray);
        PrintUtil.printStringList(stringPermutation2("abb"));

    }


    /**
     * @param str: A string
     * @return: all permutations
     */
    public static List<String> stringPermutation2(String str) {
        // write your code here
        //结题思路，通过字符字段排序，如果字母一样，则跳过，避免字母重复问题，然后用dfs计算出所有组合
        // write your code here
        //结题思路，通过字符字段排序，如果字母一样，则跳过，避免字母重复问题，然后用dfs计算出所有组合
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        List<String> result = new ArrayList<>();
        boolean[] visted = new boolean[str.length()];
        helper(result, 0, String.valueOf(charArray), new StringBuilder(), visted);
        return result;
    }

    //length少写括号，result拼写错误
    private static void helper(List<String> result, int index, String str, StringBuilder word, boolean[] visted) {
        if (word.length() == str.length()) {
            result.add(word.toString());
        }

        for (int i = 0; i < str.length(); i++) {
            if (visted[i] || (i != 0 && str.charAt(i) == str.charAt(i - 1) && !visted[i - 1])) {
                continue;
            }
            word.append(str.charAt(i));
            visted[i] = true;
            helper(result, index + 1, str, word, visted);
            visted[i] = false;
            word.deleteCharAt(word.length() - 1);
        }
    }


    //有两类dfs问题，一类是允许重复，这种是每次都是0开始递归，这总特别有可能栈溢出，所以要确保有解，还有一种问题是不允许重复，枚举所有，这种每次都是从下一个开始递归


}
