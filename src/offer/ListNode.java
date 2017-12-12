package offer;

/**
 * Created by Larry-sea on 2017/1/25.
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }







    /**
     * 测试添加节点信息
     *
     * @param array 需要初始化的数组
     * @return
     */
    public static ListNode initListNode(int[] array) throws IllegalArgumentException {
        ListNode result = null;
        ListNode last = null;

        if (array == null) {
            throw new IllegalArgumentException("array cant empty");
        }

        last = new ListNode(array[0]);
        result = last;

        for (int i = 1; i < array.length; i++) {

            last.next = new ListNode(array[i]);
            last = last.next;

        }

        return result;


    }


}