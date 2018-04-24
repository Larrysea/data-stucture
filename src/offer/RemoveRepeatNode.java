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
        if (pHead == null) {
            return pHead;
        }

        ListNode point = pHead;

        boolean isNeedDelete = false;

        ListNode preNode = null;

        while (point != null) {
            //节点重复删除下个节点
            if (point.next != null && point.val == point.next.val) {
                isNeedDelete = true;
            }

            //是否需要删除节点
            if (!isNeedDelete) {
                preNode = point;
                point = point.next;
            } else {
                int value = point.val;
                ListNode deleteNode = point;
                while (deleteNode != null && deleteNode.val == value) {
                    point.next = deleteNode.next;
                    deleteNode = point.next;
                }
            }

            //开始节点为空
            if (preNode == null) {
                pHead = point.next;

            } else {
                preNode.next = point;
            }
            point = point.next;
        }
        return pHead;
    }
}
