// https://leetcode.com/problems/search-in-rotated-sorted-array/

class Solution8 {
    public int search(int[] nums, int target) {
        int i;
        if(nums.length == 0) return -1;
        for(i=0; i<nums.length-1; i++)
            if(nums[i] > nums[i+1]) break;
        int high = i;
        int low = (high + 1) < nums.length ? i+1 : 0;
        if(low != 0){
            if(target >= nums[0]) low =0;
            else high = nums.length-1;
        }
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low=mid+1;
            else if(nums[mid] > target) high=mid-1;
        }
        return -1;
    }
}