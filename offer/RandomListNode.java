package offer;

/*
*
* 复杂链表，其中有两个节点，一个指向下一个节点，一个是指向链表中的任意节点
*
*
* */
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}