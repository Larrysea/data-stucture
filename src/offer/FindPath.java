package offer;

/**
 * Created by Larry-sea on 2017/4/5.
 */

import java.util.ArrayList;

/**
 * public class TreeNode {
 * int val = 0;
 * TreeNode left = null;
 * TreeNode right = null;
 * <p>
 * public TreeNode(int val) {
 * this.val = val;
 * <p>
 * }
 * <p>
 * }
 *
 * 输入一颗二叉树和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //结果返回值
        if (root == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subPath = new ArrayList<Integer>();
        int currentSum = 0;
        findPath(root, target, result, subPath, currentSum);
        return result;
    }


    //查找路径
    public void findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int currentSum) {


        path.add(root.val);
        currentSum += root.val;

        if (root.left == null && root.right == null && currentSum == target) {
            result.add(new ArrayList<>(path));
        }

        if (root.left != null) {
            findPath(root.left, target, result, path, currentSum);
        }

        if (root.right != null) {
            findPath(root.right, target, result, path, currentSum);
        }

        path.remove(path.size() - 1);
    }
}