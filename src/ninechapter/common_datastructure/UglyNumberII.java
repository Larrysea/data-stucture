package ninechapter.common_datastructure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找出第n位丑数
 *
 * @author
 * @create 2018-04-11 上午1:22
 **/
public class UglyNumberII {


    public int nthUglyNumber(int n) {
        // write your code here
        HashSet<Integer> uglySet = new HashSet<>();

        Queue<Integer> queue = new PriorityQueue<>();
        Integer[] array = {2, 3, 5};
        for (int i = 0; i < 3; i++) {
            uglySet.add(array[i]);
            queue.offer(array[i]);
        }

        Integer number = 1;

        for (int i = 1; i < n; i++) {
            number = queue.poll();
            for (int j = 0; j < 3; j++) {
                if (!uglySet.contains(number * array[j])) {
                    uglySet.add(number * array[j]);
                    queue.offer(number * array[j]);
                }
            }
        }

        return number;
    }
}
