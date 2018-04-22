package offer;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 给出一副牌判断是否是顺子
 *
 * @author
 * @create 2018-04-22 下午12:07
 **/
public class IsContinuous {


    public static void main(String[] args) {

        int[] testCase1 = {1, 3, 0, 0, 5};
        int[] testCase2 = {};
        int[] testCase3 = {1, 2, 3, 4, 5};


        PrintUtil.print(isContinuous(testCase3) + "");

    }

    //是否连续
    public static boolean isContinuous(int[] numbers) {

        //结题思路，找出最大的数和最小的数，去除大王和小王

        //然后开始排序，然后查找，缺少那些数，查看缺少的数量，是否有0可以满足，如果是则true。

        //如果不缺少。则大小王可以添加在头部或者尾部，但是得注意不能超过牌的范围

        Arrays.sort(numbers);

        int zeroCount = 0;

        final int MAX_CONTINUOUS_COUNT = 13;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zeroCount++;
            } else {
                break;
            }
        }

        int countLoseNumber = 0;


        for (int i = zeroCount; i < numbers.length; i++) {
            if (i > zeroCount && numbers[i] - numbers[i - 1] > 1) {
                countLoseNumber += numbers[i] - numbers[i - 1] - 1;

                if (countLoseNumber > zeroCount) {
                    return false;
                }
            }

            //还要考虑是否有牌重复的情况，如果有重复也不能算顺子，返回false

            if (i > zeroCount && numbers[i] == numbers[i - 1]) {
                return false;
            }
        }

        //如果缺少的数和大小王的数量相等，则返回true

        if (zeroCount > 0 && zeroCount == countLoseNumber) {
            return true;
        } else if (zeroCount > countLoseNumber) {

            if (MAX_CONTINUOUS_COUNT >= numbers.length) {
                return true;
            } else {
                return false;
            }
        }

        if (numbers.length > 0 && countLoseNumber == zeroCount) {
            return true;
        }

        return false;


    }
}
