package StackAndQueue;

import java.util.Stack;

public class DesignQueueByStack {
    /**
     * 用stack结构实现队列
     * input output
     *
     * add
     * peek
     * remove
     */
    private Stack<Integer> input;
    private Stack<Integer> output;

    public DesignQueueByStack(){
        this.input = new Stack<>();
        this.output = new Stack<>();

    };

    public Integer add(Integer element){
        if (output.isEmpty()){
             input.push(element);
             return element;
        }else {
            // 利用 exchange 改写非递归 , 下同
            //exchange(output,input);
            input.push(output.pop());
            return add(element);
        }
    };
    public Integer remove(){
        if (input.isEmpty() && output.isEmpty()) return null;
        if (input.isEmpty()){
            return output.pop();
        }else {
            return output.push(input.pop());
        }
    };
    public Integer peek(){
        exchange(input,output);
        return output.peek();
    };

    private void exchange(Stack<Integer> source, Stack<Integer> dest){
        while (!source.isEmpty()){
            dest.push(source.pop());
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        exchange(input,output);
        res.append("{ ");
        Stack<Integer> temp = (Stack<Integer>) output.clone();
        while (!temp.isEmpty()){
            res.append(temp.pop() + " ");

        }
        res.append("}");
        return res.toString();
    }

}
