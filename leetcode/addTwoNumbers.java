package leetcode;

/**
 * Created by Larry-sea on 2016/11/11.
 * <p>
 * 将两个lsitNode相加起来
 * <p>
 * 并返回结果listNode
 */
public class addTwoNumbers {

    /*
    * 将两个listNode向加起来
    *
    * */
    static ListNode addTwoListNode(ListNode listNodeA, ListNode listNodeB) {
        boolean isOver = false;                 //是否超过10
        ListNode result = null;
        ListNode pointA = null;                 //pointA
        ListNode pointB = null;                 //pointB
        int tempValue;                          //临时值

        pointA = listNodeA;
        pointB = listNodeB;

        while (pointA != null || pointB != null || isOver) {
            if (isOver) {    //有进位的情况
                if (pointA == null && pointB == null) {  //当两个都是一个且有进位时
                    tempValue = 1;
                    addListNode(result, tempValue);
                    return result;
                } else if (pointA == null) {
                    tempValue = 1 + pointB.val;
                } else if (pointB == null) {
                    tempValue = 1 + pointA.val;
                } else {
                    tempValue = 1 + pointA.val + pointB.val;
                }
                //头结点已经被初始化之后的使用
                addListNode(result, tempValue);

            } else {  //无进位
                if (pointA == null) {
                    tempValue = pointB.val;
                } else if (pointB == null) {
                    tempValue = pointA.val;
                } else {
                    tempValue = pointA.val + pointB.val;
                }
                if (result != null) {
                    //当头结点存在时 以后每次的添加的情况
                    addListNode(result, tempValue);
                } else {
                    //第一次初始化的情形
                    result = initHeadListNode(tempValue);
                }
            }

            //判断是否有进位
            if (tempValue >= 10) {
                isOver = true;
            } else {
                isOver = false;
            }

            //判断下一个节点是否为空
            if (pointA != null)
                pointA = pointA.next;
            if (pointB != null)
                pointB = pointB.next;


        }

        return result;
    }


    /*
   *
   * 初始化头结点
   * */
    private static ListNode initHeadListNode(int tempValue) {
        ListNode result;
        if (tempValue > 10) {
            result = new ListNode(tempValue - 10);
        } else if (tempValue == 10) {
            result = new ListNode(0);
        } else {
            result = new ListNode(tempValue);
        }
        return result;
    }


    /*
    * 添加节点
    *
    * */
    private static void addListNode(ListNode result, int tempValue) {
        if (tempValue > 10)
            getLastListNode(result).next = new ListNode(tempValue - 10);
        else if (tempValue == 10) {
            getLastListNode(result).next = new ListNode(0);
        } else {
            getLastListNode(result).next = new ListNode(tempValue);
        }

    }


    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /*
  * 获取最后一个节点
  * */
    static public ListNode getLastListNode(ListNode listNode) {
        while (listNode.next != null) {
            listNode = listNode.next;
        }

        return listNode;
    }


    static public ListNode initListNode() {
        ListNode listNode = new ListNode(0);
        for (int position = 1; position < 10; position++) {
            getLastListNode(listNode).next = new ListNode(position);
        }
        return listNode;
    }


    //显示listnode
    static public void showListNode(ListNode listNode) {

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    public static void main(String[] args) {
        ListNode listA = new ListNode(7);
        listA.next = new ListNode(2);
        listA.next.next = new ListNode(4);
        listA.next.next.next = new ListNode(3);


    }

}
