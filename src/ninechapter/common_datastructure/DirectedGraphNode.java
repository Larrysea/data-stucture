package ninechapter.common_datastructure;

import java.util.ArrayList;

/**
 * 有向图节点
 *
 * @author
 * @create 2018-02-13 下午2:18
 **/
public class DirectedGraphNode {

    public int label;
    public ArrayList<DirectedGraphNode> neighbors;

    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<ninechapter.common_datastructure.DirectedGraphNode>();
    }
}