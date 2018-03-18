package ninechapter.towpointer;

import data_stucture.PrintUtil;

import java.util.Arrays;

/**
 * 数组划分
 *
 * @author
 * @create 2018-03-18 上午11:28
 **/
public class PartitionArray {


    public static void main(String[] args) {
        int[] testCase1 = {3, 2, 2, 1};
        int testTarget = 2;
        PrintUtil.print(partitionArray(testCase1, testTarget));

    }


    /**
     * @param nums: The integer array you should partition
     * @param k:    An integer
     * @return: The index after partition
     */
    public static int partitionArray(int[] nums, int k) {
        // write your code here

        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        if (nums[nums.length - 1] < k) {
            return nums.length;
        }

        int kIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= k) {
                kIndex = i;
                break;
            }
        }

        return kIndex;

    }
}
