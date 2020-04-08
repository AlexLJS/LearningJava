package BinaryTree;

import Utils.TreeNode;

import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
    /**
     * 序列化（持久化存储）和反序列化：
     *
     * 1、
     * 序列化：仅比遍历二叉树多的标记出 null 节点 ， 存成是String，例 ： 先序序列化
     * 当然 两行代码也可以写出：
     * {
     *     if(root==null) return "#";
     *     return root.val + "_"+ preSerialize(root.left)+"_"+ preSerialize(root.right);
     * }
     *
     * 反序列化
     * 同理使用递归函数 先序遍历重建这个树
     *
     * 2、
     * 层序遍历 序列化与反序列化
     */
    public String preSerialize(TreeNode head){
        StringBuilder str = new StringBuilder();
        preRe(head, str);
        return str.toString();
    }
    private void preRe(TreeNode head, StringBuilder res){
        if (head == null) {
            res.append("#" + "_");
            return;
        }
        res.append(head.val + "_");
        preRe(head.left, res);
        preRe(head.right, res);
    }
    //反序列化

    public TreeNode dePreSerialize(String input){
        String[] value = input.split("_");
        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < value.length; i++) {
            queue.add(value[i]);
        }
        return dePreRe(queue);
    }
    private static TreeNode dePreRe(Queue<String> queue){
        String cur = queue.poll();
        if (cur.equals("#")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(cur));
        head.left = dePreRe(queue);
        head.right = dePreRe(queue);
        return head;
    }

    // 层序
    public String levelSerialize(TreeNode head){
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            TreeNode cur = queue.peek();
            if (cur == null) {
                queue.poll();
                s.append("#" + "_");
                continue;
            }
            if (cur.left != null){
                queue.add(cur.left);
            }else {
                queue.add(null);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }else {
                queue.add(null);
            }
            s.append(queue.poll().val + "_");

        }
        return s.toString();
    }
}
