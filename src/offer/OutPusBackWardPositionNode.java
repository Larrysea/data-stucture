package offer;

/**
 * Created by Larry-sea on 2017/1/25.
 * <p>
 * 输出倒数多少个节点
 */
public class OutPusBackWardPositionNode {

    static public ListNode FindKthToTail(ListNode head, int k) throws Exception {
        if (head == null || head.next == null) {
            return null;
        }
        if (k <=0 || k > getListLength(head)) {
            return null;
        }
        ListNode startPoint;         //开始节点
        ListNode endPoint;           //尾部节点
        startPoint = head;
        endPoint = findIndexPoint(head, k);
        while (endPoint.next != null) {
            endPoint = endPoint.next;
            startPoint = startPoint.next;
        }
        return startPoint;
    }

    static public ListNode findIndexPoint(ListNode listNode, int kIndex) {
        for (int position = 0; position < kIndex - 1; position++) {
            listNode = listNode.next;
        }
        return listNode;

    }

    /**
     * 获取list的长度
     *
     * @param listNode
     * @return 返回list的长度
     */
    static public int getListLength(ListNode listNode) {
        int length = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            length++;
        }
        return length;
    }


    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        getListLength(listNode);
        try {
            FindKthToTail(listNode, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
