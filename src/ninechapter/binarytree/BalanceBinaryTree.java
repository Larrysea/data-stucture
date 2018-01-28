package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

/**
 * 平衡二叉树判断
 *
 * @author
 * @create 2018-01-28 下午10:05
 **/
public class BalanceBinaryTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        PrintUtil.print(isBalanced(treeNode) + "");

    }

    public static boolean isBalanced(TreeNode root) {
        BalanceResultType balanceResultType = balance(root);
        PrintUtil.print(balanceResultType.maxDepth);
        return balanceResultType.isBalanced;
    }


    public static BalanceResultType balance(TreeNode root) {
        //根节点为空不是平衡二叉树
        if (root == null) {
            return new BalanceResultType(-1, true);
        }

        BalanceResultType leftBalanceResultType = balance(root.left);

        BalanceResultType rightBalanceResultType = balance(root.right);

        if (!leftBalanceResultType.isBalanced || !rightBalanceResultType.isBalanced) {
            return new BalanceResultType(-1, false);
        }

        //判断根节点是否平衡
        if (Math.abs(leftBalanceResultType.maxDepth - rightBalanceResultType.maxDepth) > 1) {
            return new BalanceResultType(-1, false);
        }

        return new BalanceResultType(Math.max(leftBalanceResultType.maxDepth, rightBalanceResultType.maxDepth) + 1, true);


    }


}


/**
 * 二叉树是否平衡的结果
 */
class BalanceResultType {
    int maxDepth;

    boolean isBalanced;

    public BalanceResultType(int maxDepth, boolean isBalanced) {
        this.maxDepth = maxDepth;
        this.isBalanced = isBalanced;
    }


}




