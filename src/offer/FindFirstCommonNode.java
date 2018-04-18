package offer;

import data_stucture.PrintUtil;

/**
 * 找出第一个公共节点
 *
 * @author
 * @create 2018-04-19 上午12:51
 **/
public class FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node8.next = node7;
        node7.next = node6;
        node6.next = node2;
        PrintUtil.print(FindFirstCommonNode(node1, node8).val);


    }


    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        //结题思路。因为链表有交点组合成的形状是一个y形的，所有他们的劈叉的地方就是他们的交点
        //首先统计出两个链表的长度，然后在长链表中先走几步，然后再一个一个的出队判断如果两个遍历到相同的节点则返回该节点

        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        int node1Length = 0;
        int node2Length = 0;
        while (node1 != null) {
            node1 = node1.next;
            node1Length++;
        }


        while (node2 != null) {
            node2 = node2.next;
            node2Length++;
        }

        if (node1Length == 0 || node2Length == 0) {
            return null;
        }

        int diff = node1Length > node2Length ? node1Length - node2Length : node2Length - node1Length;

        boolean node1IsBigger = node1Length > node2Length;
        if (node1IsBigger) {
            node1 = pHead1;
            while (diff > 0 && node1 != null) {
                node1 = node1.next;
                diff--;
            }
            node2 = pHead2;

        } else {
            node2 = pHead2;
            while (diff > 0 && node2 != null) {
                node2 = node2.next;
                diff--;
            }
            node1 = pHead1;
        }


        while (node1 != null && node2 != null && node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }

        return node1;
    }


}
