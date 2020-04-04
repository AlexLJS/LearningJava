package LinkedList;

import Utils.ListNode;

public class DetectCycle {
    /**
     *
     * 判断单链表是都有环， 返回入环节点
     *
     * 两个结论：
     * 1、快慢指针必定在环上某个节点相遇
     * 2、head 节点和相遇节点 到 入环节点 距离相等
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode low = head;
        ListNode high = head;

        while (high != null && high.next != null){
            low = low.next;
            high = high.next.next;
            if (low == high){
                return getNode(head,low);
            }
        }

        return null;
    }
    public static ListNode getNode(ListNode head, ListNode node){
        while (head != node){
            head = head.next;
            node = node.next;
        }
        return head;
    }
}
