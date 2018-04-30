package offer;

import data_stucture.PrintUtil;

/**
 * 二叉树转双链表
 *
 * @author
 * @create 2018-04-25 下午11:13
 **/
public class BinaryTreeToDoubleLinkedList {

    public static void main(String[] args) {
        TreeNode leftTree = new TreeNode(6);
        leftTree.left = new TreeNode(4);
        leftTree.right = new TreeNode(8);
        TreeNode rightTree = new TreeNode(14);
        rightTree.left = new TreeNode(12);
        rightTree.right = new TreeNode(16);
        TreeNode root = new TreeNode(10);
        root.left = leftTree;
        root.right = rightTree;
        TreeNode lastNode = Convert(root);
        PrintUtil.print(lastNode.val);

    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode[] treeNode = new TreeNode[1];

        convertNode(pRootOfTree, treeNode);

        TreeNode head = treeNode[0];

        while (head != null && head.left != null) {
            head = head.left;
        }

        return head;
    }


    private static void convertNode(TreeNode root, TreeNode[] lastNode) {
        if (root != null) {

            if (root.left != null) {
                convertNode(root.left, lastNode);
            }

            root.left = lastNode[0];

            if (lastNode[0] != null) {
                lastNode[0].right = root;
            }

            lastNode[0] = root;

            if (root.right != null) {
                convertNode(root.right, lastNode);
            }
        }


    }
}
