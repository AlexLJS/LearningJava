package LinkedList;

import Utils.ListNode;

/**
 * 题目：
 * 反转单链表和双边链表。
 * 思路：
 * pre head next
 * 思考：
 * java ，所谓的没有指针 会对算法的理解产生误导
 * 却对项目开发十分有利，引用 即 指针，不允许直接操作地址，完成释放内存或者修改地址。
 * 对于引用类型变量，"变量是容器"这个概念不完全正确，只是地址的容器。
 * 对于算法的理解，还是将"容器""指针"分开考虑更易理解。
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;//对于next指向放在循环体里，有效避免最后一个节点判断
        while (head != null){
            next = head.next;//如果写成return head方法，head == null时，head.next没有指向
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;//返回pre减少尾部判断
    }
}
