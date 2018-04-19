package offer;

/**
 * 计算二叉树的高度
 *
 * @author
 * @create 2018-04-20 上午12:20
 **/
public class DepthOfTree {


    //通过bfs按层遍历找出最长的长度，或者就是普通的遍历方法，到叶子节点
    public int TreeDepth(TreeNode root) {
        //计算树的深度
        int depth = 0;
        helper(root, depth);
        return maxDepth;
    }

    int maxDepth = 0;

    private int helper(TreeNode root, int depth) {
        if (root == null) {
            return 0;
        }

        int leftDepth = helper(root, depth);
        int rightDepth = helper(root, depth);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
