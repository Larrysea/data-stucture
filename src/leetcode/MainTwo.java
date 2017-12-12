package leetcode;

/**
 * Created by Larry-sea on 2016/12/14.
 * <p>
 * 测试主函数
 */
public class MainTwo {

    public static void main(String[] args) {
        String testString = "PAYPALISHIRING";
        String testString1 = "A";
        String testString2 = "ABCDE";
        int testInt = 1534236469;
        int testInt1 = -2147483648;
//        ZigZag.converToZigZagString(testString2,4);
//        int a=ReverseInteger.reverse(123456);
        double testInt2=-0123123.113;
        String testInt3="-2147483648";
        String testInt4="-2147483649";
//        StringToInteger.StringToInteger(testInt4);
        judgeNull(null);
    }


    static public void judgeNull(String parm)
    {
        if((null==null?0:1)==0)
        {
            System.out.println("null equal");
        }
    }

}
