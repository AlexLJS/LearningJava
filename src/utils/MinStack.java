package Utils;

import java.util.ArrayList;

public class MinStack {
    private ArrayList<Integer> data ;
    //线性时间最小值 ， 维护一个最小值栈 。
    private ArrayList<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int x) {
        if (data.size() == 0){
            minStack.add(x);
        }else {
            minStack.add(Math.min(minStack.get(minStack.size()-1),x));
        }
        data.add(x);
    }

    public void pop() {
        data.remove(data.size()-1);
        minStack.remove(minStack.size()-1);
    }

    public int top() {
        return data.get(data.size()-1);
    }

    public int getMin() {
        return minStack.get(minStack.size() - 1);
    }
}
