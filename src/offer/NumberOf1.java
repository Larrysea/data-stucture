package offer;

/**
 * Created by Larry-sea on 2017/3/1.
 * <p>
 * 求二进制中1的位数
 */
public class NumberOf1 {

    //解题思路是通一种特殊的运算方法来实现这种思路，
    // 通过-1操作来达到减少二进制中的一个1 但是在执行这个操作之后最右边的所有0将会变成1
    //但是通过将减一之后的这个数在与没有减1 之前的这个数操作之后做与操作，这时的效果是消灭这个二进数中的最右边的一个1
    //按照这种思路来最后获取总共有多少个1
    public static int NumberOf1(int n) {
        int count1 = 0;
        while (n != 0) {
            n = (n - 1) & n;
            count1++;
        }
        return count1;
    }

}
