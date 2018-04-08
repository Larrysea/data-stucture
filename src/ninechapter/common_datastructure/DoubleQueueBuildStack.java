package ninechapter.common_datastructure;

import data_stucture.PrintUtil;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列构成栈
 *
 * 结题思路：栈是上进上出，队列与之相反，但是两个队列即可抵消呈现相反的效果，最终实现像队列一样，可以上进上出
 * @author
 * @create 2018-04-08 上午1:37
 **/
public class DoubleQueueBuildStack {

    public static void main(String[] args) {

        push(1);
        push(2);

        pop();
        PrintUtil.print(isEmpty() + ""); // return false
        PrintUtil.print(top()); // return 2
        top();
        PrintUtil.print(isEmpty() + "" + top()); // re
        push(3);
        top();
        PrintUtil.print(isEmpty() + "" + top()); // re

    }

    static Queue<Integer> queue1 = new LinkedList<Integer>();
    static Queue<Integer> queue2 = new LinkedList<Integer>();

    /*
     * @param x: An integer
     * @return: nothing
     */
    public static void push(int x) {
        //如果当前的栈为空，则优先放在第一个对列中
        if (isEmpty()) {
            queue1.offer(x);
        }
        //如果栈中已经有数据，则判断哪个队列不为空，则继续放入该不为空的队列中
        else {
            if (queue1.size() != 0) {
                queue1.offer(x);
            } else {
                queue2.offer(x);
            }
        }

    }

    /*
     * @return: nothing
     */
    public static void pop() {
        if (queue2.size() == 0) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            if (queue1.size() == 1) {
                queue1.poll();
            }
        } else if (queue1.size() == 0) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            if (queue2.size() == 1) {
                queue2.poll();
            }
        }


    }

    /*
     * @return: An integer
     */
    public static int top() {
        if (queue2.size() == 0) {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            if (queue1.size() == 1) {
                int val = queue1.poll();
                queue2.offer(val);
                return val;
            }
        } else if (queue1.size() == 0) {
            while (queue2.size() > 1) {
                queue1.offer(queue2.poll());
            }
            if (queue2.size() == 1) {
                int val = queue2.poll();
                queue1.offer(val);
                return val;
            }
        }
        return -1;
    }

    /*
     * @return: True if the stack is empty
     */
    public static boolean isEmpty() {
        // write your code here
        if (queue1.size() == 0 && queue2.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
