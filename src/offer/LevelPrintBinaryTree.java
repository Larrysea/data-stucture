package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 按层打印二叉树
 *
 * @author
 * @create 2018-04-21 下午8:24
 **/
public class LevelPrintBinaryTree {

    //二叉树多行打印
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (pRoot == null) {
            return new ArrayList<ArrayList<Integer>>();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            int stackSize = queue.size();

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < stackSize; i++) {
                TreeNode node = queue.poll();

                list.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(list);
        }

        return result;

    }
}
