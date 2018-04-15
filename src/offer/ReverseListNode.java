package offer;

import data_stucture.PrintUtil;

/**
 * 翻转链表
 *
 * @author
 * @create 2018-04-15 下午11:30
 **/
public class ReverseListNode {
    public static void main(String[] args) {
        ListNode testCase1 = new ListNode(1);
        testCase1.next = new ListNode(2);
        testCase1.next.next = new ListNode(3);
        testCase1.next.next.next = new ListNode(4);
        testCase1.next.next.next.next = new ListNode(5);
        ListNode result = ReverseList(testCase1);
        PrintUtil.print(result.val);
    }


    public static ListNode ReverseList(ListNode head) {
        //首先移动到链表尾部
        ListNode tail = null;

        ListNode tempHead = head;

        while (tempHead.next != null) {
            tempHead = tempHead.next;
        }
        //找到尾节点
        tail = tempHead;
        //然后依次将头结点插入尾节点以后

        ListNode pointer = head;

        //链表第一位
        while (pointer != tail) {
            ListNode currentNode = pointer;
            pointer = pointer.next;

            //将该节点插入到尾节点以后
            if (tail.next == null) {
                tail.next = currentNode;
                currentNode.next = null;
            }
            //如果尾部节点已经有结果
            else {
                currentNode.next = tail.next;
                tail.next = currentNode;

            }
        }
        return tail;
    }
}
