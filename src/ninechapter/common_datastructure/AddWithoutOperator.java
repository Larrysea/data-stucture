package ninechapter.common_datastructure;

import data_stucture.PrintUtil;
import offer.PrintMinNumber;

/**
 * 两数相加而不使用运算符
 *
 * @author
 * @create 2018-04-20 下午11:52
 **/
public class AddWithoutOperator {


    public static void main(String[] args) {
        PrintUtil.print(Add(2, 3));
        PrintUtil.print(Add(-1, 2));

    }

    private static int result = 0;

    public static int Add(int num1, int num2) {

        result = 0;

        if (num1 > 0) {
            add(num1, true);
        } else {
            add(num1, false);
        }

        if (num2 > 0) {
            add(num2, true);
        } else {
            add(num2, false);
        }


        return result;
    }

    public static int add(int num, boolean isPositive) {
        num = Math.abs(num);
        for (int i = 0; i < num; i++) {
            if (isPositive) {
                result++;
            } else {
                result--;
            }
        }
        return result;
    }

}
