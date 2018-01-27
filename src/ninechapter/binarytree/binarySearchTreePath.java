package ninechapter.binarytree;

import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的深度
 *
 * @author
 * @create 2018-01-27 上午1:04
 **/
public class binarySearchTreePath {


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        List<String> paths = new ArrayList<>();


        PrintUtil.printStringList(binaryTreePaths(treeNode));

    }


    public static void traversal(String path, List<String> list, TreeNode treeNode) {
        System.out.println("输入路经" + path);
        if (treeNode == null) {
            return;
        }
        //走到一个叶子节点，完成一条路径的遍历进行添加
        if (treeNode.left == null && treeNode.right == null) {
            list.add(path);
            return;
        }

        if (treeNode.left != null) {
            //注意这里不能使用path=path+ "->" + treeNode.left.val; 因为这样写会改变path，结构从而影响兄弟的路径
            traversal(path + "->" + treeNode.left.val, list, treeNode.left);

        }
        if (treeNode.right != null) {

            traversal(path + "->" + treeNode.right.val, list, treeNode.right);

        }
    }


    /*
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        traversal(String.valueOf(root.val), arrayList, root);
        return arrayList;
    }


}
