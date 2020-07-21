import java.util.*;

class Solution {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int no : nums){
            if(set.contains(no))
                return true;
            set.add(no);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{2,4,5,8,2}));
    }
}