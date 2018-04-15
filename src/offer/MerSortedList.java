package offer;

import data_stucture.PrintUtil;

/**
 * 合并两个排序链表
 *
 * @author
 * @create 2018-04-15 下午11:59
 **/
public class MerSortedList {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(4);
        listNode2.next.next = new ListNode(6);
        Merge(listNode1, listNode2);
    }


    public static ListNode Merge(ListNode list1, ListNode list2) {


        if (list1 == null && list2 == null) {
            return null;
        }

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode top = list1;
        ListNode bottom = list2;

        ListNode result = null;

        ListNode resultPointer = null;

        while (top!= null && bottom!= null) {
            if (top.val > bottom.val) {
                if (result == null) {
                    result = new ListNode(bottom.val);
                    bottom = bottom.next;
                    resultPointer = result;
                    continue;
                }
                resultPointer.next = new ListNode(bottom.val);
                resultPointer = resultPointer.next;
                bottom = bottom.next;
            } else {
                if (result == null) {
                    result = new ListNode(top.val);
                    top = top.next;
                    resultPointer = result;
                    continue;
                }

                resultPointer.next = new ListNode(top.val);
                resultPointer = resultPointer.next;
                top = top.next;
            }
        }
        //链表还有剩余
        while (top != null) {
            resultPointer.next = new ListNode(top.val);
            resultPointer = resultPointer.next;
            top = top.next;
        }

        while (bottom != null) {
            resultPointer.next = new ListNode(bottom.val);
            resultPointer = resultPointer.next;
            bottom = bottom.next;
        }

        return result;

    }
}
