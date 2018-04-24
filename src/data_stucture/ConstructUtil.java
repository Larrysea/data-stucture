package data_stucture;


import offer.ListNode;

import java.util.List;

/**
 * 构造数据结构工具类
 *
 * @author
 * @create 2018-04-22 下午4:49
 **/
public class ConstructUtil {

    public static ListNode parseArrayToList(int[] num) {

        if (num == null || num.length == 0) {
            return null;
        }
        ListNode root = new ListNode(num[0]);

        ListNode point = root;
        for (int i = 1; i < num.length; i++) {
            point.next = new ListNode(num[i]);
            point = point.next;
        }

        return root;
    }


}
