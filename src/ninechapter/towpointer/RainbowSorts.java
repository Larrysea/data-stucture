package ninechapter.towpointer;

import data_stucture.PrintUtil;

/**
 * 彩虹排序
 *
 * @author
 * @create 2018-03-23 上午1:19
 **/
public class RainbowSorts {

    public static void main(String[] args) {
        int[] testCase1 = {3, 2, 2, 1, 4};
        int target1 = 4;
        sortColors2(testCase1, target1);
        PrintUtil.printArray(testCase1);
    }


    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public static void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0 || k == 0) {
            return;
        }

        //统计
        for (int i = 0; i < colors.length; i++) {
            //如果当前数大于0
            while (colors[i] > 0) {
                //每一判断i 位置上的数是在变化
                int curNum = colors[i];
                //如果该桶上不存在数,则将该桶当做计数器，记录重复数的大小,并且把桶上的数移动到i的位置
                if (colors[curNum - 1] > 0) {
                    colors[i] = colors[curNum - 1];
                    colors[curNum - 1] = -1;

                }
                //如果该桶上已经存在数了
                else if (colors[curNum - 1] <= 0) {
                    //则继续对桶进行加一操作
                    colors[curNum - 1]--;
                    //并且将该原有位置置位0
                    colors[i] = 0;
                }
            }

        }

        int index = colors.length - 1;

        //桶上的统计已经完成，从后向前还原数组

        for (int i = k - 1; i >= 0; i--) {
            int count = -colors[i];


            if (count == 0) {
                continue;
            }

            while (count > 0) {
                //进行还原，将每个桶中的计数取出，加一代表该桶上存储的数是多少
                colors[index--] = i + 1;
                count--;
            }
        }


    }


}
