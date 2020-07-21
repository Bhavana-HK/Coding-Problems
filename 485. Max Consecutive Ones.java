 class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=Integer.MIN_VALUE;
        int current = 0;
        
        for(int i=0;i<nums.length;i++){
          if(nums[i]==1){
            current++;
            max = Math.max(current, max);
          }else{
            current = 0;
          }
        }
        return max;
        
      }

      public static void main(String[] args) {
          System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1,0, 1,1, 1,1 ,1}));
      }
}