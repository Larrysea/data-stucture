package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并k个排序数组
 *
 * @author
 * @create 2018-04-15 下午2:26
 **/
public class MergeKSotedArrays {
    public static void main(String[] args) {
        int[][] testCase1 = {{1, 3, 5, 7}, {2, 4, 6}, {0, 8, 9, 10, 11}};
        PrintUtil.printArray(mergekSortedArrays(testCase1));
    }


    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public static int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        //结题思路通过优先队列将数组排序，然后输出队列结果到数组中，最后得到合并完以后的数组
        Comparator<Element> comparator = new Comparator<Element>() {

            @Override
            public int compare(Element o1, Element o2) {
                return o1.val - o2.val;
            }
        };

        return mergeKSortedArray(arrays, comparator);

    }

    public static int[] mergeKSortedArray(int[][] arrays, Comparator<Element> comparator) {
        Queue<Element> priorityQueue = new PriorityQueue<>(arrays.length, comparator);

        int count = 0;

        //首先构造基本的优先队列存在每一列开头的第一个数
        for (int row = 0; row < arrays.length; row++) {
            if (arrays[row].length == 0) {
                continue;
            }
            priorityQueue.offer(new Element(row, 0, arrays[row][0]));
            count += arrays[row].length;
        }

        int[] result = new int[count];
        int index = 0;

        //然后开始每一行的比较插入
        while (!priorityQueue.isEmpty()) {
            Element ele = priorityQueue.poll();
            result[index++] = ele.val;
            if (ele.column + 1 < arrays[ele.row].length) {
                priorityQueue.offer(new Element(ele.row, ele.column + 1, arrays[ele.row][ele.column + 1]));
            }

        }

        return result;
    }


    static class Element {
        int row = 0;
        int column = 0;
        int val = 0;

        public Element(int row, int column, int val) {
            this.row = row;
            this.column = column;
            this.val = val;
        }
    }


}
