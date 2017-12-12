package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Larry-sea on 2017/3/28.
 * <p>
 * 遍历二叉树从二叉树顶部遍历到二叉树的底部
 */
public class PrintFromTopToBottom {

    /**
     * 从头打印一棵树
     *
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        treeNodeQueue.add(root);
        TreeNode tempTreeNode;
        if (root == null) {
            return arrayList;
        }
        while (treeNodeQueue.size() > 0) {
            tempTreeNode = treeNodeQueue.poll();
            arrayList.add(tempTreeNode.val);
            System.out.println(tempTreeNode.val);

            if (tempTreeNode.left != null) {
                treeNodeQueue.add(tempTreeNode.left);
            }

            if (tempTreeNode.right != null) {
                treeNodeQueue.add(tempTreeNode.right);
            }

        }
        return arrayList;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        PrintFromTopToBottom(treeNode);

    }

}
