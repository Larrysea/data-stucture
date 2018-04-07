package ninechapter.common_datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 滑动窗口平均数
 *
 * @author
 * @create 2018-04-08 上午1:04
 **/
public class MovingAverage {


    public static void main(String[] args) {

    }

    private int maxSize = 0;

    /*
     * @param size: An integer
     */
    public MovingAverage(int size) {
        // do intialization if necessary
        maxSize = size;
        queue = new LinkedList<Integer>();

    }

    List<Integer> queue = null;

    private double sum = 0;

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        if (queue.size() == maxSize) {
            int removeNumber = queue.remove(0);
            sum -= removeNumber;
        }
        queue.add(val);
        sum += val;
        return (double)sum / queue.size();
    }
}
