package StackAndQueue;

import java.util.LinkedList;

/**
 * 题目： 生成窗口最大值数组，给定一个数组，一个滑动窗口长度，
 * 要求返回一个窗口滑动的过程中，的最大值的数组。
 * 思路：关键在于算法的时间复杂度，要不要每次都遍历整个窗口。
 * O(N)算法要好过O(M*N)。
 * 利用双向队列(LinkedList)，实现对滑动数组最大值的查找，具体思路：
 * 队列头只弹出最大值，队列尾进元素，队尾进大元素时，队尾弹出比之小的元素。
 * 保障队列头永远是最大值或者过期元素。
 *
 * 启发： 用是stack 来寻找最值/单侧最值。
 */
public class MaxWindowAry {
    private int[] arr;
    private int windowLen;
    private int[] res;
    private LinkedList<Integer> qmax = new LinkedList<Integer>();

    public MaxWindowAry(int w , int[] arr){
        int n = arr.length;
        this.arr = arr;
        this.windowLen = w;
        this.res = new int[n-w+1];
    }

    public int[] getMaxWindow(){
        for ( int index = 0 ; index < arr.length ; index++ ){
            if ( qmax.isEmpty() ){
                qmax.add(arr[index]);
                continue;
            }
            if ( arr[index] <= qmax.peekLast() ){
                qmax.addLast(arr[index]);
                if ( qmax.size() > windowLen )
                    qmax.pollFirst();
            }
            if ( arr[index] > qmax.peekLast() ){
                while ( !qmax.isEmpty() && qmax.peekFirst() <= arr[index] ){
                    qmax.pollFirst();
                }
                qmax.addLast(arr[index]);
            }
            if ( index >= windowLen-1 ){
                res[index+1-windowLen] = qmax.peekFirst();
            }
        }
        return res;
    }

}
