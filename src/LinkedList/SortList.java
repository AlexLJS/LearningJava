package LinkedList;

import Utils.ListNode;
//！！！！！！！！！！！！！！！！！！！！！ 搞不懂  有 bug
public class SortList {
    //nlogn 归并排序 单链表
    public ListNode sortList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        int len = 0;
        ListNode index = head;
        while (index != null) {
            index = index.next;
            len++;
        }
        for (int size = 1 ; size < len ; size <<= 1) {
            ListNode cur = dummyHead.next;
            ListNode tail = dummyHead;
            //System.out.println(cur.value);
            while (cur != null) {
                ListNode left = cur;
                ListNode right = cut(left,size);
                cur = cut(right,size);

                tail.next = merge(left,right);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummyHead.next;
    }
    //切掉 head 开始到第n个node ，return 第 n + 1 个node
    public static ListNode cut(ListNode head , int n){
        ListNode temp = head;
//        for (int i = 0; i < n-1; i++) {
//            temp = temp.next;
//        }
        while (temp!=null) {
            temp = temp.next;
            n--;
        }
        if (temp == null) return null;
        ListNode res = temp.next;
        temp.next = null;
        System.out.println(res.value);
        return res;
    }
    public static ListNode merge(ListNode l1 , ListNode l2){
        //归并合并
        ListNode dummyHead = new ListNode(0);
        ListNode point = dummyHead;
        while (l1 != null && l2 != null){
            if (l1.value < l2.value){
                point.next = l1;
                point = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                point = l2;
                l2 = l2.next;
            }
        }
        point.next = l1 == null? l2:l1;
        return dummyHead.next;
    }
}
