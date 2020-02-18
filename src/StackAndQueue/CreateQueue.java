package StackAndQueue;


import java.util.Stack;

/**
 * 用两个stack模拟一个queue ， 实现基本操作 offer peek poll
 *
 * 我的思路： 一个进 ， 一个出 。 元素只放在一个stack中，
 * 每次操作之前，将元素放在一个stack中，转换一下顺序。
 * 进在末尾，出在头。
 */
public class CreateQueue {
    private Stack<Integer> inputStack ;
    private Stack<Integer> outputStack ;

    public CreateQueue(){
        this.inputStack = new Stack<>();
        this.outputStack = new Stack<>();
    }

    public boolean offer(int element){
        if (inputStack.isEmpty() && outputStack.isEmpty()){
            inputStack.push(element);
            return true;
        }
        if (!outputStack.isEmpty()){
            while (outputStack.isEmpty()){
                inputStack.push(outputStack.pop());
            }
            inputStack.push(element);
            return true;
        }

        return false;
    }
    public int poll(){
        if (inputStack.isEmpty() && outputStack.isEmpty()){
            return -996;
        }
        if (outputStack.isEmpty()){
            while (inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
            return outputStack.pop();
        }
        if (inputStack.isEmpty()){
            return outputStack.pop();
        }
        return -996;
    }
    public int peek(){
        if (inputStack.isEmpty() && outputStack.isEmpty()){
            return -996;
        }
        if (outputStack.isEmpty()){
            while (inputStack.isEmpty()){
                outputStack.push(inputStack.pop());
            }
            return outputStack.peek();
        }
        if (inputStack.isEmpty()){
            return outputStack.peek();
        }
        return -996;
    }
}
