package offer;

/**
 * Created by Larry-sea on 2017/3/16.
 * <p>
 * offer 上的题目，判断树b树是不是a树的子树如果是
 */
public class HasSubTree {


    /**
     * @param root1 parentTree 父亲树
     * @param root2 subTree    子树
     * @return
     */
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
            //如果根节点相同继续判断左右子树
        if (root1.val == root2.val) {
            //判断左子树是否相等
            if (isEqual(root1.left, root2.left)) {
                //判断右子树是否相等
                if (isEqual(root1.right, root2.right)) {
                    return true;
                }
                else
                {
                    hasSubtree(root1.left,root2);
                }
            }else
            {
                hasSubtree(root1.left,root2);
            }
        }
        //如果根节点不同判断左子树还有右子树
        else {
            hasSubtree(root1.left, root2);
            hasSubtree(root1.right, root2);
        }
        return false;
    }


    /**
     * 判断两个节点是否围攻
     *
     * @param listNode1
     * @param listNode2
     * @return
     */
    public static boolean isEqual(TreeNode listNode1, TreeNode listNode2) {

        //节点为空的情况相等
        if (listNode1 == listNode2 && listNode1 == null) {
            return true;
        }
        //节点不为空的情况
        else if (listNode1 != null && listNode2 != null) {
            if (listNode1.val == listNode2.val) {
                return true;
            } else {
                return false;
            }
        }
        //节点一个为空一个不为空的情况这种为false
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        /*
        * 父亲树
        * */
        TreeNode parentTree;
        /*
        * 子树
        * */
        TreeNode subTree;



    }


    /**
     * 初始化树
     *
     * @param array
     * @return
     */
  /*  public TreeNode initTree(int [] array)
    {

    }
*/

}
