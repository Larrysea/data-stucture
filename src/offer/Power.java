package offer;

import java.text.NumberFormat;
import java.util.IllegalFormatConversionException;

/**
 * Created by Larry-sea on 2017/3/2.
 * <p>
 * 实现power函数
 * <p>
 * <p>
 * 需要考虑的情形    指数没有限制
 * 计算结果过大返回结果溢出的情形
 */
public class Power {


    public static void main(String[] args) {
        double a = 1231231.213123;
        System.out.println(Power(2, 3));

    }


    public static double Power(double base, int exponent) throws IllegalArgumentException {

        double result = 1;
        boolean exponentLessZero = false;

        if (base == 0) {
            return 0;
        } else {
            if (exponent < 0) {
                exponentLessZero = true;
                exponent=Math.abs(exponent);
            }

            for (int position = 0; position < exponent; position++) {
                result *= base;
            }

            if (exponentLessZero) {
                result = 1.0 / result;
            }

        }

        return result;
    }


}
