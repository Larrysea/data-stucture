package ninechapter.bfs;

import ninechapter.common_datastructure.UndirectedGraphNode;

import java.awt.geom.RoundRectangle2D;
import java.util.*;

/**
 * 在图中搜索值为target并且离搜索点最近的节点
 *
 * @author
 * @create 2018-02-10 下午10:12
 **/
public class SearchGraphNode {

    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        //如果搜索点中没有target值则直接返回null
        if (!values.containsValue(target)) {
            return null;
        }
        //如果该图中没有该点
        if (!graph.contains(node)) {
            return null;
        }

        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);

        HashSet<UndirectedGraphNode> nodeSet = new HashSet<>();
        nodeSet.add(node);

        while (!nodeQueue.isEmpty()) {
            UndirectedGraphNode headNode = nodeQueue.poll();
            if (values.get(headNode) == target) {
                return headNode;
            }
            for (int i = 0; i < headNode.neighbors.size(); i++) {
                if (!nodeSet.contains(headNode.neighbors.get(i))) {
                    nodeSet.add(headNode.neighbors.get(i));
                    nodeQueue.add(headNode.neighbors.get(i));
                }
            }
        }
        return null;

    }


    public static void main(String[] args) {

    }


    private void initTestCase1() {

//        {1,2,3,4#2,1,3#3,1#4,1,5#5,4}
//        [3,4,5,50,50]
//        1
//        50


    }


}
