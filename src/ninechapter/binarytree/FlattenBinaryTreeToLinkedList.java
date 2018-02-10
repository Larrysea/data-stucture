package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

/**
 * 将二叉树以前序比遍历的形式转换成为伪排序链表
 *
 * @author
 * @create 2018-02-03 下午11:31
 **/
public class FlattenBinaryTreeToLinkedList {


    /**
     * @param args
     */
    public static void main(String[] args) {
        flatten(initTestCase2());
//        flatten(initTestCase1());
    }


    public static TreeNode initTestCase1() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);

        treeNode.right = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);

        return treeNode;
    }


    public static TreeNode initTestCase2() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);

        treeNode.right = new TreeNode(5);

        treeNode.left.left = new TreeNode(3);

        treeNode.left.right = new TreeNode(4);

        return treeNode;
    }

    /*
     * @param root: a TreeNode, the root of the binary tree
     * @return:
     */
    public static void flatten(TreeNode root) {
        flattenToList(root);
    }


    /**
     * 获取转换成链表以后的最后一个节点
     *
     * @param root
     * @return
     */
    public static TreeNode flattenToList(TreeNode root) {
        if (root == null) {
            return null;
        }
        //分治
        TreeNode leftTreeNode = flattenToList(root.left);

        TreeNode rightTreeNode = flattenToList(root.right);

        //链接
        if (leftTreeNode != null) {
            leftTreeNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        //如果右边不为空则返回右边
        if (rightTreeNode != null) {
            return rightTreeNode;
        }

        //右子树的为空则返回左边
        if (leftTreeNode != null) {
            return leftTreeNode;
        }

        return root;
    }


}
