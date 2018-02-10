package ninechapter.bfs;

import ninechapter.common_datastructure.UndirectedGraphNode;

import java.util.*;

/**
 * 克隆一个图
 *
 * @author
 * @create 2018-02-10 下午6:07
 **/
public class CloneGraph {

    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        //分为两步：第一步：1 克隆点   2  克隆边

        //首先通过宽搜，克隆点
        LinkedList<UndirectedGraphNode> nodeList = new LinkedList<>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> copyGraphMap = new HashMap<>();

        int start = 0;

        nodeList.add(node);
        copyGraphMap.put(node, new UndirectedGraphNode(node.label));

        //复制点
        while (start < nodeList.size()) {
            UndirectedGraphNode undirectedGraphNode = nodeList.get(start++);
            for (int i = 0; i < undirectedGraphNode.neighbors.size(); i++) {
                UndirectedGraphNode traverseNode = undirectedGraphNode.neighbors.get(i);
                if (!copyGraphMap.containsKey(traverseNode)) {
                    copyGraphMap.put(traverseNode, new UndirectedGraphNode(traverseNode.label));
                    nodeList.add(traverseNode);
                }
            }
        }

        //复制边
        for (int i = 0; i < nodeList.size(); i++) {
            UndirectedGraphNode copyNode = copyGraphMap.get(nodeList.get(i));
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                //copy graph 将原有图中的节点信息复制
                copyNode.neighbors.add(copyGraphMap.get(nodeList.get(i).neighbors.get(j)));
            }
        }

        return copyGraphMap.get(node);

    }


    public static void main(String[] args) {
        // 测试用例1 {0,1,2#1,2#2,2}
        UndirectedGraphNode node1 = new UndirectedGraphNode(0);

        ArrayList<UndirectedGraphNode> node1NeightBors = new ArrayList<>();
        node1NeightBors.add(new UndirectedGraphNode(1));
        node1NeightBors.add(new UndirectedGraphNode(2));

        node1.neighbors = node1NeightBors;

        UndirectedGraphNode node2 = new UndirectedGraphNode(1);

        ArrayList<UndirectedGraphNode> node2NeightBors = new ArrayList<>();

        node2NeightBors = new ArrayList<>();

        node2NeightBors.add(new UndirectedGraphNode(2));

        node2.neighbors = node2NeightBors;

        UndirectedGraphNode node3 = new UndirectedGraphNode(2);

        ArrayList<UndirectedGraphNode> node3NeighBors = new ArrayList<>();

        node3NeighBors.add(new UndirectedGraphNode(2));

        node3.neighbors = node3NeighBors;

        UndirectedGraphNode copyGraph = cloneGraph(node1);
        System.out.println(copyGraph);
    }

}
