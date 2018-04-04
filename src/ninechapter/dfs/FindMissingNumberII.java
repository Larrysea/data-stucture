package ninechapter.dfs;

import data_stucture.PrintUtil;

/**
 * 找出字符串中丢失的数
 *
 * @author
 * @create 2018-04-05 上午1:12
 **/
public class FindMissingNumberII {

    public static void main(String[] args) {

        String testString = "1234590";
        for (int i = 0; i < testString.length(); i++) {
//            System.out.println(testString.charAt(i) - '0');
        }

        PrintUtil.print(findMissing2(20, "19201234567891011121314151618"));
    }


    private static int theMissing = -1;

    /**
     * @param n:   An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    public static int findMissing2(int n, String str) {
        // write your code here
        //该算法思路是因为n小于30 也就是每个数存在两种可能一种是在一个两位数中，或者是在一个一位数中，所有通过dsf分别尝试某个数是两位数还是一位数的去递归，并且把状态记录下来，看最终那个数，没有访问到，则该结果就该数

        if (n <= 0 || str.length() == 0) {
            return 0;
        }

        //为何要有加 1 这个步骤，因为这个数是从1 开始所以第一位空着，好与数相对应起来
        boolean[] isExist = new boolean[n + 1];

        helper(n, str, 0, isExist);

        return theMissing;

    }


    private static void helper(int n, String s, int startIndex, boolean[] isExist) {

        if (theMissing != -1) {
            return;
        }

        //通过循环找出那个数没有被查到过,从1 开始检查
        if (startIndex == s.length()) {
            for (int i = 1; i <= n; i++) {
                if (!isExist[i]) {
                    theMissing = i;
                    return;
                }
            }
            return;
        }

        //如果该数首位是0，则代表不可能所以返回，因为范围是1<= x <= n
        if (s.charAt(startIndex) == '0') {
            return;
        }

        //尝试每个数一位两位的去组成
        for (int i = 1; i <= 2 && startIndex + i <= s.length(); i++) {
            int number = Integer.valueOf(s.substring(startIndex, startIndex + i));
            //判断该数是否合法,且该数不存在
            if (number > 0 && number <= n && !isExist[number]) {
                isExist[number] = true;
                helper(n, s, startIndex + i, isExist);
                isExist[number] = false;

            }

        }
        return;

    }


}
