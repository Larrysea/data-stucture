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

    public static int Add(int num1, int num2) {

        int result = 0;

        if (num1 > 0) {
            for (int i = 0; i < num1; i++) {
                result++;
            }
        } else {
            for (int i = 0; i < -num1; i++) {
                result--;
            }
        }

        if (num2 > 0) {
            for (int j = 0; j < num2; j++) {
                result++;
            }
        } else {
            for (int j = 0; j < -num2; j++) {
                result--;
            }
        }


        return result;

    }
}
