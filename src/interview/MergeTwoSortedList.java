package interview;

import common_datastucture.ListNode;
import data_stucture.PrintUtil;

/**
 * 合并两个排序链表
 *
 * @author
 * @create 2018-05-29 4:00 PM
 **/
public class MergeTwoSortedList {


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);

        listNode1.next = new ListNode(3);

        listNode1.next.next = new ListNode(5);


        ListNode listNode2 = new ListNode(2);

        listNode2.next = new ListNode(4);

        listNode2.next.next = new ListNode(6);

        mergeTwoLists(listNode1, listNode2);


//        PrintUtil.print(stringToInteger("-12124213"));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dumyNode = new ListNode(0);

        ListNode lastNode = dumyNode;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            } else {
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }

        if (l1 != null) {
            lastNode.next = l1;
        }

        if (l2 != null) {
            lastNode.next = l2;
        }


        return dumyNode.next;
    }




//    public static int stringToInteger(String str) {
//
//    }






}

