package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * k 个排序数组中找出中间数
 *
 * @author
 * @create 2018-04-14 下午11:36
 **/
public class MedianOfKSortedArray {

    public static void main(String[] args) {
        int[][] testCase1 = {{1}, {2}, {3}};
        int[][] testCase2 = {{1}, {}, {2}, {3}, {3}};

        int[][] testCase3 = {
                {5, 7, 15, 27, 37, 47, 50, 52, 56, 100},
                {29, 62},
                {1, 8, 66},
                {}, {2, 5, 37},
                {}, {25, 60, 80},
                {48, 54, 61, 69},
                {19, 28, 34, 50, 53, 55, 66, 76, 94}};
        PrintUtil.print(findMedian(testCase3));
    }


    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public static double findMedian(int[][] nums) {
        // write your code here
        double result = 0;
        //结题思路，通过计算每个数大于它的结果又多少，还有小于它的有多少，最终找出一个大于和等于相同的数，如果是偶数则取中间两个数的平均
        //分别存取那一个数和小于它的有多少
        HashMap<Integer, Integer> keyMap = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                count++;
                if (keyMap.get(nums[i][j]) == null) {
                    int sum = 0;
                    for (int row = 0; row < nums.length; row++) {
                        sum += getLessCount(nums[row], nums[i][j]);
                    }
                    keyMap.put(nums[i][j], sum);
                }
            }
        }
        boolean isOdd = false;
        int middle = 0;
        //如果奇数情况
        if (count % 2 != 0) {
            isOdd = true;
        }
        middle = count / 2;
        int mid1 = -1;
        int mid2 = -1;

        //遍历map找出小于数等于数一半的或者
        Set<Map.Entry<Integer, Integer>> entrySet = keyMap.entrySet();
        //遍历
        for (Map.Entry<Integer, Integer> entry1 : entrySet) {
            if (isOdd) {
                if (entry1.getValue() == middle) {
                    result = entry1.getKey();
                }
            } else {
                if (entry1.getValue() == middle) {
                    mid1 = entry1.getKey();
                }
                if (entry1.getValue() == middle + 1) {
                    mid2 = entry1.getKey();
                }
            }
        }

        if (!isOdd) {
            result = (mid1 + mid2) / 2d;
        }
        return result;
    }

    //计算出某一行小于某个数的值
    private static int getLessCount(int[] row, int k) {
        if (row.length - 1 >= 0 && row[row.length - 1] < k) {
            return row.length;
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] > k) {
                return i;
            }
        }
        return 0;
    }
}
