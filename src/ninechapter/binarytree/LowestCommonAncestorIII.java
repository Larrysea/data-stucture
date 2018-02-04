package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

/**
 * 二叉树最近公共祖先，可以判断处理节点不在树种的情况
 *
 * @author
 * @create 2018-02-04 下午7:05
 **/
public class LowestCommonAncestorIII {

    //如果用分治法，分成几个步骤如何划分这道题
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode lonlyNode = new TreeNode(8);

//        lowestCommonAncestor3(root, root.right, root.left);

        lowestCommonAncestor3(root, root.right, lonlyNode);

    }


    /**
     * @param root The root of the binary tree.
     * @param A    and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        LowCommonAncestorResultType lowCommonAncestorResultType = findLowestCommonAncestor(root, A, B);
        //左右子树都存在的情况返回结果
        if (lowCommonAncestorResultType.bExist && lowCommonAncestorResultType.aExist) {
            return lowCommonAncestorResultType.treeNode;
        } else {
            //如果有一个节点不在此棵树上返回false
            return null;
        }
    }


    public static LowCommonAncestorResultType findLowestCommonAncestor(TreeNode treeNode, TreeNode a, TreeNode b) {
        if (treeNode == null) {
            return new LowCommonAncestorResultType(false, false, null);
        }

        LowCommonAncestorResultType leftCommonAncestorResultType = findLowestCommonAncestor(treeNode.left, a, b);

        LowCommonAncestorResultType rightCommonAncestorResultType = findLowestCommonAncestor(treeNode.right, a, b);

        //给a b的是否存在进行标记
        boolean aExist = leftCommonAncestorResultType.aExist || rightCommonAncestorResultType.aExist || treeNode == a;
        boolean bExist = leftCommonAncestorResultType.bExist || rightCommonAncestorResultType.bExist || treeNode == b;

        //如果当前节点就等于要查找的节点，则返回
        if (treeNode == a || treeNode == b) {
            return new LowCommonAncestorResultType(aExist, bExist, treeNode);
        }

        //两个节点分别位于左右两颗子树上
        if (leftCommonAncestorResultType.treeNode != null && rightCommonAncestorResultType.treeNode != null) {
            return new LowCommonAncestorResultType(aExist, bExist, treeNode);
        }

        //如果只存在左子树上
        if (leftCommonAncestorResultType.treeNode != null) {
            System.out.println(leftCommonAncestorResultType.treeNode.val + "root left" + treeNode.left.val);
            return new LowCommonAncestorResultType(aExist, bExist, leftCommonAncestorResultType.treeNode);
        }

        //如果只存在右子树上
        if (rightCommonAncestorResultType.treeNode != null) {
            System.out.println(rightCommonAncestorResultType.treeNode.val + "root right" + treeNode.right.val);
            return new LowCommonAncestorResultType(aExist, bExist, rightCommonAncestorResultType.treeNode);
        }

        //如果都不存在
        return new LowCommonAncestorResultType(aExist, bExist, null);
    }


}


class LowCommonAncestorResultType {

    //a节点是否存在
    boolean aExist;
    //b节点是否存在
    boolean bExist;
    //当前节点
    TreeNode treeNode;

    public LowCommonAncestorResultType(boolean aExist, boolean bExist, TreeNode treeNode) {
        this.aExist = aExist;
        this.bExist = bExist;
        this.treeNode = treeNode;
    }
}
