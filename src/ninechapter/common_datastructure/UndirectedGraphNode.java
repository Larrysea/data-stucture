package ninechapter.common_datastructure;

import java.util.ArrayList;

/**
 * 无向图节点
 *
 * @author
 * @create 2018-02-10 下午6:08
 **/
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }

}
