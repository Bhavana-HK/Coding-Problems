// https://leetcode.com/problems/longest-increasing-subsequence/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] maxLength = new int[nums.length];
        Arrays.fill(maxLength, 1);
        
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i] && maxLength[i] < maxLength[j]+1){
                    maxLength[i] = maxLength[j]+1;
                }
            }
        }
        
        // System.out.println(Arrays.toString(maxLength));
        
        int max = 0;
        for(int i=0; i<nums.length; i++)
            if(max < maxLength[i])
                max = maxLength[i];
        
        return max;
    }
}