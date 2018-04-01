package ninechapter.bfs;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * 序列重新构造
 *
 * @author
 * @create 2018-04-01 下午12:56
 **/
public class SequenceReconstruction {

    public static void main(String[] args) {
        int[] org = {4, 1, 5, 2, 6, 3};
        int[][] seqs = {{5, 2, 6, 3}, {4, 1, 5, 2}};
        PrintUtil.print(sequenceReconstruction(org, seqs) + "");

    }


    /**
     * @param org:  a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here

        //该题思路还是一道拓扑排序的问题，
        // 数组中的每个数  就是图中的的点，最终统计出是否存在点并且顺序是org的拓扑排序问题

        //拓扑排序问题，  总结：1  构造出图   2  统计出每个点的度  3  找到起点，然后删除该起点，不断的重复该操作直到达到终点为止

        //存放图的数据结构
        HashMap<Integer, Set<Integer>> map = new HashMap<>();

        //存在图的入度的数据结构
        HashMap<Integer, Integer> indegree = new HashMap<>();


        //开始构造出图

        for (int num : org) {
            map.put(num, new HashSet<>());
            indegree.put(num, 0);
        }

        //用于计算子字符串的长度是否满足要求，防止子字符串总长度没有org长度长
        int length = 0;

        int n = org.length;

        for (int[] seq : seqs) {
            length += seq.length;
            //判断数组第一位是否满足条件,有一点不明白这个判断条件为何不放入第二个循环进行判断，这么外层判断增加了理解难度
            if (seq.length >= 1 && (seq[0] < 0 || seq[0] > n)) {
                return false;
            }
            //开始构造图
            for (int i = 1; i < seq.length; i++) {    //如果不满足1 - n 的范围则返回false
                if (seq[i] > n || seq[i] < 0) {
                    return false;
                }

                // 构造图
                if (map.get(seq[i - 1]).add(seq[i])) {
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }

        //子字符串长度小于总长度返回false
        if (length < org.length) {
            return false;
        }

        //找出度为0 的节点

        Queue<Integer> zeroQueue = new ArrayDeque<>();

        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                zeroQueue.offer(key);
            }
        }

        int count = 0;

        //找出拓扑排序的路径
        while (zeroQueue.size() == 1) {
            int num = zeroQueue.poll();

            //删除该节点
            for (int number : map.get(num)) {
                indegree.put(number, indegree.get(number) - 1);
                if (indegree.get(number) == 0) {
                    zeroQueue.offer(number);
                }

                //如果两个数字不相等，则返回false
                if (org[count] != num) {
                    return false;
                }
            }
            count++;

        }


        return count == org.length;


    }
}
