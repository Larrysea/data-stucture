package ninechapter.binarytree;


import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @author
 * @create 2018-01-26 下午11:23
 **/
public class PreorderTraversal {
    /*
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> traversalResult = new ArrayList<Integer>();
        // write your code here
        traversal(traversalResult, root);
        return traversalResult;
    }


    public static void traversal(ArrayList<Integer> list, TreeNode treeNode) {
        if (treeNode != null) {
            list.add(treeNode.val);
        }
        if (treeNode != null && treeNode.left != null) {
            traversal(list, treeNode.left);
        }
        if (treeNode != null && treeNode.right != null) {
            traversal(list, treeNode.right);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        PrintUtil.printList(preorderTraversal(treeNode));

    }

}
