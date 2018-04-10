package ninechapter.common_datastructure;

import java.util.HashMap;

/**
 * lru  cache数据结构实现
 *
 * @author
 * @create 2018-04-11 上午12:37
 **/
public class LRUCache {


    private class Node {
        Node prev;
        Node next;

        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    //存储的map
    private HashMap<Integer, Node> map = new HashMap<>();

    //头结点
    private Node head = new Node(-1, -1);
    //尾节点
    private Node tail = new Node(-1, -1);

    private int capacity = 0;

    /*
     * @param capacity: An integer
     */
    public LRUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        //首先判断hashMap中是否存在该值
        if (!map.containsKey(key)) {
            //如果不存在直接返回-1
            return -1;
        }

        //如果存在则从map中取出该节点，从当前位置删除掉，然后移动到尾部，最后返回该节点的值
        Node currentNode = map.get(key);

        //删除current节点
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;

        //移动该节点到尾部
        moveCurrentToTail(currentNode);

        return map.get(key).value;

    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        //如果已经存在该节点,则通过get移动到尾部，并且修改值
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        //如果不存在则准备插入该值，如果当前缓存应满了，则首先进行删除
        if (map.size() == capacity) {
            map.remove(head.next.key);
            //移动头部
            head.next = head.next.next;
            head.next.prev = head;

        }

        Node node = new Node(key, value);
        map.put(key, node);
        moveCurrentToTail(node);


        // write your code here
    }

    //移动当前节点到lrucache的尾部
    private void moveCurrentToTail(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;

    }

}
