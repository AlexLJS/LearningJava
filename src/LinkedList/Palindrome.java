package LinkedList;

import Utils.ListNode;

public class Palindrome {
    /**
     * 回文链表的判断
     * 额外空间复杂度O(1) 难
     * 思路 ： 快慢指针 + 链表逆序
     * 快慢指针停至中点，再逆序后半链表，遍历两段链表。最后还原原始数据
     *
     */
    public boolean isPalindrome(ListNode head){

        if (head.next == null || head.next.next == null)return true;

        ListNode tempHead = head;
        ListNode[] preprocess = findCutPoint(head);
        ListNode half = preprocess[0];
        ListNode tail = new ReverseList().reverseList(half.next);

        half.next = null;
        while (tail.value == tempHead.value){
            if (tail.next == null || tempHead.next == null) {
                //re
                half.next = new ReverseList().reverseList(preprocess[1]);
                return true;
            }
            tail = tail.next;
            tempHead = tempHead.next;
        }
        //re
        half.next = new ReverseList().reverseList(preprocess[1]);
        return false;
    }

    private ListNode[] findCutPoint(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null){
            if (fast.next.next == null){
                fast = fast.next;
                break;//slow 停在前半段末尾
            } else {
                fast = fast.next.next;
            }
            slow = slow.next;
        }
        return new ListNode[]{slow,fast};
    }

//    private ListNode rotate(ListNode head){
//        ListNode pre = null;
//        ListNode next = null;
//
//        while (head != null) {
//            next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }
}
