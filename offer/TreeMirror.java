package offer;

/**
 * Created by Larry-sea on 2017/3/14.
 *
 * offer 上的题目树的镜像问题
 * 树的反转镜像就是一棵树在如果照镜子，则显示镜子里的图案
 *
 *
 */
public class TreeMirror {


    public  static  void Mirror(TreeNode root) {

         if(root!=null)
         {
             TreeNode tempNode=root.left;
             root.left=root.right;
             root.right=tempNode;

             Mirror(root.left);
             Mirror(root.right);
         }

    }




    public static void main(String []args)
    {
        TreeNode treeNode1=new TreeNode(1);
        treeNode1.left=new TreeNode(2);
        treeNode1.right=new TreeNode(3);

        treeNode1.left.left=new TreeNode(4);
        treeNode1.left.right=new TreeNode(5);



        treeNode1.right.left=new TreeNode(6);
        treeNode1.right.right=new TreeNode(7);

        Mirror(treeNode1);
        System.out.println(treeNode1);

    }


}
