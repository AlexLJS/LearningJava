package Tencent50;

import Utils.TreeNode;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return judge(root,root);
    }
    public static boolean judge(TreeNode p , TreeNode q){
        if (p == null && q == null) {
            return true;
        } else  if ( p != null && q != null && p.val == q.val){
            return judge(p.left,q.right) && judge(p.right,q.left);
        }else{ return false;}
    }
}
