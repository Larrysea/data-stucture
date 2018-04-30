package offer;

import data_stucture.ConstructUtil;
import data_stucture.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 移除重复节点
 *
 * @author
 * @create 2018-04-22 下午4:45
 **/
public class RemoveRepeatNode {
    public static void main(String[] args) {
        int[] testCase1 = {1, 2, 3, 3, 3, 4, 4, 5};
        int[] testCase2 = {3, 3, 3};
        int[] testCase3 = {};
        int[] testCase4 = {1, 1, 1, 1, 2};

        int[] testCase5 = {1, 2, 3, 4, 4, 4};
        int[] testCase6 = {1, 1, 2, 2, 3, 3, 4, 4};
        ListNode root = ConstructUtil.parseArrayToList(testCase1);
        ListNode noRepeatNode = deleteDuplication(root);
        PrintUtil.printListNode(noRepeatNode);
    }


    public static ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode current = pHead;

        ListNode last = head;
        while (current != null && current.next != null) {

            //如果节点值相等
            if (current.val == current.next.val) {
                int val = current.val;

                while (current != null && current.val == val) {
                    current = current.next;
                }
                last.next = current;
            } else {
                last = current;
                current = current.next;
            }


        }

        return head.next;
    }
}
