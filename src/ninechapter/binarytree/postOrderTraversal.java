package ninechapter.binarytree;

import ninechapter.common_datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 *
 * @author
 * @create 2018-01-26 下午11:55
 **/
public class postOrderTraversal {

    public static void main(String[] args) {

    }


    /*
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        postOrderTraversal(list, root);
        return list;

    }

    /**
     * 后序遍历
     *
     * @param result
     * @param root
     */
    public static void postOrderTraversal(List<Integer> result, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            postOrderTraversal(result, root.left);
        }
        if (root.right != null) {
            postOrderTraversal(result, root.right);
        }
        result.add(root.val);

    }

}
