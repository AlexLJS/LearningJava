package LinkedList;

import Utils.ListNode;

import java.util.HashMap;

/**
 * （此代码未测试）
 *
 * 链表相交问题汇总：
 * 1、是否有环， 见detectCycle
 * 2、无环单链表相交节点
 * 3、有环单链表相交节点（最为复杂）
 *
 * 当然可以 使用 hashmap 很简单 ， 空间复杂度O(1)方法：
 *
 * 记录链表长度，长链表减去二者差， 再同时遍历，即可找到入口。
 */
public class IntersectNode {
    public ListNode[] getIntersectNode(ListNode l1, ListNode l2){
        DetectCycle detect = new DetectCycle();
        //记录入环节点
        ListNode loop1 = detect.detectCycle(l1);
        ListNode loop2 = detect.detectCycle(l2);

        if (loop1 == null && loop2 == null){// l1 l2 都无环
            return new ListNode[]{diff(l1,l2,null)};
        }
        // 有环链表相交 存在三种拓扑结构：交在环上、没交在环上、不相交
        // 区分方式 ： 入环节点是否相同
        if (loop1 == loop2){//入环节点相同
            return new ListNode[]{diff(l1,l2,loop1.next)};//规避刚好交在环入口情况
        }else if (loop1 != null && loop2 != null){//入环节点不同，分两种情况 ： 都有环但不相交 ， 都有环交在环上不同节点
            ListNode index = loop1.next;
            while (index != loop1){
                if (index == loop2) return new ListNode[]{loop1,loop2};//交在环上不同节点
                index = index.next;
            }
            return null;//都有环但不相交 (在环上找了一圈，没找到loop2)
        }else {
            return null;//一个有环，一个无环，必然不相交
        }
    }
    //函数功能： 处理不同长度链表相交，返回交点
    private ListNode diff(ListNode l1, ListNode l2, ListNode end){
        HashMap<String,Object> cache1 = getLen(l1,end);
        HashMap<String,Object> cache2 = getLen(l2,end);

        if (cache1.get("tail") != cache2.get("tail")) return null;
        // 先除掉多余部分
        ListNode longer = (int)cache1.get("len") > (int)cache2.get("len")?l1:l2;
        ListNode shorter = longer == l1? l2:l1;
        for (int i = 0; i < Math.abs((int)cache1.get("len") - (int)cache2.get("len")); i++) {
            longer = longer.next;
        }
        // 同时前进寻找交点
        while (longer == shorter){
            longer = longer.next;
            shorter = shorter.next;
        }
        return longer;
    }
    // 函数功能：求给定链表长度，返回长度和尾节点
    // end 控制尾节点 是否是null， 有环情况则为环入口节点
    private HashMap<String,Object> getLen(ListNode head, ListNode end){
        HashMap<String,Object> res = new HashMap<>();
        Integer len = 1;
        while (head.next != end){
            head = head.next;
            len++;
        }
        res.put("len",len);
        res.put("tail",head);
        return res;
    }
}
