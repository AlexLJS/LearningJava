package Tencent50;

import Utils.ListNode;

public class DeleteNode {
    public void deleteNode(ListNode node) {
        node.value = node.next.value;
        node.next = node.next.next;
    }
}
