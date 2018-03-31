package ninechapter.binarytree;

import common_datastucture.TreeNode;
import data_stucture.PrintUtil;

import javax.transaction.TransactionRequiredException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 最靠近的二叉搜索树的值
 *
 * @author
 * @create 2018-03-31 下午4:00
 * <p>
 * 找出最靠近的二叉搜索树的值
 **/
public class ClosetBinarySearchTreeValue {

    public static void main(String[] args) {
        List<Integer> preOrderList = new LinkedList<>();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);


//        root.right = new TreeNode(3);

//        PrintUtil.printList(closestKValues(root, 5.571429, 2));

//        PrintUtil.printList(closestKValues(root, 2147483647, 2));

//        PrintUtil.printList(closestKValues(root1, 4.142857, 2));

        List<Integer> testParam1 = new LinkedList<>();
        inOrderList.add(1);
        inOrderList.add(2);
        inOrderList.add(3);
        inOrderList.add(4);
        inOrderList.add(5);

        findKResult(2, 3.714286, testParam1, 3);
        PrintUtil.printList(testParam1);

    }

    private static ArrayList<Integer> inOrderList = new ArrayList<>();

    /**
     * @param root:   the given BST
     * @param target: the given target
     * @param k:      the given k
     * @return: k values in the BST that are closest to the target
     */
    public static List<Integer> closestKValues(TreeNode root, double target, int k) {

        //记录结果的集合
        List<Integer> result = new ArrayList<>(k);


        // write your code here
        //第一种算法通过中序遍历将二叉树变为一个排序的队列然后将树排序，然后每个数和target的差值记录下来然后排序，然后排序取多k个数就是结果

        inTraverse(root);


        if (inOrderList.size() == 1) {

            for (int i = 0; i < k; i++) {
                result.add(inOrderList.get(0));
            }
            return result;
        }

        int targetIndex = inOrderList.indexOf(target);
        boolean isLess = false;
        //未寻找到
        if (targetIndex == -1 && (target > inOrderList.get(inOrderList.size() - 1) || target < inOrderList.get(0))) {
            //在小于范围的
            if (target < inOrderList.get(0)) {
                isLess = true;
            } else {
                isLess = false;
            }
            if (k >= inOrderList.size()) {
                return inOrderList;
            }

            int rightIndex = inOrderList.size() - 1;
            for (int i = 0; i < k; i++) {
                if (isLess) {
                    result.add(inOrderList.get(i));
                } else {
                    result.add(inOrderList.get(rightIndex--));
                }
            }
            Collections.sort(result);
            return result;
        }

        //寻找最靠近的指针
        for (int i = 0; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) > target) {
                targetIndex = i;
            }
        }

        findKResult(targetIndex, target, result, k);


        return result;
    }


    //通过中序遍历获取排序顺序
    private static void inTraverse(TreeNode root) {
        if (root.left != null) {
            inTraverse(root.left);
        }

        inOrderList.add(root.val);

        if (root.right != null) {
            inTraverse(root.right);
        }
    }


    private static void findKResult(int targetIndex, double target, List<Integer> result, int k) {
        //寻找最靠近的指针
        for (int i = 0; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) > target) {
                targetIndex = i;
                break;
            }
        }

        //左指针
        int leftP = targetIndex - 1;
        //右指针
        int rightP = targetIndex;

        boolean isLess = false;
        while (result.size() <= k && leftP >= 0 && rightP < inOrderList.size()) {
            //如果左边的绝对值差大于右边，则移动右边指针
            if (target - inOrderList.get(leftP) > inOrderList.get(rightP) - target) {
                result.add(inOrderList.get(rightP));
                if (rightP == inOrderList.size()) {
                    break;
                }
                rightP++;

            }
            //如果右边的大于左边则
            else {
                result.add(inOrderList.get(leftP));
                if (leftP == 0) {
                    isLess = true;
                    break;
                }
                leftP--;

            }
        }
        Collections.sort(result);

        //如果最后总数不满足则继续取值
        while (result.size() < k) {
            if (isLess) {
                result.add(inOrderList.get(rightP++));
            } else {
                result.add(inOrderList.get(rightP--));
            }
        }

    }


}
