package Tencent50;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                   if (nums[i] + nums[j] + nums[k] == 0 ){
                       List<Integer> ele = new ArrayList<Integer>();
                       ele.add(nums[i]);
                       ele.add(nums[j]);
                       ele.add(nums[k]);
                       if (set.contains( nums[i]) && set.contains( nums[j]) && set.contains( nums[k]) ) continue;
                       set.add(nums[i]);
                       set.add(nums[j]);
                       set.add(nums[k]);
                       res.add(ele);
                   }
                }
            }
        }

        return res;
    }
}
