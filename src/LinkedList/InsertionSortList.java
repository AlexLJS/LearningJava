package LinkedList;

import Utils.ListNode;

public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode index = head;
        while (index != null && index.next != null){
            if ( index.value > index.next.value ){
                ListNode tempi = head;
                ListNode tempj = head.next;
                while (tempj.value < index.next.value){
                    tempi = tempj;
                    tempj = tempi.next;
                }
                ListNode temp = index.next;
                index.next = temp.next;
                temp.next = tempj;
                tempi.next = temp;
            }
            index = index.next;
        }
        return head;
    }
}
