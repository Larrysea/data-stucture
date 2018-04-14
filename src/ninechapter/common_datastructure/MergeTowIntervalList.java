package ninechapter.common_datastructure;


import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个间隔数组
 *
 * @author
 * @create 2018-04-14 下午6:48
 **/
public class MergeTowIntervalList {



    /**
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public static List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here

        List<Interval> result = new ArrayList<Interval>();

        if (list1.size() == 0 && list2.size() == 0) {
            return result;
        }
        //和合并两个数组并无二致，但是会更更新每个数的最新下标

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).start < list2.get(j).start) {
                mergeInterval(result, list1.get(i++));
            } else {
                mergeInterval(result, list2.get(j++));
            }
        }

        while (i < list1.size()) {
            mergeInterval(result, list1.get(i++));
        }

        while (j < list2.size()) {
            mergeInterval(result, list2.get(j++));
        }

        return result;
    }


    public static void mergeInterval(List<Interval> result, Interval interval) {
        if (result.size() == 0) {
            result.add(interval);
        }

        Interval temp = result.get(result.size() - 1);

        if (interval.start > temp.end) {
            result.add(interval);
        } else {
            temp.end = Math.max(temp.end, interval.end);
        }
    }


    static class Interval {
        int start, end;

        Interval(int start, int end) {

            this.start = start;
            this.end = end;
        }
    }
}
