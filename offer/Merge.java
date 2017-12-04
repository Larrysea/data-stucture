package offer;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry-sea on 2017/3/13.
 * <p>
 * <p>
 * offer 上两个单调递增的链表合并，合并之后两个链表还是保持单调递增
 */
public class Merge {


    public static ListNode ListMerge(ListNode list1, ListNode list2) {
        ListNode ptr1 = null;
        ListNode ptr2 = null;
        ListNode resultPtr = null;
        ListNode lastPtr = null;
        int minValue;

        ptr1 = list1;
        ptr2 = list2;


            if (list1 == null && list2 != null) {
                return list2;
            }

            if (list2 == null && list1 != null) {
                return list1;

            }
        while (ptr1 != null && ptr2 != null) {

            if (ptr1.val < ptr2.val) {
                minValue = ptr1.val;
                ptr1 = ptr1.next;
            } else if (ptr2.val < ptr1.val) {
                minValue = ptr2.val;
                ptr2 = ptr2.next;
            } else {
                minValue = ptr1.val;
                ptr1 = ptr1.next;
            }


            //第一次初始化时
            if (null == lastPtr) {
                lastPtr = new ListNode(minValue);
                resultPtr = lastPtr;
            }

            //拼接的链表的结果链表不为空时，每次在最后一个节点后面加节点
            else {
                lastPtr.next = new ListNode(minValue);
                lastPtr = lastPtr.next;
            }

        }


        while (ptr1 != null) {
            lastPtr.next = ptr1;
            ptr1 = ptr1.next;
            lastPtr = lastPtr.next;
        }


        while (ptr2 != null) {
            lastPtr.next = ptr2;
            ptr2 = ptr2.next;
            lastPtr = lastPtr.next;
        }

        return resultPtr;
    }


    public static void main(String[] args) {

        int[] array1 = {1, 2, 3, 8, 9};
        int[] array2 = {2, 5, 3, 7, 10};
        ListNode listNode1 = ListNode.initListNode(array1);
        ListNode listNode2 = ListNode.initListNode(array2);

        ListMerge(listNode1, null);
    }


    /**
     * 将listNode1 中的节点加入到listNode2 的节点上
     *
     *
     * @return 返回相加之后的链表
     */
   /* public static ListNode addListNode1ToListNode2(ListNode listNode1,ListNode listNode2) throws Exception
    {
        if(listNode1==null||listNode2==null)
        {
            throw  new IllegalArgumentException("listNode cant empty please check your param ");
        }

        while(listNode1.next!=null)
        {


        }


    }*/
}
