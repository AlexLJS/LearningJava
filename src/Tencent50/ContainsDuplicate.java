package Tencent50;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<String> set = new HashSet<String>();
        for (int ele : nums) {
            if (set.contains(String.valueOf(ele))) return true;
            set.add(String.valueOf(ele));
        }
        return false;
    }
}
