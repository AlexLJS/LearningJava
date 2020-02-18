package LinkedList;

import Utils.ListNode;

/**
 * 题目：
 * 打印两个链表的公共部分，两个链表值顺序从大到小。
 * 思路：
 * 这道题因为链表有序变得非常简单。
 * 游标大的往后推一个，直到找到相等的头，开始打印。
 * 用例：
 * 12 4 678……
 *   3 56789……
 * 思考：
 * 如果链表没有序，那么打印共同部分的时间复杂度怎样比O(M*N)小？
 */
public class PrintCommonPart {
    public void printCommonPart(ListNode head1 , ListNode head2){
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        while ( (cur1.next != null) && (cur2.next != null) ){
            if (cur1.value < cur2.value){
                cur1 = cur1.next;
            }else if (cur1.value > cur2.value){
                cur2 = cur2.next;
            }else {
                cur1 = cur1.next;
                cur2 = cur2.next;
                System.out.println(cur1.value);
            }
        }
    }
}
