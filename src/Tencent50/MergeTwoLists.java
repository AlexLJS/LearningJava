package Tencent50;

import utils.ListNode;

public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode index = res;
        while (l1 != null  && l2 != null){
            if (l1.val <= l2.val){
                index.next = l1;
                l1 = l1.next;
            }else {
                index.next = l2;
                l2 = l2.next;
            }
            index = index.next;
        }

        if (l1 == null && l2 != null) {
            index.next = l2;
        }else if (l2 == null && l1 != null){
            index.next = l1;
        }
        return res.next;
    }


}
