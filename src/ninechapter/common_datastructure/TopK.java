package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大的k个数
 *
 * @author
 * @create 2018-04-09 下午11:47
 **/
public class TopK {

    public static void main(String[] args) {
        int[] testCase1 = {3, 10, 1000, -99, 4, 100};
        PrintUtil.printArray(topk(testCase1, 3));

    }

    /**
     * @param nums: an integer array
     * @param k:    An integer
     * @return: the top k largest numbers in array
     */
    public static int[] topk(int[] nums, int k) {
        // write your code here
        //维护一个大小为k 的堆来解决这个问题
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }

        });

        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }

        }

        int[] result = new int[k];

        while (!queue.isEmpty()) {
            result[--k] = queue.poll();
        }

        return result;

    }
}
