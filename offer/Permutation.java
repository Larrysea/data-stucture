package offer;

import java.util.ArrayList;

/**
 * Created by Larry-sea on 2017/6/2.
 * <p>
 * 字母的置换排列算法
 */
public class Permutation {

    public static ArrayList<String> Permutation(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<String>();
        permutation(str, str.substring(0, 1), result);
        return result;
    }

    public static void swap(String source, String dst) {
        String temp = dst;
        dst = source;
        source = temp;
    }


    /**
     * 迭代
     *
     * @param str    源字符串
     * @param result 结果链表
     */
    public static void permutation(String str, String begin, ArrayList<String> result) {
        if (begin == null) {
            result.add(str);
        } else {
            //一次和后面的每一个字母进行交换
            for (int position = 0; position < str.length(); position++) {
                //开始交换
                swap(str.substring(position, position + 1), str.substring(position + 1, position + 2));
                permutation(str, str.substring(position, position + 1), result);
                //进行数据还原
                swap(str.substring(position, position + 1), str.substring(position + 1, position + 2));
            }
        }
    }

    public static void main(String[] args) {
        String test1 = "abc";
        Permutation(test1);

    }


}