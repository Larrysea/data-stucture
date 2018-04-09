package ninechapter.common_datastructure;



import common_datastucture.ListNode;

import java.util.List;

/**
 * 合并k条排序链表
 *
 * @author
 * @create 2018-04-10 上午12:43
 **/
public class MergeKSortedList {

    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        //该题目也可以使用堆来做，将n个链表中的数据进行排序以后，存在优先队列中，然后再构造一个优先队列则完成该题目
        if (lists.size() == 0)
        {
            return null;
        }

        return mergeHelper(lists,0,lists.size() - 1);

    }

    //调用递归的方式进行两两合并

    public ListNode mergeHelper(List<ListNode> lists, int start, int end)
    {
        if (start == end)
        {
            return lists.get(start);
        }
        int mid = start + (end  - start)/2;
        ListNode leftList = mergeHelper(lists,start,mid);
        ListNode rightList = mergeHelper(lists,mid + 1,end);

        return mergeTwoList(leftList,rightList);
    }




    //合并两个list
    public ListNode mergeTwoList(ListNode listA, ListNode listB)
    {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (listA!=null && listB != null)
        {
            //如果节点a的值小于节点b
            if (listA.val < listB.val)
            {
                tail.next = listA;
                tail =  tail.next;
                listA = listA.next;
            }
            else
            {
                tail.next = listB;
                tail = tail.next;
                listB = listB.next;
            }
        }

        if (listA != null)
        {
            tail.next = listA;
        }
        else
        {
            tail.next = listB;
        }

        return dummy.next;

    }

}
