package offer;

/**
 * Created by Larry-sea on 2017/3/30.
 * <p>
 * 验证bst是否是二叉搜索树的后续遍历数组，如果是返回true,如果不是返回false
 */
public class VerifySquenceOfBST {


    /**
     * 验证是否是二叉搜索树的后续遍历结果
     * 首先二叉搜索树的必须满足于连个条件
     * 一是左子树的所有节点值一定小于根节点的值
     * 二是右子树的所有节点值一定大于根节点的值
     * 三是因为是后续遍历的最后一个节点一定是树的根节点
     *
     * @param sequence
     * @return
     */
    public static boolean isSequenceOfBst(int[] sequence, int startPosition, int length) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        int leftTreeLength = startPosition;
        int root = sequence[length - 1];
        //获取左子树的位置
        for (; leftTreeLength < length - 1; leftTreeLength++) {
            if (sequence[leftTreeLength] > root)
                break;
        }

        //获取右子树的位置
        int rightPosition = leftTreeLength;
        for (; rightPosition < length - 1; rightPosition++) {
            if (sequence[rightPosition] < root) {
                return false;
            }
        }


        //判断左子树是否符合二叉搜索树

        boolean left = true;
        //判断左子树存在
        if (leftTreeLength > 0) {
            left = isSequenceOfBst(sequence, 0, leftTreeLength);
        }


        boolean right = true;
        //右子树是否小于长度
        if (leftTreeLength < length - 1) {
            right = isSequenceOfBst(sequence, leftTreeLength, length - 1);
        }

        return (right && left);
    }

    /*
    *
    * 测试主函数
    *
    *
    * */
    public static void main(String[] args) {
        //结果为true的数组测试数据
        int[] sequence = {1, 3, 2, 5, 8, 6, 4};

        //结果为false的数组测试数据
        int[] falseSequence = {7, 4, 6, 5};
        System.out.println(VerifySquenceOfBST(sequence));
        System.out.println(VerifySquenceOfBST(falseSequence));
    }


    public static boolean VerifySquenceOfBST(int[] sequence) {

        return isSequenceOfBst(sequence, 0, sequence.length);

    }


}
