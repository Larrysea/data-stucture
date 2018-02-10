package ninechapter.bfs;

import java.util.*;

/**
 * 鉴别一个图是否是二叉树
 *
 * @author
 * @create 2018-02-09 下午11:55
 **/
public class GraphValidTree {
    private static Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edges) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.put(i, new HashSet<>());
        }

        for (int j = 0; j < edges.length; j++) {
            int start = edges[j][0];
            int end = edges[j][1];
            result.get(start).add(end);
            result.get(end).add(start);
        }

        return result;
    }


    /* 判断一个图是否是一棵树条件是，节点数和边的关系是n+1=edges，且点与点之间是联通的，而不是独立的

     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public static boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0) {
            return false;
        }

        if (edges.length != n - 1) {
            return false;
        }
        //初始化一个图
        Map<Integer, Set<Integer>> result = initializeGraph(n, edges);
        //计算图中有多少个点

        //节点队列
        Queue<Integer> nodeQueue = new LinkedList<>();
        //点集合
        HashSet<Integer> nodeSet = new HashSet<>();

        nodeQueue.offer(0);
        nodeSet.add(0);

        //宽度搜索每一条边，检验连通性
        while (!nodeQueue.isEmpty()) {
            int key = nodeQueue.poll();
            for (Integer node : result.get(key)) {
                //如果点集合已经包含了该点则不用添加
                if (nodeSet.contains(node)) {
                    continue;
                }
                //添加点到点集合中
                nodeSet.add(node);
                //为队列中添加下一个遍历的点
                nodeQueue.offer(node);
            }

        }
        //如果最后点的数满足n，且边数目满足n-1，则该图是一棵树
        return (nodeSet.size() == n);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] testCase1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] testCase2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        int[][] testCase3 = {{0, 1}, {5, 6}, {6, 7}, {9, 0}, {3, 7}, {4, 8}, {1, 8}, {5, 2}, {5, 3}};
        Map<Integer, Set<Integer>> result = initializeGraph(5, testCase1);
        //最后形成的图为
        // 0-1,2，3；
        // 1-0，4
        // 2-0
        // 3-0
        // 4-1
        System.out.println(validTree(5, testCase1));
        System.out.println(validTree(5, testCase2));
        System.out.println(validTree(10, testCase3));


    }

}
