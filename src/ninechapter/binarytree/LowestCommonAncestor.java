package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

/**
 * 二叉树最近公共节点
 *
 * @author
 * @create 2018-01-30 上午12:20
 **/
public class LowestCommonAncestor {
    //如果用分治法，分成几个步骤如何划分这道题
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        PrintUtil.print(lowestCommonAncestor(root, root.right.left, root.right.right).val);

    }

    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }


        if (left != null) {
            return left;
        }


        if (right != null) {
            return right;
        }

        return null;
    }

}
