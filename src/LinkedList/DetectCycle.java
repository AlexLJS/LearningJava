package LinkedList;

import Utils.ListNode;

public class DetectCycle {
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
