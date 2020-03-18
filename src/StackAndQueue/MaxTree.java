package StackAndQueue;

/**
 * 题目：
 * 定义二叉树的节点如下：
 * public class TreeNode {
 *     public int value;
 *     public TreeNode left;
 *     public TreeNode right;
 *
 *     public MaxTreeNode(int data){
 *         this.value = data;
 *     }
 * }
 * 要求：给定一个没有重复元素的数组，要求返回一个二叉树，值最大的节点都是树的头。
 * 数组的长度为N ， 算法的时间复杂度O(N) 空间复杂度O(N)
 * 思路：首先这棵树是不确定的，只是保证最大的是头节点就行，只是苛刻限制了时空复杂度。
 * 算法：寻找父节点，每个数的父节点左边第一个比它大的数和右边第一比它大的数，二者中最小的。
 * 算法证明：（反证法）
 * 要点在"会否有多个头，产生森林。会否有多个孩子，不是二叉树。"
 * （尽管node是二叉树，如果指向错误，会丢失数组数据）
 * 数组只有一个最大值，肯定都会指向这个最大值；
 * 假设一个头被三个节点指向，三个节点中最小的必然与我们算法矛盾（左右大值中较小的），
 * 它应该指向它的兄弟节点（比假设的头节点小）。
 */
public class MaxTree {
}
