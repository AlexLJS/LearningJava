import Utils.TreeNode;
import Utils.TreeUtil;


public class Test {
    public static void main(String[] args) {
        TreeUtil tu = new TreeUtil();
        TreeNode head = tu.RandomCreateTree(10, new int[]{1,9});

        tu.printTree(head);
    }
}
