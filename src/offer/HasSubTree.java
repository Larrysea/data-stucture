package offer;

/**
 * Created by Larry-sea on 2017/3/16.
 * <p>
 * offer 上的题目，判断树b树是不是a树的子树如果是
 */
public class HasSubTree {


    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        boolean result = false;
        //解题思路先找公共父节点
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isEqual(root1, root2);
            }

            if (!result) {
                result = HasSubtree(root1.left, root2);
            }


            if (!result) {
                result = HasSubtree(root1.right, root2);
            }

        }

        return result;

    }

    //判断是否相等
    private boolean isEqual(TreeNode node1, TreeNode node2) {
        //子树先到叶子节点
        if (node2 == null) {
            return true;
        }
        //父亲树先到叶子节点
        if (node1 == null) {
            return false;
        }

        if(node1.val!=node2.val)
        {
            return false;
        }

        return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);

    }
}
