package LinkedList;

import Utils.ListNode;

/**
 * 实现LRU缓存淘汰算法链表实现：
 * Least Recently Used 听着很唬人。
 * 需求：其实就是将最近使用的放前面，最多使用的放前面，反之最少最不常使用的淘汰掉。
 * 设计一个可以缓存10个int 的list LRU缓存。
 * 常用的连在head ，超出的表尾淘汰。
 */
public class LRUcache {
    private static int size = 10;
    private static ListNode head;

    public static ListNode getHead() {
        return head;
    }

    public static void insertHead(ListNode node){
        node.next = head;
        head = node;
    }

    public static void fullCache(ListNode node){
        ListNode cur = head;
        if (head.value == node.value)
            return;
        while (cur.next.next != null ){//cur停在倒数第二个节点，少申请变量
            if (cur.next.value == node.value){
                cur.next = cur.next.next;//remove cur.next
                insertHead(node);
            }
            cur = cur.next;
        }
        /**
         * 无论尾节点与新节点是都相同，都删尾巴插头:
         * 1、如果末尾节点与node相同，需要删尾巴插头；
         * 2、如果末尾节点与node不同，需要踢出最后节点，还是删尾巴插头。
         * 还有一种情况，node已经换入链表，最后节点还与node相同，回到1、，故不可能发生。
         * （进数据时候应该set去重，sun的LRUCache使用hashmap，在此默认缓存已满情况）
         * （重复一进来，就应该排在前面。这个程序还需要优化。）
         */
        if (node.next == null) {//node未插入缓存
            cur.next = null;
            insertHead(node);
        }
    }

    public ListNode insertNode(ListNode node){
        if (head == null) {
            head = node;
        }else {
            if (size <= 0){
                fullCache(node);
            }else {
                insertHead(node);
            }
        }
        size--;
        return head;
    }
}
