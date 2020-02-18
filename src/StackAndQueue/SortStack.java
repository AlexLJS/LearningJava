package StackAndQueue;

import java.util.Stack;

/**
 * 题目：用一个stack 来从小到大（栈顶）排序另一个stack。要求不用额外的数据结构，
 * 可以申请额外的空间不能使用额外的stack
 * 思路：使用一个额外的变量存储，即将放入 排序栈的元素。
 * 如果 排序栈的元素比存储即将放入的元素小，折回被排序栈。
 *
 * 标准答案：
 */
public class SortStack {
    public void sortMethod(Stack<Integer> target){
        Stack<Integer> assist = new Stack<>();
        int temp;

        while (!target.isEmpty()){
            temp = target.pop();
            if (!assist.isEmpty()){
                if (temp > assist.peek()){
                    target.push(assist.pop());
                    assist.push(temp);
                    continue;
                }
                if (temp <= assist.peek()){
                    assist.push(temp);
                }
            }else {
                assist.push(temp);
            }
        }
        while (!assist.isEmpty()){
            target.push(assist.pop());
        }
    }
}
