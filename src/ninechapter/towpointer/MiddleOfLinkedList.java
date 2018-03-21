package ninechapter.towpointer;


import data_stucture.PrintUtil;

/**
 * 链表的中间节点
 *
 * @author
 * @create 2018-03-22 上午12:08
 **/
public class MiddleOfLinkedList {


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);


        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);

        ListNode node2 = new ListNode(5);


        PrintUtil.print(middleNode(node2).val);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*
     * @param head: the head of linked list.
     * @return: a middle node of the linked list
     */
    public static ListNode middleNode(ListNode head) {

        if (head == null) {
            return null;
        }
        // write your code here
        int length = 1;

        ListNode pointer = head;
        while (pointer.next != null) {
            length++;
            pointer = pointer.next;
        }
        int middleIndex = 0;
        //如果是偶数则返回中位数的前一个数
        if (length % 2 == 0) {
            middleIndex = (length / 2) - 1;
        } else {
            middleIndex = (length / 2);
        }

        pointer = head;
        int index = 0;
        while (pointer.next != null) {
            //如果下标等于中位数则跳出循环
            if (index == middleIndex) {
                return pointer;
            }
            index++;
            pointer = pointer.next;
        }

        return head;

    }
}
