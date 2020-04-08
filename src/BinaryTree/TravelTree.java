package BinaryTree;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TravelTree {
    /**
     * 遍历二叉树 ： 前、中、后序
     * 注：
     * 递归函数会访问一个节点三次 ： 1、来到node 2、左子树完毕回到node 3、 右子树完毕回到node
     *
     *
     * 基础知识 ， 背下来
     */
    public void pre(TreeNode head){
        if (head == null) return;
        System.out.print(head + " ");
        pre(head.left);
        pre(head.right);
    }
    public void mid(TreeNode head){
        if (head == null) return;
        mid(head.left);
        System.out.print(head + " ");
        mid(head.right);
    }
    public void post(TreeNode head){
        if (head == null) return;
        post(head.left);
        post(head.right);
        System.out.print(head + " ");
    }
    // 非递归 前序遍历
    // 手动压栈 ，注意顺序问题
    public void preOrderNoRe(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                System.out.println(temp.val + " ");
                if (temp.right != null){
                    stack.push(temp.right);
                }
                if (temp.left != null){
                    stack.push(temp.left);
                }
            }
        }
        System.out.println();
    }
    // 非递归中序遍历 ，比较复杂， 需要将当前node的左边界都压栈
    // 思路 ： node 不空 指针向左孩子走 ， 空了就向右孩子走
    public void inOrderNoRe(TreeNode head){
        if (head != null){
            TreeNode temp = head;
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || temp != null){
                if (temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }else {
                    temp = stack.pop();
                    System.out.print(temp.val + " ");
                    temp = temp.right;
                }
            }
        }
        System.out.println();
    }

    // 非递归后序遍历
    // 建议改进前序遍历 ： （中左右-> 中右左 -stack-> 左右中）
    public void postOrderNoRe(TreeNode head){
        if (head != null){
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> cache = new Stack<>();

            stack.push(head);
            while (!stack.isEmpty()){
                TreeNode temp = stack.pop();
                //System.out.println(temp.val + " ");
                cache.push(temp);
                if (temp.left != null){
                    stack.push(temp.left);
                }
                if (temp.right != null){
                    stack.push(temp.right);
                }
            }
            while (!cache.isEmpty()){
                System.out.print( cache.pop().val + " ");
            }
        }
        System.out.println();
    }
    // 仅使用一个栈实现后续遍历 （待续）

    // 层序遍历
    // 借助 队列先进先出特性
    public void floorPrint(TreeNode head){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            if (queue.peek().left != null){
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null){
                queue.add(queue.peek().right);
            }
            System.out.print(queue.poll().val + " ");
        }
        System.out.println();
    }
}
