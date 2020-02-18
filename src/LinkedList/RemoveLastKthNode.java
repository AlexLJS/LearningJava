package LinkedList;

import Utils.ListNode;



/**
 * 题目：
 * 单链表删除倒数第k个节点
 * 思路：
 * 在于如何确定倒数第k个节点，在无法知晓链表长度的情况下。
 * 使用双指针l，l+k，指针间隔k。l+k 到了末尾，删除l元素。
 * 书中给了一个"更算法的算法"：
 * 调整k值，每次向后推一个元素，k就减1（最后k可能> < = 0,三种情况）。
 * 如果k是负数，再从头过一遍链表，每次k+1，移除k为0时的元素。
 * 移除倒数第k个元素，就是正数n-k，计数层面链表相当于一个闭环。
 * O(N) O(1)
 * 思考：
 * 单链表改为双链表？
 */
public class RemoveLastKthNode {
    public ListNode function1(ListNode head , int k){
        //还需要一些边界判断，略。主要在function2
        ListNode low = head;
        ListNode high = low;
        for (int i = 0;i <= k;i++){//high 多走一步，得到倒数k+1
            System.out.println(high.value);
            high = high.next;
        }
        while (high != null){
            high = high.next;
            low = low.next;
        }
        return removeNextNode(head,low);
    }
    public ListNode function2(ListNode head , int k){
        if (head == null || k < 1)
            return head;
        ListNode cur = head;
        while (cur != null){
            k--;
            cur = cur.next;
        }
        if (k == 0)//头节点就是倒数第k个节点
            head = head.next;
        if (k < 0){//从新从头开始每次下滑一个节点k再加一
            cur = head;
            while (++k != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
    private static ListNode removeNextNode(ListNode head , ListNode pre){
        //移除一个节点，需要找到前一个节点
        pre.next = pre.next.next;
        return head;
    }
}
