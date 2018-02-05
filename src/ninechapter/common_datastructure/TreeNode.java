package ninechapter.common_datastructure;

/**
 * 树的节点
 *
 * @author
 * @create 2018-01-26 下午11:25
 **/


public class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}