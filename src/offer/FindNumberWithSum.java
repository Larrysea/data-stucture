package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出和我sum的两个数
 *
 * @author
 * @create 2018-04-20 上午12:51
 **/
public class FindNumberWithSum {




    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        int start = 0;
        int end = array.length - 1;

        int minMultiple = Integer.MAX_VALUE;

        ArrayList<Integer> result = new ArrayList<>();
        while (start < end) {
            if (array[start] + array[end] > sum) {
                end--;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                int multiPle = array[start] * array[end];
                if (multiPle < minMultiple) {
                    minMultiple = multiPle;
                    result.add(array[start]);
                    result.add(array[end]);
                }
                start++;
                end--;
            }
        }

        return result;

    }
}
