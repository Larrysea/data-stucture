package offer;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * 最小的k个数
 *
 * @author
 * @create 2018-04-17 下午11:32
 **/
public class LeesKNumber {


    public static void main(String[] args) {
        int[] testCase1 = {4, 5, 1, 6, 2, 7, 3, 8};

        PrintUtil.printList(GetLeastNumbers_Solution(testCase1, 8));
    }

    //通过构建一个大小为k的优先队列，通过排序，hailhail
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        for (int i = 0; i < input.length; i++) {
            queue.offer(input[i]);
            while (queue.size() == k + 1) {
                queue.poll();
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        Collections.sort(result);
        return result;
    }
}
