package offer;

/**
 * Created by Larry-sea on 2017/1/26.
 * <p>
 * 重新构建二叉树
 */
public class RebuildBtree {

    static public TreeNode reConstructBinaryTree(int[] pre, int[] in) throws Exception {
        if (pre.length == 0 || in.length == 0) {
            throw new Exception("array cant empty ");
        }
        if (pre.length != in.length) {
            throw new Exception("array size must equal ");
        }
        return constructTree(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    /**
     * @param pre   前序遍历的数组
     * @param in    中序遍历的数组
     * @return      返回构建的树的根节点
     * @throws Exception
     */
    static public TreeNode constructTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) throws Exception {
        TreeNode rootNode = new TreeNode(pre[preStart]);
        //左子树的长度
        int rootInPosition = findPosition(in, pre[preStart]);
        if (rootInPosition == -1) {
            throw new Exception("invalid input array becaue cant find value in inOrderArray");
        }
        //只有一个节点的树
        if (pre.length == in.length && pre.length == 1) {
            return rootNode;
        }
        //左子树长度
        int leftLength=rootInPosition -inStart;
        int leftPreEnd=preStart+leftLength;
        if (leftLength> 0) {
            rootNode.left = constructTree(pre, preStart + 1,leftPreEnd, in, inStart, rootInPosition-1);
        }

        if (inEnd - rootInPosition > 0) {
            rootNode.right = constructTree(pre, leftPreEnd+1, preEnd, in, rootInPosition + 1, inEnd);
        }
        return rootNode;
    }

    static public int findPosition(int[] array, int value) throws Exception {
        if (array.length == 0) {
            throw new Exception("array cant empty");
        }

        for (int position = 0; position < array.length; position++) {
            if (array[position] == value)
                return position;
        }
        //未在数组中找到该数
        return -1;
    }


    public static void main(String[] args) {
        int[] preArray = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inArray = {4, 7, 2, 1, 5, 3, 8, 6};

        try {
            TreeNode rootNode = reConstructBinaryTree(preArray, inArray);
            System.out.println(rootNode.val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
