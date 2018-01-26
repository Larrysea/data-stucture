package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

/**
 * 最大树深度
 *
 * @author
 * @create 2018-01-27 上午12:25
 **/
public class MaxDepth {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        PrintUtil.print(maxDepth(treeNode));

    }


    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }

    public static void count(int depth, TreeNode root) {
        if (root != null) {
            depth++;
        }
        if (root != null && root.left != null) {
            count(depth, root.left);
            System.out.println(depth);

        }
        if (root != null && root.right != null) {
            count(depth, root.right);
            System.out.println(depth);

        }
    }


}
