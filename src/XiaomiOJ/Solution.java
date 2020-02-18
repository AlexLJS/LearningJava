package XiaomiOJ;

import java.util.*;

public class Solution {
    public static int answer14(String inputString){
        String[] ary = inputString.split(" ")[0].split(",");
        int ele = Integer.valueOf(inputString.split(" ")[1]);

        int head = Integer.valueOf(ary[0]);
        int tail = Integer.valueOf(ary[ary.length - 1]);
        int index = 0;

        if (head > ele && tail < ele) {
            return -1;
        }else if (head <= ele) {
            while (Integer.valueOf(ary[index]) != ele) {
                if (Integer.valueOf(ary[index]) > Integer.valueOf(ary[index + 1]))
                    return -1;
                index++;
            }
            return index;
        }else {//if (tail >= ele)
            index = ary.length - 1;
            while (Integer.valueOf(ary[index]) != ele) {
                if (Integer.valueOf(ary[index]) < Integer.valueOf(ary[index - 1]))
                    return -1;
                index--;
            }
            return index;
        }
    }
    //--------------13-------------
    public static int[] answer13(String inputString){
        String[] ary = inputString.split(" ")[0].split(",");
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int index = 0; index < ary.length; index++){
            if (map.containsKey(Integer.valueOf(ary[index]))){
                map.put(Integer.valueOf(ary[index]) , map.get(Integer.valueOf(ary[index])) + 1);
            }else {
                map.put(Integer.valueOf(ary[index]), 1);
            }
        }
        int k = Integer.valueOf(inputString.split(" ")[1]);
        int[] heap = new int[k];
        int index = 0;
        for (int key : map.keySet()
             ) {
            if (index != k){
                //heap 没满，在heap尾插入元素，维护一个小顶堆顺序
                //通过不断与父节点比较大小（尾插入）
                heap[index] = key;
                heapInsert(heap, index++, map);//复用index， 最终 index == k
            }else {
                if (map.get(key) > map.get(heap[0])){
                    heap[0] = key;//小顶堆按照出现频率排序，移除堆顶出现频率最低的元素
                    //再调整堆的结构（头插入）
                    heapify(heap,0, k, map);
                }
            }
        }
        //再调整堆为输出顺序 ， 将heap倒置
        for (int i = index - 1; i > 0; i--){
            swap(heap, 0, i);
            heapify(heap, 0, i, map);
        }
        //相同频率，数值小的在前
        for (int i = 0; i < k - 1; i++){
            if (map.get(heap[i]) == map.get(heap[i + 1]) && heap[i] > heap[i+1]){
                swap(heap, i, i + 1);
            }
        }
        return heap;
    }
    public static void heapInsert(int[] heap, int index, HashMap<Integer,Integer> map){
        while (index != 0){
            int parent = (index - 1)/2;
            if (map.get(heap[index]) < map.get(heap[parent])){
                swap(heap , index, parent);
                index = parent;//index向堆顶移动
            }else {
                break;
            }
        }
    }
    public static void swap(int[] heap, int indexA, int indexB){
        int temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
    }
    public static void heapify(int[] heap, int index, int heapSize, HashMap<Integer,Integer> map){
        //出现频率高的在堆中位置不重要，但需要将频率最低的放在堆顶。
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int smallest = index;
        while (left < heapSize){
            if (map.get(heap[left]) < map.get(heap[smallest])){
                smallest = left;
            }
            if (right < heapSize && map.get(heap[right]) < map.get(heap[smallest])){
                smallest = right;
            }
            if (smallest != index){
                swap(heap, index, smallest);
            }else {
                break;
            }
            index = smallest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }
    //--------------16-------------
    public static String fourCal(String inputString){
        int res = 0;
        String[] inputArr = inputString.split(" ");
        Stack<Integer> value = new Stack<>();
        Stack<String> sign = new Stack<>();

        for (int index = 0; index < inputArr.length; index++){
            if (inputArr[index].equals("+") || inputArr[index].equals("-")){
                sign.push(inputArr[index]);
            }else if (inputArr[index].equals("*")){
                value.push(value.pop() * Integer.parseInt(inputArr[++index]));
            }else if (inputArr[index].equals("/")){
                if (inputArr[index + 1].equals("0"))
                    return "err";
                value.push(value.pop() / Integer.parseInt(inputArr[++index]));
            }else {
                value.push(Integer.parseInt(inputArr[index]));
            }
        }
        while (!value.empty()){
            int a ;
            if (!sign.empty()){
                a = sign.pop().equals("-")? - value.pop() : value.pop();
                res += a;
            } else {
                res += value.pop();
            }
        }
        return String.valueOf(res);
    }
    //--------------15-------------
    public static int answer15(String inputString){
        String[] inputArr = inputString.split(",");
        HashMap<Integer,Integer> map = new HashMap<>();//element , count
        HashMap<Integer,HashSet> res = new HashMap<>();// result

        for (String ele: inputArr
             ) {
            if (map.containsKey(Integer.valueOf(ele))){
                map.put(Integer.valueOf(ele) , map.get(Integer.valueOf(ele)) + 1);
            }else {
                map.put(Integer.valueOf(ele) , 1);
            }
        }

        for (int index = 0; index < inputArr.length; index++){
            int a = Integer.valueOf(inputArr[index]);
            map.put(a , map.get(a) - 1);
            for (int b : map.keySet()
                 ) {
                if (map.get(b) != 0) {
                    map.put(b, map.get(b) - 1);
                    // c = -a -b
                    if (map.containsKey(-a - b) && map.get(-a - b) != 0) {
                        statistic(res, a, b, -a - b);
                    }
                    map.put(b, map.get(b) + 1);
                }
            }
            map.put(a , map.get(a) + 1);
        }
        int count = 0;
        for (int ele : res.keySet()
             ) {
            count += res.get(ele).size();
        }
        return count;
    }

    public static HashMap<Integer,HashSet> statistic(HashMap<Integer,HashSet> threeTuple ,
                                int a, int b, int c){
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        if (threeTuple.containsKey(min)){
            threeTuple.get(min).add(max);
        }else {
            HashSet newSet = new HashSet();
            newSet.add(max);
            threeTuple.put(min,newSet);
        }
        return threeTuple;
    }
    //--------------30--------------

    public static Long answer30(String inputString){
        long res = 0;
        long input = Long.valueOf(inputString);
        for(int i = 31,k = 0;i >= 0; i--,k++) {
            //System.out.print(input >>> i & 1);
            long temp =  (input >>> i & 1) * (long) Math.pow(2,k);
            //System.out.println(k + ":" + (long)Math.pow(2,k));
            res += temp;
        }
        return res < 0? res + 1:res ;
    }
}
