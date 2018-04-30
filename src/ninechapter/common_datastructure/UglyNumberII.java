package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找出第n位丑数
 *
 * @author
 * @create 2018-04-11 上午1:22
 **/
public class UglyNumberII {

    public static void main(String[] args) {
        PrintUtil.print(nthUglyNumber(11));
    }


    public static int nthUglyNumber(int n) {

        if (n <= 0) {
            return 0;
        }

        int uglyNumberArray[] = new int[n];

        uglyNumberArray[0] = 1;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int nextIndex = 1;


        while (nextIndex < n) {

            //找出三种可能中最小的数作为下一个数
            int min = min(uglyNumberArray[p2] * 2, uglyNumberArray[p3] * 3, uglyNumberArray[p5] * 5);

            uglyNumberArray[nextIndex] = min;
            //找出大于当前丑数的下个乘的数，
            while (uglyNumberArray[p2] * 2 <= uglyNumberArray[nextIndex]) {
                p2++;
            }

            while (uglyNumberArray[p3] * 3 <= uglyNumberArray[nextIndex]) {
                p3++;
            }

            while (uglyNumberArray[p5] * 5 <= uglyNumberArray[nextIndex]) {
                p5++;
            }
            ++nextIndex;
        }

        return uglyNumberArray[nextIndex - 1];


    }


    private static int min(int a, int b, int c) {
        int min = a > b ? b : a;

        return min > c ? c : min;

    }

}
