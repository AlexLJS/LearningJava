import BinaryTree.SerializeTree;
import BinaryTree.TravelTree;
import Utils.TreeNode;
import Utils.TreeUtil;


public class Test {
    public static void main(String[] args) {
        TreeUtil tu = new TreeUtil();
        SerializeTree st = new SerializeTree();
        TreeNode head = tu.RandomCreateTree(10, new int[]{1,9});
        System.out.println(st.levelSerialize(head));
        tu.printTree(head);


    }
}
