package offer;

/**
 * Created by Larry-sea on 2017/6/1.
 * <p>
 * 剑指offer上的复杂链表的复制
 */


public class ComplexNodeCopy {

    public RandomListNode Clone(RandomListNode pHead) {
        return new RandomListNode(3);
    }


    /*
    * 复制原始节点 从1-2-3-4  复制成 1-1-2-2-3-3-4-4
    *
    * */
    public static void copyListNode(RandomListNode randomListNode) {
        if (randomListNode == null) {
            return;
        }
        //链表中只有一个节点所以只用复制一个就好
        if (randomListNode.next == null) {
            randomListNode.next = new RandomListNode(randomListNode.label);
            return;
        }
        RandomListNode pNode = randomListNode;
        while (pNode != null) {
            RandomListNode copyNode = new RandomListNode(pNode.label);
            copyNode.next = pNode.next;
            copyNode.random = null;

            pNode.next = copyNode;
            pNode = copyNode.next;
        }
    }


    /**
     * 复制任意节点  只是将sibling也一起复制了
     *
     * @param randomListNode
     */
    public static void copyRandomListNode(RandomListNode randomListNode) {
        if (randomListNode == null) {
            return;
        }
        RandomListNode pNode = randomListNode;
        RandomListNode copyNode = pNode.next;

        while (pNode != null) {
            //完成复制操作
            copyNode.random = pNode.random;
            //完成pNode指针指向下一个节点
            pNode = copyNode.next;
            //copyNode 指向下一个copyNode

            if (pNode != null) {
                copyNode = pNode.next;
            }

        }

    }

    /*
    *
    * 复制的链表进行拆分
    * */
    public static RandomListNode copyRandomListNodeSplit(RandomListNode randomListNode) {

        RandomListNode pNode = randomListNode;
        RandomListNode headNode = null;
        RandomListNode copyNode = null;

        if (pNode != null) {
            headNode = pNode.next;
            copyNode = pNode.next;
            pNode.next = copyNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            copyNode.next = pNode.next;
            copyNode = copyNode.next;
            pNode.next = copyNode.next;
            pNode = pNode.next;
        }
        return headNode;

    }


    /*
    *
    *
    * 测试主函数
    * */
    public static void main(String[] args) {
        RandomListNode randomListNodeA = new RandomListNode(1);
        RandomListNode randomListNodeB = new RandomListNode(2);
        RandomListNode randomListNodeC = new RandomListNode(3);
        RandomListNode randomListNodeD = new RandomListNode(4);
        RandomListNode randomListNodeE = new RandomListNode(5);

        RandomListNode randomListNode=null;
        //建立next连接
        //  randomListNodeA.next = randomListNodeB;
       /* randomListNodeB.next = randomListNodeC;
        randomListNodeC.next = randomListNodeD;
        randomListNodeD.next = randomListNodeE;*/

        //建立random连接
      /*  randomListNodeA.random = randomListNodeD;
        randomListNodeB.random = randomListNodeE;
        randomListNodeC.random = randomListNodeA;
        randomListNodeD.random = randomListNodeC;
        randomListNodeE.random = randomListNodeB;*/


        copyListNode(randomListNode);
        copyRandomListNode(randomListNode);
        RandomListNode result = copyRandomListNodeSplit(randomListNode);
        System.out.print("pause");


    }

}
