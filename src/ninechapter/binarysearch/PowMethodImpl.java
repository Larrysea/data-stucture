package ninechapter.binarysearch;

import data_stucture.PrintUtil;

/**
 * 冥函数实现
 *
 * @author
 * @create 2018-03-04 下午9:20
 **/
public class PowMethodImpl {


    public static void main(String[] args) {
//        PrintUtil.print(myPow(2.1, 3));
//        PrintUtil.print(myPow(0, 1));
//        PrintUtil.print(myPow(1, 0));
//        PrintUtil.print(myPow(34.00515, -3));
//        PrintUtil.print(myPow(2.00000, -2147483648));
//        PrintUtil.print(myPow(2.00000, 2147483647));

        PrintUtil.print(myPow(42.38803, 1));

    }

    /*
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public static double myPow(double x, int n) {
        // write your code here
        //如果底数为0
        if (x == 0) {
            return 0;
        }

        //如果指数为1，则返回1
        if (n == 1) {
            return x;
        }

        boolean nIsPositive = true;
        if (n < 0) {
            nIsPositive = false;
            n *= -1;
        }
        if (nIsPositive && n == Integer.MAX_VALUE) {
            return Double.POSITIVE_INFINITY;
        } else if (!nIsPositive && n == Integer.MIN_VALUE) {
            return 0;
        }
        double result = 1;

        for (int i = 0; i < n; i++) {
            result *= x;
        }
        if (nIsPositive) {
            return result;
        } else {
            return 1 / result;
        }
    }
}
