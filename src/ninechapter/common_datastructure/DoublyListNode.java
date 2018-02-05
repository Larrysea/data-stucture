package ninechapter.common_datastructure;

/**
 * 双链表
 *
 * @author
 * @create 2018-02-03 下午11:47
 **/

public class DoublyListNode {
    int val;
    DoublyListNode next, prev;

    DoublyListNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}
