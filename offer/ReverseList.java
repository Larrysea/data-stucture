package offer;

import offer.ListNode;

/**
 * Created by Larry-sea on 2017/3/8.
 * <p>
 * 反转链表   暂时未通过
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);
        listNode1.next.next.next.next.next = new ListNode(6);
        listNode1.next.next.next.next.next.next = new ListNode(7);
        ListNode listNode = reverseListNode(listNode1);
        System.out.println(listNode);

    }


    static ListNode reverseListNode(ListNode listNode) {

        if (listNode == null) {
            return null;
        }
        ListNode preNode;
        ListNode nowNode;
        ListNode nextNode;

        preNode = listNode;
        nowNode = preNode.next;
        nextNode = nowNode.next;

        preNode.next = null;
        while (nowNode != null) {
            nowNode.next = preNode;
            preNode = nowNode;
            nowNode = nextNode;
            nextNode = nextNode.next;
        }
        return nowNode;

    }

}
