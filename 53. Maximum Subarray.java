// https://leetcode.com/problems/maximum-subarray/

class Solution5 {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int curSum = 0;
        for(int i=0; i<nums.length; i++){
            curSum += nums[i];
            maxSum = Math.max(maxSum, curSum);
            curSum = Math.max(curSum, 0);
        }
        return maxSum;
    }
}