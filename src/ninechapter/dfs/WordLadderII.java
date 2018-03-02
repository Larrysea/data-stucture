package ninechapter.dfs;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * 词汇阶梯，这道题目是bfs和dfs相结合的题目目前还没有完全理解，需要花时间把这道题搞懂。
 *
 * @author
 * @create 2018-03-2 00：16
 **/
public class WordLadderII {


    public static void main(String[] args) {
        String[] strings = {"hot", "dot", "dog", "lot", "log"};
        Set<String> dict = new LinkedHashSet<>();
        for (String word : strings) {
            dict.add(word);
        }
        String start = "hit";
        String end = "cog";
        PrintUtil.printStringListList(findLadders(start, end, dict));
//        PrintUtil.printStringList(expand(start, dict));
    }


    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here

        List<List<String>> result = new ArrayList<List<String>>();

        List<String> path = new ArrayList<String>();

        Map<String, Integer> distance = new HashMap<>();

        Map<String, List<String>> neighborMap = new HashMap<>();

        dict.add(start);
        dict.add(end);

        bfs(neighborMap, distance, start, dict);

        dfs(result, path, distance, neighborMap, start, end);

        return result;

    }


    //通过dfs来寻找路径
    //reuslt参数是所有最短的路径
    //path是现在所走的路径，通过dsf搜索从终点到起点的路径
    private static void dfs(List<List<String>> result, List<String> path,
                            Map<String, Integer> distance, Map<String, List<String>> neighborMap,
                            String start, String end) {
        path.add(end);

        //如果已经找到终点则添加到结果中去
        if (end.equals(start)) {
            Collections.reverse(path);
            result.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            //通过map进行深搜
            for (String next : neighborMap.get(end)) {
                //代表该点事从终点出去的一个点
                if (distance.containsKey(next) && distance.get(next) + 1 == distance.get(end)) {
                    //注意参数顺序不要搞错
                    dfs(result, path, distance, neighborMap, start, next);
                }
            }

        }
        path.remove(path.size() - 1);
    }

    //通过bfs来计算距离，通过bfs计算出来的是最短距离
    private static void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();

        queue.offer(start);

        distance.put(start, 0);

        //创建每个可以通过变形得到的hashMap
        for (String word : dict) {
            map.put(word, new ArrayList<String>());
        }

        while (!queue.isEmpty()) {
            String startPoint = queue.poll();

            List<String> expandList = expand(startPoint, dict);

            for (String next : expandList) {
                map.get(next).add(startPoint);

                //计算距离
                if (!distance.containsKey(next)) {
                    //计算距离
                    distance.put(next, distance.get(startPoint) + 1);
                    queue.offer(next);

                }

            }

        }

    }


    //计算该词可以通过一个变化得到词典中单词的结果集
    private static List<String> expand(String sourceStr, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        for (String word : dict) {
            if (isCanArrive(sourceStr, word)) {
                result.add(word);
            }
        }
        return result;

    }


    //判断是否是可以通过一个字母变化得到
    public static boolean isCanArrive(String src, String goal) {
        if (goal == null || src == null) {
            return false;
        }
        //如果自身点和目标点一直则返回false
        if (src.equals(goal)) {
            return false;
        }

        //统计两个单词不一样的部分长度
        int differenceCount = 0;
        if (goal.length() == src.length()) {
            for (int i = 0; i < src.length(); i++) {
                if (src.charAt(i) != goal.charAt(i)) {
                    differenceCount++;
                    if (differenceCount > 1) {
                        return false;
                    }
                }

            }
        }
        return true;
    }




}
