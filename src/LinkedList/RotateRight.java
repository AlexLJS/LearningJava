package LinkedList;

import Utils.ListNode;

public class RotateRight {
    // 右旋 k 位 单链表
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = k%len;
        if (k == 0) return head;
        ListNode index = head;
        for (int i = 0; i < len - k; i++) {
            head = head.next;
        }
        tail.next = index;
        while (index.next != head){
            index = index.next;
        }
        index.next = null;
        return head;
    }
}
