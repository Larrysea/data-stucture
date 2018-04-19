package offer;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 打印最组合最小的数
 *
 * @author
 * @create 2018-04-19 下午11:50
 **/
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] numbers = {3, 32, 321};
        PrintUtil.print(PrintMinNumber(numbers));
    }

    public static String PrintMinNumber(int[] numbers) {

        if (numbers.length == 0) {
            return "";
        }

        String result = "";
        String[] list = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            list[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(list, new Comparator<String>() {

            @Override
            public int compare(String a1, String a2) {
                return ((a1 + a2).compareTo(a2 + a1));
            }

        });

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }
}
