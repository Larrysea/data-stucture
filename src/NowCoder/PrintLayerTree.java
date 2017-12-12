package NowCoder;

import common_datastucture.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Larry-sea on 2017/11/23.
 * <p>
 * 按层打印二叉树
 */
public class PrintLayerTree {


    public static void main(String[] args) {
//        printTreeLayer(initTreeNode());
        int array[][] = printTree(initTreeNode());
        for (int index = 0; index < array.length; index++) {
            for (int column = 0; column < array[index].length; column++) {
                System.out.print(array[index][column]);
            }
            System.out.println("");

        }
    }


    public static void printTreeLayer(TreeNode treeNode) {
        Queue<TreeNode> treeQueue = new LinkedList<>();
        int curCount = 1;
        int nextLevelCount = 0;
        treeQueue.add(treeNode);
        while (!treeQueue.isEmpty()) {
            TreeNode son = treeQueue.peek();
            if (son.getLeft() != null) {
                treeQueue.add(son.getLeft());
                nextLevelCount++;
            }
            if (son.getRight() != null) {
                treeQueue.add(son.getRight());
                nextLevelCount++;
            }

            TreeNode printNode = treeQueue.poll();
            curCount--;
            System.out.print(printNode.getVal() + " ");

            if (curCount == 0) {
                System.out.print("\n");
                curCount = nextLevelCount;
                nextLevelCount = 0;
            }

        }
    }


    public static int[][] printTree(TreeNode treeNode) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        Queue<TreeNode> treeQueue = new LinkedList<>();
        ArrayList<Integer> columnList = null;
        int curCount = 1;
        int nextLevelCount = 0;
        treeQueue.add(treeNode);
        while (!treeQueue.isEmpty()) {
            TreeNode son = treeQueue.peek();
            if (son.getLeft() != null) {
                treeQueue.add(son.getLeft());
                nextLevelCount++;
            }
            if (son.getRight() != null) {
                treeQueue.add(son.getRight());
                nextLevelCount++;
            }

            TreeNode printNode = treeQueue.poll();
            curCount--;
            if (columnList == null) {
                columnList = new ArrayList<>();
            }
            columnList.add(printNode.getVal());
            if (curCount == 0) {
                System.out.print("\n");
                curCount = nextLevelCount;
                nextLevelCount = 0;
                arrayList.add(columnList);
                columnList = new ArrayList<>();
            }

        }
        int array[][] = new int[arrayList.size()][];
        for (int row = 0; row < arrayList.size(); row++) {
            for (int column = 0; column < arrayList.get(row).size(); column++) {
                if (array[row] == null) {
                    array[row] = new int[arrayList.get(row).size()];
                }
                array[row][column] = arrayList.get(row).get(column);
            }

        }
        return array;
    }

    /**
     * 初始化一个棵树
     */
    public static TreeNode initTreeNode() {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);

        treeNode3.setLeft(treeNode6);
        treeNode3.setRight(treeNode7);

        treeNode1.setRight(treeNode3);
        treeNode1.setLeft(treeNode4);

        treeNode1.setRight(treeNode3);
        treeNode1.setLeft(treeNode2);

        treeNode4.setLeft(treeNode8);
        return treeNode1;


    }


}


