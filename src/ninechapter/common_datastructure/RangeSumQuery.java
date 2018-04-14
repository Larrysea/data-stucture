package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

/**
 * 计算从某个下标到某个下标的总和
 *
 * @author
 * @create 2018-04-14 下午2:03
 **/
public class RangeSumQuery {

    public static void main(String[] args) {

        int[] testCase1 = {1, 3, 5};
        NumArray numArray = new NumArray(testCase1);
        PrintUtil.print(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        PrintUtil.print(numArray.sumRange(0, 2));
    }


    static class NumArray {

        private int[] mNums;

        public NumArray(int[] nums) {
            mNums = nums;
        }

        public void update(int i, int val) {
            if (i >= mNums.length) {
                return;
            }
            mNums[i] = val;
        }

        public int sumRange(int i, int j) {
            if (i < 0 || j >= mNums.length) {
                return 0;
            }

            int sum = 0;
            for (int start = i; start <= j; start++) {
                sum += mNums[start];
            }

            return sum;
        }
    }
}
