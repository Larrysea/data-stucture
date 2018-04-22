package offer;

import data_stucture.PrintUtil;

import java.util.*;

/**
 * z 字形打印树
 *
 * @author
 * @create 2018-04-22 下午4:24
 **/
public class ZPrintTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        PrintUtil.print(Print(treeNode));
//        System.out.println(result.size());

        ninechapter.common_datastructure.TreeNode root = new ninechapter.common_datastructure.TreeNode(1);
        root.left = new ninechapter.common_datastructure.TreeNode(2);
        root.right = new ninechapter.common_datastructure.TreeNode(3);
        root.left.left = new ninechapter.common_datastructure.TreeNode(4);
        root.left.right = new ninechapter.common_datastructure.TreeNode(5);

    }

    //打印节点
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(pRoot);

        boolean isStartLeft = true;

        //对列是否为空
        while (!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<Integer> sonResult = new ArrayList<>();

            Stack<Integer> stack = new Stack<Integer>();
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (!isStartLeft) {
                    stack.push(node.val);
                } else {
                    sonResult.add(node.val);
                }
            }
            if (!isStartLeft) {
                printListToStack(stack, sonResult);
            }
            isStartLeft = !isStartLeft;
            result.add(sonResult);
        }
        return result;
    }


    private static void printListToStack(Stack<Integer> stack, List<Integer> list) {
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }


}
