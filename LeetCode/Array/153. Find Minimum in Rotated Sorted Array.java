// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] nums) {
        int prev = nums[0];
        if(nums.length == 1)
            return prev;
        int next = nums[1];
        for(int i=1;i<nums.length;i++){
            if(prev>next) return next;
            if(i+1 == nums.length) return nums[0];
            prev = next;
            next = nums[i+1];
        }
        return 0;
    }
}