package BinaryTree;

import Utils.TreeNode;

public class SearchBinaryTree {
    /**
     *搜索二叉树 ：任何二叉树的左子树节点值都比右子树节点值小 （左小右大）
     *
     * 判断搜索二叉树 ： 二叉树中序遍历的结果是依次升序的
     *
     */
    public static boolean isSearchBinaryTree(TreeNode head){
        return process(head);
    }

    public static boolean process(TreeNode head){
        if (head == null) return true;
        if (head.left != null && head.left.val > head.val) return false;
        if (head.right != null && head.val > head.right.val) return false;

        process(head.left);
        System.out.print(head.val);
        process(head.right);

        return true;
    }
}
