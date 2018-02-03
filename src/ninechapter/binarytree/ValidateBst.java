package ninechapter.binarytree;

import apple.laf.JRSUIUtils;
import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

import java.io.PipedReader;

/**
 * 验证是否是二叉搜索树
 *
 * @author
 * @create 2018-02-01 上午12:16
 **/
public class ValidateBst {


    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public static boolean isValidBST(TreeNode root) {
        // write your code here
        BstResultType bstResultType = validateBstHelper(root);
        return bstResultType.isBst;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(5);
//        PrintUtil.println(isValidBST(root) + "");

        TreeNode root1 = new TreeNode(-1);
//        PrintUtil.println(isValidBST(root1) + "");

        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
//        PrintUtil.println(isValidBST(treeNode) + "");

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(1);
//        PrintUtil.println(isValidBST(treeNode2) + "");

        TreeNode treeNode3 = new TreeNode(2147483647);
        PrintUtil.println(isValidBST(treeNode3) + "");


    }

    public static BstResultType validateBstHelper(TreeNode treeNode) {
        //左右子树为空的树是一颗平衡二叉树
        if (treeNode == null) {
            return new BstResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        //首先分治假设左右两边分别进行判断可以得出结果
        BstResultType leftBstResultType = validateBstHelper(treeNode.left);
        BstResultType rightBstResultType = validateBstHelper(treeNode.right);

        //如果有一棵子树不是平衡二叉树，这棵树既不是平衡二叉树，所以返回false
        if (!leftBstResultType.isBst || !rightBstResultType.isBst) {
            return new BstResultType(false, 0, 0);
        }
        //其次过滤不满足条件的二叉树，返回错误结果，满足二叉树搜索树的平衡条件
        if (treeNode.left != null && leftBstResultType.maxValue >= treeNode.val || treeNode.right != null && rightBstResultType.minValue <= treeNode.val) {
            return new BstResultType(false, 0, 0);
        }

        //最后过滤掉不满足结果的那最后就是构造满足条件的返回,为什么要有min 和max比较，相当于最小化和最大值得初始化

        return new BstResultType(true, Math.min(treeNode.val, leftBstResultType.minValue), Math.max(treeNode.val, rightBstResultType.maxValue));

    }


}


class BstResultType {
    boolean isBst;
    int maxValue;
    int minValue;

    BstResultType(boolean isBst, int minValue, int maxValue) {
        this.isBst = isBst;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
}
