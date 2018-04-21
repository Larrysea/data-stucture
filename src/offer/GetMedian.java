package offer;

import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 获取中位数
 *
 * @author
 * @create 2018-04-21 下午7:38
 **/
public class GetMedian {


    public static void main(String[] args) {
        int[] testCase1 = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int num : testCase1) {
            Insert(num);
            PrintUtil.print(GetMedian());
        }
    }


    private static List<Integer> list = new ArrayList<Integer>();

    public static void Insert(Integer num) {
        list.add(num);
        Collections.sort(list);
    }


    public static Double GetMedian() {
        //如果偶数长度
        if (list.size() > 0 && list.size() % 2 == 0) {
            int median = list.size() / 2;
            return (list.get(median - 1) + list.get(median)) / 2d;

        } else {
            return (double) list.get(list.size() / 2);
        }
    }
}
