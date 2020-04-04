package StackAndQueue;

import java.util.Arrays;

public class DesignStackByArray {
    /**
     * 使用数组设计一个固定大小的stack
     * index 表示栈尾索引
     */
    private Integer[] data;
    private Integer index = -1;//栈尾

    public DesignStackByArray(int len) {
        this.data = new Integer[len];
    }

    public void push(int number){
        if (index == data.length - 1)return;
        data[++index] = number;
    }

    public Integer pop(){
        if (isEmpty()){
            return null;
        }
        return data[index--];
    }

    public boolean isEmpty(){
        return index == -1? true: false;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "null";
        StringBuffer res = new StringBuffer();
        res.append("{");
        for (int i = 0; i <= index ; i++) {
            res.append(" " + data[i]);
        }
        res.append(" }");
        return res.toString();
    }
}
