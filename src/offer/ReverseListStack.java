package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Larry-sea on 2017/1/21.
 * <p>
 * 剑指offer中的反转链表
 *
 * 用栈的方式实现反转链表
 *
 */
public class ReverseListStack {

   static  public ArrayList<Integer> reverseList(ListNode listNode) throws Exception {

        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<Integer> reverseList = new Stack<Integer>();
        while (listNode!= null) {
            reverseList.push(listNode.val);
            listNode = listNode.next;
        }
        while (!reverseList.empty()) {
            result.add(reverseList.pop());
        }
        return result;
    }

  static  public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String [] args)
    {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);
        try {
           ArrayList<Integer> result= reverseList(listNode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
