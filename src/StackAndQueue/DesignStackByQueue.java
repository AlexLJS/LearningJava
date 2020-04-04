package StackAndQueue;

import java.util.Queue;

public class DesignStackByQueue {
    /**
     * 用队列实现栈
     * 思路 ：
     * 使用两个队列 ， 每次pop 时候留下data 队列的最后一项 ，不进入cache 队列，交换索引
     *
     */
    private Queue<Integer> data;
    private Queue<Integer> cache;

    public Integer push(Integer ele){
        data.add(ele);
        return ele;
    }
    public Integer pop(){
        while (!data.isEmpty()){
            Integer temp =  data.poll();
            if (data.isEmpty()){
                return temp;
            }else {
                cache.add(temp);
            }
        }
        change();
        return null;
    }
    //交换索引
    private void change(){
        Queue<Integer> temp = data;
        data = cache;
        cache = temp;
    }
}
