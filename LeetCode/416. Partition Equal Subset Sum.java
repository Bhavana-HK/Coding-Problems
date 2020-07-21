import java.util.*;

// subset sum problem with memorization
class Solution1 {
    
    public boolean memorize(int[] nums, int start, int sum,  Map<String, Boolean> map){
        String key = start + "." + sum;
        if(map.containsKey(key)) {
            return (boolean) map.get(key);
        }
        else {
            Boolean value = false;
            if(start == nums.length && sum != 0)
                value = false;
            else if(sum < 0)
                value = false;
            else if(sum - nums[start] == 0)
                value = true;
            else
                value = memorize(nums, start+1, sum-nums[start], map) || memorize(nums, start+1, sum, map);
            map.put(key, value);
            return (boolean) value;
        }
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int num: nums)
            sum += num;
        
        if(sum % 2 != 0)
            return false;
        
        sum /= 2;
        
        Map<String, Boolean> map = new HashMap<>();
        
        return memorize(nums, 0, sum, map);
    }
}