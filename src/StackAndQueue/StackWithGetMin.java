package StackAndQueue;

import java.util.Stack;

/*
* 设计一个 Stack 具有 getMin 功能（实时返回当前Stack中的最小值）
* 思路：
*   准备一个stack，顶端存放当前stack的最小值
* 其他：
* Stack<E> : Vector<E> 子类  Object[] -> AbstractList<E> 存数据
* 主要方法 ： pop push peek search
 */

public class StackWithGetMin {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public Stack<Integer> getDataStack() {
        return dataStack;
    }

    public int getMin(){
        if (minStack.isEmpty())
            return -996;
        return minStack.peek();
    }

    public int pop(){
        int res = dataStack.pop();
        minStack.pop();
        return res;
    }

    public int push(int element){
        if (minStack.isEmpty() && dataStack.isEmpty()) {
            minStack.push(element);
            dataStack.push(element);
        } else {
            minStack.push(Math.min(minStack.peek(),element));
            dataStack.push(element);
        }
        return element;
    }
}
