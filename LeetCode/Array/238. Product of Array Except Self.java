// https://leetcode.com/problems/product-of-array-except-self/

class Solution4 {
    public int[] productExceptSelf(int[] nums) {
        // int[] output = new int[nums.length];
        // for(int i=0; i<nums.length; i++){
        //     int product =1;
        //     for(int j=0; j< nums.length; j++){
        //         if(i!=j)
        //             product = product*nums[j];
        //     }
        //     output[i]=product;
        // }
        // return output;
        int[] output = new int[nums.length];
        int[] Left = new int[nums.length];
        int[] Right = new int[nums.length];
        Left[0]=1;
        for(int i=1; i<nums.length; i++){
            Left[i] = nums[i-1] * Left[i-1];
        }
        Right[nums.length-1] = 1;
        output[nums.length-1] = Left[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            Right[i]= nums[i+1]*Right[i+1];
            output[i]=Right[i]*Left[i];
        }
        return output;
    }
}