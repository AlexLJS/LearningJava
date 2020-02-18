package LinkedList;

import Utils.ListNode;

/**
 * 合并两个有序单链表：
 * 必会基础题没啥好分析的
 * 要求：O(M+N) O(1)
 *
 * 1、选小的当head ， cur 将返回的head的尾巴，与head1 和head2中较小的连起来。
 * 2、左神书里的代码，写的很绕：采用链表节点插入的思路，list1作为被插入链表，
 * list2的节点只要比list1小就插在cur1后面，cur1不动。pre指在cur1，表示最小值，
 * 实际上是 pre cur2 next ， 完成插入操作。（我觉得这段代码一般）
 */
public class MergeLists {
    public ListNode merge(ListNode head1 , ListNode head2){
//        if (head1 == null)
//            return head2;
//        if (head2 == null)
//            return head1;
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;

        ListNode head = (head1.value <= head2.value ? head1 : head2);
        head1 = (head == head1 ? head1.next : head1);
        head2 = (head == head2 ? head2.next : head2);
        ListNode cur = head;

        while (head1 != null || head2 != null){
            if (head1 == null){
                cur.next = head2;
                break;
            }else if (head2 == null){
                cur.next = head1;
                break;
            }else {
                if (head1.value <= head2.value){
                    cur.next = head1;
                    head1 = head1.next;
                }else {
                    cur.next = head2;
                    head2 = head2.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
    public ListNode mergePro(ListNode head1 , ListNode head2){
        if (head1 == null || head2 == null)
            return head1 == null ? head2 : head1;
        ListNode head = (head1.value < head2.value ? head1 : head2);
        ListNode cur1 = (head == head1 ? head1 : head2);
        ListNode cur2 = (head == head1 ? head2 : head1);
        ListNode pre = new ListNode(0);
        ListNode next = null;
        while (cur1 != null && cur2 != null){
            if (cur1.value <= cur2.value){
                pre = cur1;
                cur1 = cur1.next;
            }else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }

}
