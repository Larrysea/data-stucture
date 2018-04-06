package ninechapter.dfs;

import data_stucture.PrintUtil;
import sun.rmi.server.InactiveGroupException;

import java.util.*;

/**
 * 找出最靠近的时间
 *
 * @author
 * @create 2018-04-06 上午12:13
 **/
public class FindClosetTime {

    public static void main(String[] args) {

        String time = "21:19";

        PrintUtil.print(nextClosestTime(time));

    }


    private static String result = "";

    private static int minimumDiff = Integer.MAX_VALUE;

    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public static String nextClosestTime(String time) {
        // write your code here

        //解题思路，是通过将时间转化为分钟数，这样让时间更加好比价，如果大于代表是下一天，则在加上一天的分钟数即可，如何去重和去除无效的数，在dfs的时候通过每一位的判断进行去重

        int h = Integer.valueOf(time.substring(0, 2));
        int m = Integer.valueOf(time.substring(3, 5));

        Set<Integer> digitSet = new HashSet<>();

        digitSet.add(Integer.valueOf(time.substring(0, 1)));
        digitSet.add(Integer.valueOf(time.substring(1, 2)));
        digitSet.add(Integer.valueOf(time.substring(3, 4)));
        digitSet.add(Integer.valueOf(time.substring(4, 5)));

        List<Integer> digitList = new ArrayList<>(digitSet);
        int minute = h * 60 + m;
        helper(digitList, minute, "", 0);
        return result;
    }


    private static void helper(List<Integer> digitSet, int time, String nextTime, int position) {
        // 开始比较结果是否和
        if (position == 4) {
            PrintUtil.println(nextTime);
            int nextTimeInt = Integer.valueOf(nextTime.substring(0, 2)) * 60 + Integer.valueOf(nextTime.substring(2, 4));
            //如果当前时间大于，则代表是同一天，则差值就是直接相减的结果，如果当前时间小于则代表是第二天的某个时间段，则需要加上一天的日期
            int diff = nextTimeInt - time > 0 ? nextTimeInt - time : 1440 + nextTimeInt - time;
            //如果小于最小的时间
            if (diff < minimumDiff) {
                minimumDiff = diff;
                result = nextTime.substring(0, 2) + ":" + nextTime.substring(2, 4);
            }
            return;
        }




        for (int i = 0; i < digitSet.size(); i++) {
            //判断首位是否大于2
            if (position == 0 && digitSet.get(i) > 2) {
                continue;
            }

            //判断小时是否大于23
            if (position == 1 && Integer.valueOf(nextTime) * 10 + digitSet.get(i) > 23) {
                continue;
            }

            //判断第一个分钟是否大于5
            if (position == 2 && digitSet.get(i) > 5) {
                continue;
            }

            //判断分钟是否大于59
            if (position == 3 && Integer.valueOf(nextTime.substring(2)) * 10 + digitSet.get(i) > 59) {
                continue;
            }
            helper(digitSet, time, nextTime + digitSet.get(i), position + 1);
        }
    }


}
