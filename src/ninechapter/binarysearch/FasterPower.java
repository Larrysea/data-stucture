package ninechapter.binarysearch;

/**
 * 模运算,暂时未理解这道题目
 *
 * @author
 * @create 2018-03-04 下午11:52
 **/
public class FasterPower {

    public static void main(String[] args) {


    }

    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer     模运算分解   a^b%p  =  (a%p * b%p)%p
     */
    public int fastPower(int a, int b, int n) {


        // write your code here
        if (n == 0) {
            return 1 % b;
        }

        if (n == 1) {
            return a % b;
        }

        //将之拆分,避免溢出
        long result = fastPower(a, b, n / 2);

        result = (result * result) % b;

        if (n % 2 == 1) {
            result = (result * a) % b;
        }


        return (int)result;
    }
}
