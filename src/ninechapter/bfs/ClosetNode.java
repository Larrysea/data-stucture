package ninechapter.bfs;


/**
 * 搜索二叉树中值最靠近的node.
 *
 * @author
 * @create 2018-03-22 下午11:57
 **/
public class ClosetNode {

    static double diff = Integer.MAX_VALUE;
    static double result = -1;

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        double testTarget = 4.428571;
        closestValue(root, testTarget);
    }


    /**
     * @param root:   the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    static int closestValue(TreeNode root, double target) {
        // write your code here


        if (root == null) {
            return -1;
        }

        traverse(root, target);

        return (int) result;
    }

    private static void traverse(TreeNode node, double target) {
        if (node == null) {
            return;
        }

        double tempDiff = Math.abs(node.val - target);
        if (tempDiff < diff) {
            result = node.val;
            diff = tempDiff;
        }

        traverse(node.left, target);
        traverse(node.right, target);

    }
}
