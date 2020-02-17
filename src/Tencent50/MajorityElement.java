package Tencent50;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        for (int i: nums
             ) {
            if (count.containsKey(i)){
                int cur = count.get(i);
                count.put(i,cur+1);
                if (cur+1 > nums.length/2){
                    return i;
                }
            }else {
                count.put(i,1);
            }
        }
        return nums[0];
    }
}
