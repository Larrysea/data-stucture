package offer;

/**
 * 判断二叉树是否对称
 *
 * @author
 * @create 2018-04-30 下午3:53
 **/
public class isSymmetrical {

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    private boolean isSymmetrical(TreeNode rightNode, TreeNode leftNode) {
        //如果左右都为空代表相等
        if (rightNode == null && leftNode == null) {
            return true;
        }

        //如果只有一个为空，代表不相等
        if (rightNode == null || leftNode == null) {
            return false;
        }

        //判断都有值得情况两个值是否相等
        if (rightNode.val != leftNode.val) {
            return false;
        }

        //分别判断最左边和最右边是否相等还有中间两个分支是否相等
        return isSymmetrical(rightNode.right, leftNode.left) && isSymmetrical(rightNode.left,leftNode.right);
    }

}
