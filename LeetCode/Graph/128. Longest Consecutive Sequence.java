// https://leetcode.com/problems/longest-consecutive-sequence/

class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet();
        
        for(int num : nums)
            set.add(num);
        
        for(int i=0; i<nums.length; i++){
            //check if its the start of a sequence
            int count = 1;
            if(! set.contains(nums[i]-1)){
                int value = nums[i];
                while(set.contains(++value))
                    count++;
            }
            if(count > result)
                result = count;
        }
        
        return result;
    }
}