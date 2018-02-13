package ninechapter.bfs;

import ninechapter.common_datastructure.DirectedGraphNode;

import java.util.*;

/**
 * 拓扑排序
 * <p>
 * 拓扑排序算法，满足条件，图中必不存在环，且需满足顺序
 * <p>
 * 拓扑排序算法，
 * 1  找出入度为0的点
 *
 * 2  然后入度为0的点从图中删除掉，并将其添加到拓扑排序结果中
 *
 * 3  然后再继续找入度为0的点
 *
 * 4  依次重复1-3步骤，直至图中的点全部删除完毕，此时得到的序列就是一个拓扑排序
 *
 * @author
 * @create 2018-02-13 下午2:17
 **/
public class TopologySort {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        if (graph == null || graph.size() == 0) {
            return null;
        }

        //保存点的入度信息
        HashMap<DirectedGraphNode, Integer> nodeHashmap = new HashMap<>();
        //存放入度为0的节点
        Queue<DirectedGraphNode> zeroInDegressNodeQueue = new LinkedList<>();
        //存放结果集
        ArrayList<DirectedGraphNode> result = new ArrayList<>();

        //首先统计所有点的入度
        for (DirectedGraphNode directedGraphNode : graph) {
            for (DirectedGraphNode neighbors : directedGraphNode.neighbors) {
                //如果已经包含该点
                if (nodeHashmap.containsKey(neighbors)) {
                    nodeHashmap.put(neighbors, nodeHashmap.get(neighbors) + 1);
                }
                //未遍历过改该点，初始化入度为1
                else {
                    nodeHashmap.put(neighbors, 1);
                }
            }
        }

        //寻找入度为0的点
        for (DirectedGraphNode directedGraphNode : graph) {
            //该点从未遍历过，代表改点入度为0，所以是拓扑排序的第一个节点
            if (!nodeHashmap.containsKey(directedGraphNode)) {
                zeroInDegressNodeQueue.add(directedGraphNode);
                result.add(directedGraphNode);
            }
        }

        //开始循环删除入度为0的点
        while (!zeroInDegressNodeQueue.isEmpty()) {
            for (DirectedGraphNode neighbors : zeroInDegressNodeQueue.poll().neighbors) {
                //删除该边，等同于把入度减1
                nodeHashmap.put(neighbors, nodeHashmap.get(neighbors) - 1);
                //如果该点入度为0，则添加到对列中
                if (nodeHashmap.get(neighbors) == 0) {
                    zeroInDegressNodeQueue.add(neighbors);
                    result.add(neighbors);
                }
            }
        }

        return result;
    }



}
