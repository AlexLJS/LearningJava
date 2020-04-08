package BinaryTree;

import Utils.TreeNode;

public class JudgeBalance {
    /**
     * 平衡二叉树：
     * 任意一棵树的左子树和右子树的高度差<1
     *
     * 高度 问题 ： 递归
     *
     * "树型DP"
     *
     *
     */

    public static boolean isBalance(TreeNode head){
        return process(head).isBalance;
    }

    public static ReturnData process(TreeNode head){
        if (head == null) return new ReturnData(true, 0);
        ReturnData leftData = process(head.left);
        if (!leftData.isBalance) return new ReturnData(false,0);
        ReturnData rightData = process(head.right);
        if (!rightData.isBalance) return new ReturnData(false,0);


        if (Math.abs(leftData.level - rightData.level) > 1) return new ReturnData(false,0);
        return new ReturnData(true,Math.max(leftData.level,rightData.level) + 1 );
    }

    public static class ReturnData{
        public boolean isBalance;
        public int level;

        public ReturnData(boolean isBalance, int level) {
            this.isBalance = isBalance;
            this.level = level;
        }
    }
}
