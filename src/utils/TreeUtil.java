package Utils;

import java.util.Queue;

public class TreeUtil {
    /**
     * 二叉树工具 ： 生成树， 打印树
     */
    //随机生成完全二叉树 ， 参考数组实现堆
    public TreeNode RandomCreateTree(int len, int[] range){
        TreeNode head = new TreeNode((int) (Math.random()*(range[1] - range[0])) + range[0]);

        TreeNode[] treeNodes = new TreeNode[len];
        treeNodes[0] = head;
        for (int i = 1; i < len ; i++) {
            treeNodes[i] =  new TreeNode((int) (Math.random()*(range[1] - range[0])) + range[0]);
        }
        for (int i = len - 1; i > 0; i--) {
            TreeNode father = treeNodes[(i-1)/2];
            if (father.right == null){
                father.right = treeNodes[i];
            }else if (father.left == null){
                father.left = treeNodes[i];
            }
        }
        return head;
    }

    // 可视化 print tree
    public void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
