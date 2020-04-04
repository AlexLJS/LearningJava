package Algrorithm;

import java.text.DecimalFormat;
import java.util.HashMap;

public class MaxGap {
    /**
     * 借助桶排序思想，寻找数组排序后的临位最大差值
     * eg.
     * {4,3,1,5,7,6}
     * {1,3,4,5,6,7}
     * maxgap : 2
     *
     * n个数，n+1个桶，规避最大间隔出现在同一个桶内情况
     *
     * 注 ： 这段代码写得不好，可以不用hashmap ，也可以绕开小数
     */
    public static int maxGap(int[] arr){
        int MAX = 0;
        int max = arr[0];
        int min = arr[0];
        HashMap<Double,int[]> container = new HashMap<>();

        for (int ele: arr
             ) {
            max = Math.max(max,ele);
            min = Math.min(min,ele);
        }
        // 向下取整保留两位小数
        DecimalFormat df = new DecimalFormat("0.000");
        double interval = Math.floor(Double.valueOf(df.format((double) (max - min) / arr.length))*100)/100;
        //pre
        for (int i = 1; i < arr.length ; i++) {
            int[] content = new int[3];// flag , min , max
            content[0] = 0;
            container.put(min+i*interval,content);
        }
        container.put((double)min,new int[]{1,min,min});
        container.put(min+arr.length*interval,new int[]{1,max,max});

        //fill
        for (int i = 0; i < arr.length; i++) {
            double key = min + interval * (int)((arr[i]-min)/interval);
            if (container.get(key)[0] == 0){
                container.put(key,new int[]{1,arr[i],arr[i]});
            }else {
                int[] data = container.get(key);
                container.put(key,new int[]{1,Math.min(arr[i],data[1]),Math.max(arr[i],data[2])});
            }
        }
        int[] cache = container.get((double)min);
        MAX = cache[2] - cache[1];
        for (int i = 1; i <= arr.length ; i++) {
            int[] data = container.get(min+i*interval);
            if (data[1] == 0){
                continue;
            }else {
                MAX = Math.max(MAX , data[1]-cache[2] );
                cache = data;//缓存距离索引i最近的非空桶
            }
        }
        return MAX;
    }

    public static void main(String[] args) {
        System.out.println(maxGap(new int[]{4,3,1,5,7,6,11}));
    }
}
