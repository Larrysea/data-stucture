package offer;

import data_stucture.PrintUtil;

/**
 * 统计在排序数组中k出现的次数
 *
 * @author
 * @create 2018-04-19 上午1:08
 **/
public class GetNumberOfK {
    public static void main(String[] args) {
        int[] testCase = {1, 2, 2, 2, 3, 3, 3, 5, 6, 6, 7, 8, 8, 8, 8, 10};
        PrintUtil.print(GetNumberOfK(testCase, -1));
    }

    public static int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            } else if (count > 0) {
                break;
            }
        }

        return count;
    }
}
