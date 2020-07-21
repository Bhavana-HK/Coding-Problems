// https://leetcode.com/problems/reshape-the-matrix/

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
      if(nums.length* nums[0].length != r*c)
        return nums;
      int[][] reshaped = new int[r][c];
      int m=0, n=0;
      for(int i=0; i < nums.length; i++){
        for(int j=0; j < nums[i].length; j++){
          reshaped[m][n]=nums[i][j];
          if(n+1 == c) {
            n=0;
            m++;
          }
          else 
            n=n+1;      
        }
      }
      
      return reshaped;
    }
}