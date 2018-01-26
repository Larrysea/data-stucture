package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 中序遍历
 *
 * @author
 * @create 2018-01-26 下午11:43
 **/
public class InOrderTraversal {
    /*
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        inorderTraversal(result, root);
        PrintUtil.printList(result);
        return result;
    }

    /**
     * 中序遍历
     */
    public static void inorderTraversal(List<Integer> inorderResult, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversal(inorderResult, root.left);
        }
        inorderResult.add(root.val);
        if (root.right != null) {
            inorderTraversal(inorderResult, root.right);
        }
    }


    public static void main(String [] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        inorderTraversal(treeNode);
    }


}


