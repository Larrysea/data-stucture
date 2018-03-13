package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 给出一个数组计算总共有多少对满足组成三角形的集合。
 *
 * @author
 * @create 2018-03-14 上午1:15
 **/
public class TriangleCount {

    public static void main(String[] args) {
        int[] testCase1 = {3, 4, 6, 7};
        PrintUtil.print(triangleCount(testCase1));
    }


    /*  该题目思考的关键是两边之和大于第三边则符合三角形
     * @param S: A list of integers
     * @return: An integer
     */
    public static int triangleCount(int[] S) {
        // write your code here

        //如果长度为0 则返回0
        if (S == null || S.length == 0) {
            return 0;
        }

        Arrays.sort(S);

        int angleCount = 0;
        for (int i = 0; i < S.length; i++) {
            //当i  开始等于3的时候才能开始进行循环
            int right = i - 1;
            int left = 0;

            //如果左边小于右边，然后就是不断缩小范围找出所有小于最大边的数
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    //如果是最左边的数都开始满足条件了，则left - right 过程中的数都会满足条件，所以angleCount = 他们之间有多少个数的和
                    angleCount += right - left;
                    right--;
                } else {
                    left++;
                }

            }

        }

        return angleCount;
    }

}
