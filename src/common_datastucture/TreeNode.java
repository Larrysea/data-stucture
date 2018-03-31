package common_datastucture;

/**
 * Created by Larry-sea on 2017/1/26.
 * <p>
 * 二叉树的节点
 */
public class TreeNode {

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public  TreeNode left;    //左子树

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode right;   //右子树

    public int getVal() {
        return val;
    }

    public int val;          //树的值
    public TreeNode(int value) {
        this.val = value;
    }

}
