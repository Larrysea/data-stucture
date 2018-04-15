package ninechapter.dynamic_program;

/**
 * 跳楼梯问题
 *
 * @author
 * @create 2018-04-15 下午6:42
 **/
public class ClimbingStairs {


    public int climbStairs(int n) {
        // write your code here
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int jump1 = 1;
        int jump2 = 2;

        int lastJump = 0;

        for (int i = 3; i <= n; i++) {
            lastJump = jump1 + jump2;
            jump1 = jump2;
            jump2 = lastJump;
        }

        return lastJump;
    }

}
