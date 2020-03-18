package Utils;


import java.util.Random;

/**
 * 随机样本产生器：
 * array 、binaryTree
 */
public class RandomSampleGenerator {
    public static int[] getArray(int len, int from, int to){
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = from + (int)(Math.random() * (to - from));
        }
        return array;
    }
    // 随机生成 节点数 len ， 数据范围 [from,to)的随机二叉树
    public static TreeNode getBinaryTree(int len, int from, int to){
        Random r = new Random();
        TreeNode head = new TreeNode(to + r.nextInt(to - from));

        createBinaryTree(len, 1, head, from, to);
        return head;
    }
    private static void createBinaryTree(int len, int current, TreeNode head, int from, int to){
        if (current >= len) return ;

        createBinaryTree(len,++current,head.left,from,to);
        createBinaryTree(len,++current,head.right,from,to);

        Random r = new Random();
        head.left = new TreeNode(to + r.nextInt(to - from));
        head.right = new TreeNode(to + r.nextInt(to - from));
    }
}
