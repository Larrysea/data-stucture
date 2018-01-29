package ninechapter.binarytree;

import apple.laf.JRSUIUtils;
import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

/**
 * 最大平均值子树
 *
 * @author
 * @create 2018-01-28 下午11:38
 * <p>
 * <p>
 * <p>
 * 1
 * /   \
 * -5     11
 * / \   /  \
 * 1  2 4    -2
 **/
public class SubtreeWithMaximumAverage {

    //全局的返回结果
    static MaxmimumResultType mMaxmimumResultType;

    //最大根节点
    static TreeNode mTreeNode;


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-5);
        treeNode.right = new TreeNode(11);

        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(2);

        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(-2);
        PrintUtil.print(findSubtree2(treeNode).val + "");


        TreeNode root = new TreeNode(10);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        root.left = new TreeNode(3);
//        PrintUtil.print(findSubtree2(root).val + "");


    }


    /*
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public static TreeNode findSubtree2(TreeNode root) {
        MaxmimumResultType maxmimumResultType = helper(root);
        return mTreeNode;
    }

    public static MaxmimumResultType helper(TreeNode treeNode) {
        if (treeNode == null) {
            return new MaxmimumResultType(0, 0);
        }

        MaxmimumResultType leftResultType = helper(treeNode.left);

        MaxmimumResultType rightResultType = helper(treeNode.right);

        MaxmimumResultType maxmimumResultType = new MaxmimumResultType(leftResultType.count + rightResultType.count + 1,
                leftResultType.sum + rightResultType.sum + treeNode.val);

        //如果这来改成除法比较平均数会有问题，经过迭代除法，会造成一定的总和减小的问题?  除了这个原因以外还有什么原因。
        if (mTreeNode == null || (maxmimumResultType.sum * maxmimumResultType.count) > (mMaxmimumResultType.sum * maxmimumResultType.count)) {
            if (mTreeNode != null) {
                System.out.println("大小值比较" + maxmimumResultType.sum * maxmimumResultType.count + "   " + mMaxmimumResultType.sum * maxmimumResultType.count);
            }

            mMaxmimumResultType = maxmimumResultType;
            mTreeNode = treeNode;
        }

        return maxmimumResultType;

    }


}


class MaxmimumResultType {


    //和值
    int sum;

    //有多少个数
    int count;

    public MaxmimumResultType(int count, int sum) {
        this.count = count;
        this.sum = sum;

    }
}

