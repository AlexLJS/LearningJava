package LinkedList;

import Utils.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * 单链表删除问题汇总：
 * （找到父节点）
 * 1、删除指定值的节点
 * 都是遍历删除O(N) , 用容器收集节点，再重新连接，O(N)空间复杂度，略。
 * 遍历删，O(1)空间复杂度。
 * 2、删除重复节点
 * 使用哈希表（set也一样）
 * 3、一种失败的删除方式
 * 不给head节点如何删除已知节点？（不放代码了，答案：不能）
 * 通过修改value：将要删除节点的值改成下一个node的值，实际项目中会出现问题
 * 4、删除列表中间节点（a/b处的节点）
 * 双指针。二倍速滑动， high.next 判断奇偶
 * 或者，遍历一遍得出length，再遍历删节点。
 * 时间复杂度都是O(N)
 */
public class RemoveQuestions {
    public ListNode removeValue(ListNode head , int value){
        while (head != null && head.value == value){
            head = head.next;
        }

        ListNode cur = head;
        ListNode next;

        while (cur != null){
            next = cur.next;
            if (next != null && next.value == value){
                cur.next = next.next;
            }
            cur = cur.next;
        }
        return head;
    }
    public ListNode removeSameNodes(ListNode head){
        Set<Integer> tempSet = new HashSet<>();
        ListNode cur = head;
        tempSet.add(head.value);//至少有一个元素，移除的cur.next

        while (cur != null && cur.next != null){
            if (tempSet.contains(cur.next.value)){
                cur.next = cur.next.next;
            }else {
                tempSet.add(cur.next.value);
            }
            cur = cur.next;
            //System.out.println(tempSet);
        }
        return head;
    }
    public ListNode removeMidNode(ListNode head){
        //偶数默认移除中间的子节点，少写几个字母
        //若是移除父节点，需要判断 high.next.next ？ null
        ListNode pre = head;
        ListNode low = head;
        ListNode high = head;

        while (true){
            if (high == null) {
                pre.next = low.next;
                break;
            }
            if (high.next == null) {
                pre.next = low.next;
                break;
            }else {
                pre = low;
                low = low.next;
                high = high.next.next;
            }
        }
        return head;
    }
}
