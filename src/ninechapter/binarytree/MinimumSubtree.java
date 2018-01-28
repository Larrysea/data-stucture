package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

/**
 * 和最小的二叉子树
 *
 * @author
 * @create 2018-01-28 上午12:08
 * <p>
 * <p>
 * 测试用例：
 * 1
 * /   \
 * -5    2
 * / \  /  \
 * 0 2  -4  -5
 **/


public class MinimumSubtree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);
        findMinimumSubtree(root);
        PrintUtil.print(findMinimumSubtree(root).minSum);
    }

    public static ResultType findMinimumSubtree(TreeNode root) {
        if (root == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }

        ResultType leftResultType = findMinimumSubtree(root.left);
        ResultType rightResultType = findMinimumSubtree(root.right);

        ResultType result = new ResultType(root,
                leftResultType.currentSum + rightResultType.currentSum + root.val,
                leftResultType.currentSum + rightResultType.currentSum + root.val);

        if (result.minSum >= leftResultType.minSum) {
            result.minSum = leftResultType.minSum;
            result.treeNode = leftResultType.treeNode;
        }

        if (result.minSum >= rightResultType.minSum) {
            result.minSum = rightResultType.minSum;
            result.treeNode = rightResultType.treeNode;
        }

        return result;

    }


    public TreeNode findSubtree(TreeNode root) {
        ResultType resultType = findMinimumSubtree(root);
        return resultType.treeNode;
    }


}


//查找的返回封装
class ResultType {
    TreeNode treeNode;
    int minSum;
    int currentSum;

    public ResultType(TreeNode treeNode, int minSum, int currentSum) {
        this.treeNode = treeNode;
        this.minSum = minSum;
        this.currentSum = currentSum;
    }


}

