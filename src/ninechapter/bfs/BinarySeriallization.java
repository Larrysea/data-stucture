package ninechapter.bfs;

import apple.laf.JRSUIUtils;
import data_stucture.PrintUtil;
import ninechapter.common_datastructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树序列化与反序列化的实现
 *
 * @author
 * @create 2018-02-06 上午12:10
 **/
public class BinarySeriallization {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        serializeHelper(root, stringBuilder);
        return stringBuilder.toString();
    }


    /**
     * @param root
     * @param result //output String example ="{3,9,20,#,#,15,7}";
     */
    public static void serializeHelper(TreeNode root, StringBuilder result) {
        if (root == null) {
            result.append("{}");
            return;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);


        while (!treeQueue.isEmpty()) {
            if (result.length() == 0) {
                result.append("{");
            }
            TreeNode treeNode = treeQueue.poll();
            if (treeNode != null) {
                result.append(treeNode.val);
            } else {
                result.append("#");
                result.append(",");
                continue;
            }
            result.append(",");
            if (treeNode.left != null) {
                treeQueue.offer(treeNode.left);
            } else {
                treeQueue.offer(null);
            }
            if (treeNode.right != null) {
                treeQueue.offer(treeNode.right);
            } else {
                treeQueue.offer(null);
            }
        }
        while (result.length() > 0) {
            char temp = result.charAt(result.length() - 1);
            if (temp == '#' || temp == ',') {
                result.deleteCharAt(result.length() - 1);
            } else {
                break;
            }
        }
        result.append("}");

    }


    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        if (data.equals("{}")) {
            return null;
        }
        String[] resultString = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> treeQueue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.valueOf(resultString[0]));
        treeQueue.add(root);
        int treeNodeIndex = 0;
        boolean isLeftChild = true;
        for (int index = 1; index < resultString.length; index++) {
            TreeNode tempNode = treeQueue.get(treeNodeIndex);

            if (isLeftChild) {
                if (!resultString[index].equals("#")) {
                    tempNode.left = new TreeNode(Integer.valueOf(resultString[index]));
                    treeQueue.add(tempNode.left);
                }

            } else {
                if (!resultString[index].equals("#")) {
                    tempNode.right = new TreeNode(Integer.valueOf(resultString[index]));
                    treeQueue.add(tempNode.right);
                }

            }
            isLeftChild = !isLeftChild;
            if (isLeftChild) {
                treeNodeIndex++;
            }
        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        PrintUtil.print(serialize(root));
        deserialize(serialize(root));
    }
}
