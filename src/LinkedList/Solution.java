package LinkedList;

import Utils.ListNode;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(head));

        while (head != null){
            System.out.print(head.value + "->");
            head = head.next;
        }

    }


}
