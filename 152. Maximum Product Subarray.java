// https://leetcode.com/problems/maximum-product-subarray/

class Solution7 {
    public int maxProduct(int[] nums) {
        // Initialse everything to the 1st element
        int current_max = nums[0], current_min= nums[0], maxProduct = nums[0];
        for(int i=1; i<nums.length;i++){
            // keep the current_max cause we're overwriting it 
            int temp = current_max;
            // find the max product subarray: either the number itself,
            // or the number mul w/ the max(incase its +ve) 
            // or the number mul w/ the min (incase its -ve)
            current_max = Math.max(nums[i], Math.max(nums[i]*current_max, nums[i]*current_min));
            // similarly, the smallest number possible
            current_min = Math.min(nums[i], Math.min(nums[i]*temp, nums[i]*current_min));
            maxProduct = Math.max(maxProduct, current_max);
        }
        return maxProduct;
    }
}