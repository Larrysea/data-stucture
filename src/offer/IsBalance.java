package offer;

import data_stucture.PrintUtil;

/**
 * 是否是平衡二叉树
 *
 * @author
 * @create 2018-04-22 上午12:09
 **/
public class IsBalance {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.right = new TreeNode(2);
        root.left = new TreeNode(3);

        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(5);
//        root.left.left = new TreeNode(6);

        PrintUtil.print(IsBalanced_Solution(root) + "");

    }


    public static boolean IsBalanced_Solution(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isBalance(root);
    }


    private static boolean isBalance(TreeNode root) {

        boolean isLeftBalance = true;
        boolean isRightBalance = true;
        if (root.left != null) {
            isLeftBalance = isBalance(root.left);
        }

        if (root.right != null) {
            isRightBalance = isBalance(root.right);
        }


        if (isLeftBalance && isRightBalance) {
            int leftHeight = getHeight(root.left);

            int rightHeight = getHeight(root.right);

            if (Math.abs(leftHeight - rightHeight) <= 1) {
                return true;
            }
        }

        return false;
    }


    private static int getHeight(TreeNode root) {
        int right = 0;

        int left = 0;

        if (root == null) {
            return 0;
        }

        if (root.left != null) {
            left = getHeight(root.left);
        }

        if (root.right != null) {
            right = getHeight(root.right);
        }

        return Math.max(left, right) + 1;
    }

}
