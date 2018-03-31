package ninechapter.binarytree;

import common_datastucture.TreeNode;
import data_stucture.PrintUtil;

/**
 * 最小的第k个数
 *
 * @author
 * @create 2018-03-31 下午1:15
 **/
public class KthSmallestElement {


    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.right = new TreeNode(2);
//        PrintUtil.print(kthSmallest(rootNode, 2));
        //测试极端条件，左右子树都没有的，只有左子树，只有右子树
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        PrintUtil.print(kthSmallest(root1, 3));
//        PrintUtil.print(kthSmallest(root1, 1));
    }


    static int mK = 0;

    static int result = -1;


    /**
     * @param root: the given BST
     * @param k:    the given k
     * @return: the kth smallest element in BST
     */
    public static int kthSmallest(TreeNode root, int k) {
        // write your code here

        preTraverse(root, k);

        if (result != -1) {
            return result;
        }
        return -1;

    }

    //通过中序遍历进行查找就相当于一次排序，如果计数到了第k就返回改值
    private static void preTraverse(TreeNode root, int k) {

        if (root.left != null) {
            preTraverse(root.left, k);
        }
        mK++;
        if (mK == k) {
            result = root.val;
        }
        if (root.right != null) {
            preTraverse(root.right, k);
        }
    }
}
