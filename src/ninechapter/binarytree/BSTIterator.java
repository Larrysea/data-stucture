package ninechapter.binarytree;

import common_datastucture.TreeNode;
import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树迭代器
 *
 * @author
 * @create 2018-04-01 上午12:29
 **/
public class BSTIterator {

    //思路，将二叉搜索树转换为对应链表，然后即可实现查找等方法
    public static void main(String[] args) {
        List<TreeNode> inOrderList = new ArrayList<>();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(11);
        root.right.right = new TreeNode(12);

        TreeNode root1 = new TreeNode(1);

        BSTIterator bstIterator = new BSTIterator(null);
        while (bstIterator.hasNext()) {
            PrintUtil.print(bstIterator.next().val);
        }

    }

    private void inOrderTraverse(TreeNode root, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrderTraverse(root.left, result);
        }
        result.add(root);
        if (root.right != null) {
            inOrderTraverse(root.right, result);
        }

    }


    List<TreeNode> inOrderList = new ArrayList<>();

    //该迭代器的当前节点下标
    int currentIndex = 0;


    /*
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        inOrderTraverse(root, inOrderList);

    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        if (currentIndex >= inOrderList.size() || inOrderList.size() == 0) {
            return false;
        }
        int index = inOrderList.indexOf(inOrderList.get(currentIndex));
        if (index == -1) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        //访问到数组最后一个节点了
        if (currentIndex == inOrderList.size()) {
            return null;
        }
        return inOrderList.get(currentIndex++);
    }
}
