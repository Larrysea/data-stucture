package offer;

import data_stucture.PrintUtil;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 最大窗口问题
 *
 * @author
 * @create 2018-04-21 下午12:15
 **/
public class MaxWindow {

    public static void main(String[] args) {
        int[] testCase1 = {2, 3, 4, 2, 6, 2, 5, 1};
        PrintUtil.printList(maxInWindows(testCase1, 0));
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {

        Deque<Integer> deque = new LinkedList<>();

        if (num == null || num.length == 0 || size == 0) {
            return new ArrayList<>();
        }

        if (size > num.length) {
            return new ArrayList<>();
        }

        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && num[deque.peekLast()] <= num[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        ArrayList<Integer> result = new ArrayList<>();


        for (int i = size; i < num.length; ++i) {
            result.add(num[deque.peekFirst()]);

            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {
                deque.pollLast();
            }

            if (!deque.isEmpty() && deque.peekFirst() <= (i - size)) {
                deque.pollFirst();
            }

            deque.offerLast(i);
        }

        result.add(num[deque.peekFirst()]);

        return result;
    }
}
