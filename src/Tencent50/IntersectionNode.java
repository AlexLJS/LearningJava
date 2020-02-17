package Tencent50;

import utils.ListNode;

/*
* 相交链表  ：
* 不要想太多 ，草 ， 指针第二次 均为 null 时候直接 break 循环了 return null。
* 唉
*  */
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode index1 = headA;
        ListNode index2 = headB;

        while ( index1 != index2){
            index1 = index1 == null ? headB : index1.next;
            index2 = index2 == null ? headA : index2.next;
        }
        return index1;
    }
}
