package offer;

import data_stucture.PrintUtil;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找出第n个丑数
 *
 * @author
 * @create 2018-04-18 下午11:26
 **/
public class UglyNumber {


    public static void main(String[] args) {

        PrintUtil.print(GetUglyNumber_Solution(7));
    }

    public static int GetUglyNumber_Solution(int index) {
        int result = 1;
        HashSet<Integer> numberSet = new HashSet<>();
        int[] uglyArray = {2, 3, 5};
        int count = 1;
        Queue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < 3; i++) {
            numberSet.add(uglyArray[i]);
            priorityQueue.add(uglyArray[i]);
        }

        int number = 1;
        for (int j = 1; j < index; j++) {
            number = priorityQueue.poll();
            for (int i = 0; i < 3; i++) {
                if (!numberSet.contains(number * uglyArray[i])) {
                    numberSet.add(number * uglyArray[i]);
                    priorityQueue.add(number * uglyArray[i]);
                }
            }
        }
        return number;
    }


}
