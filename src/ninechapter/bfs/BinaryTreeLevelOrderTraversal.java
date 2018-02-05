package ninechapter.bfs;

import ninechapter.common_datastructure.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 二叉树按层遍历
 *
 * @author
 * @create 2018-02-05 下午10:55
 **/
public class BinaryTreeLevelOrderTraversal {

    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> nodeStack = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        nodeStack.add(root);

        TreeNode node = null;
        List<Integer> list = null;
        //将树的每个节点放在栈中
        while (!nodeStack.isEmpty()) {
            int stackSize = nodeStack.size();
            list = new ArrayList<>();
            //层级的长度遍历
            for (int index = 0; index < stackSize; index++) {
                node = nodeStack.poll();
                list.add(node.val);

                if (node.left != null) {
                    nodeStack.add(node.left);
                }
                if (node.right != null) {
                    nodeStack.add(node.right);
                }

            }
            //将层级遍历的结果添加到返回集中
            result.add(list);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> result = levelOrder(treeNode);
        System.out.println(result.size());

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> result1 = levelOrder(root);
        System.out.println(result1.size());


    }


}
