package ninechapter.bfs;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * 计算单词阶梯最短长度
 *
 * @author
 * @create 2018-03-30 上午12:40
 * <p>
 * 首先题意分析可得求单词变化的最短长度，求最短就是bfs，求所有可能是dfs
 **/
public class WorderLadderLength {


    public static void main(String[] args) {
        String[] dictArray = {"hot", "dot", "dog", "lot", "log"};

        Set<String> dict = new LinkedHashSet<>();
        for (int i = 0; i < dictArray.length; i++) {
            dict.add(dictArray[i]);
        }
        dict.add("b");

        PrintUtil.print(ladderLength("hit", "cog", dict));
    }


    public static int ladderLength(String start, String end, Set<String> dict) {

        if (start == null || end == null || dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        Queue<String> queue = new LinkedList<>();

        HashSet<String> hashSet = new LinkedHashSet<>();
        queue.offer(start);

        int level = 1;

        //如果队列不为空
        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            level++;
            //宽搜的第队列遍历
            for (int index = 0; index < queueSize; index++) {
                String next = queue.poll();
                for (int i = 0; i < next.length(); i++) {
                    StringBuilder sb = new StringBuilder(next);
                    for (char j = 'a'; j < 'z'; j++) {
                        sb.setCharAt(i, j);
                        String temp = sb.toString();
                        if (temp.equals(end)) {
                            return level;
                        }

                        //如果包含改字符串或者是字典中不包含改字符则跳过
                        if (hashSet.contains(temp) || !dict.contains(temp)) {
                            continue;
                        }
                        queue.offer(temp);
                        hashSet.add(temp);

                    }
                }
            }
        }
        return 0;
    }

}
