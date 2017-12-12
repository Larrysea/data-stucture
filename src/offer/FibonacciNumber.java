package offer;

/**
 * Created by Larry-sea on 2017/1/30.
 * <p>
 * 实现斐波那契表达式的求值
 */
public class FibonacciNumber {

    static public int fibnacciNumber(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibnacciNumber(n - 1) + fibnacciNumber(n - 2);
        }
    }

    public static void main(String[] args) {

        long result = moreEfficientFib(3);

        try {
            jumpFloorII(4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }


    static public long moreEfficientFib(int n) {
        if (n <= 1) {
            int array[] = {0, 1};
            return array[n];
        }
        long minusOne, minusTwo, result;
        minusOne = 1;
        minusTwo = 0;
        result = 0;
        for (int position = 2; position <= n; position++) {
            result = minusOne + minusTwo;
            minusTwo = minusOne;
            minusOne = result;
        }
        return result;
    }


    /*
    * 青蛙跳台阶问题
    *
    * 一个青蛙可以跳上一阶台阶或者是二阶台阶  现在有n阶台阶青蛙有多少种类调法
    *
    * */
    static public int jumpFloor(int nFloor) throws  Exception{
        if(nFloor<=0)
        {
            throw  new Exception("nFloor must greater than zero");
        }
        if (nFloor == 1) {
            return 1;
        }
        if (nFloor == 2) {
            return 2;
        }
        return jumpFloor(nFloor - 1) + jumpFloor(nFloor - 2);
    }



    /*
    *
    * 青蛙跳台阶问题升级版  2
    *
    * 青蛙可以跳上一阶台阶或者是二阶台阶  或者是n阶台阶，当青蛙需要跳上n阶台阶时青蛙有多少种跳法
    *
    *
    *
    * */

    static public int jumpFloorII(int floor)  throws  Exception
    {
        if(floor<=0)
        {
            throw new Exception("floor must greater than zero");
        }
        return (int)Math.pow(2,floor-1);

    }

}
