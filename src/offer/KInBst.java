package offer;

import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的第k个节点
 *
 * @author
 * @create 2018-04-21 下午7:46
 **/
public class KInBst {

    TreeNode KthNode(TreeNode pRoot, int k) {
        //root  为空的情况

        if (pRoot == null) {
            return null;
        }


        List<TreeNode> list = new ArrayList<>();
        inOrder(pRoot, list);
        //超出范围的情况
        if (k - 1 >= list.size() || k - 1 < 0) {
            return null;
        }
        return list.get(k - 1);
    }


    private static void inOrder(TreeNode root, List<TreeNode> list) {
        if (root.left != null) {
            inOrder(root.left, list);
        }
        list.add(root);
        if (root.right != null) {
            inOrder(root.right, list);
        }
    }

}
