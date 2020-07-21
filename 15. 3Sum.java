// https://leetcode.com/problems/3sum/

import java.util.*;

class Solution6 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        // Set<List<Integer>> set = new HashSet<>();
        // for(int i=0; i< nums.length-2; i++){
        //     for(int j=i+1; j< nums.length-1; j++){
        //         int target = 0-nums[i]-nums[j];
        //         int[] numbers = Arrays.copyOfRange( nums , j+1, nums.length-1);
        //         List numList = Arrays.asList(numbers);
        //         System.out.println(numbers.toString());
        //         System.out.println(numList.toString());
                
        //         if(numList.contains(target)){
        //             List<Integer> list = new ArrayList();
        //             list.add(nums[i]);
        //             list.add(nums[j]);
        //             list.add(target);
        //             if(!set.contains(list)){
        //                 result.add(list);
        //                 set.add(list);
        //             }
        //         }
        //     }
        // }
        
        for(int i=0; i< nums.length-2; i++){
            if(i==0 || nums[i-1] != nums[i]){
                int low = i+1, high = nums.length-1, sum = 0 - nums[i];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //skip getting same results by incrementing low & decrementing high
                        while(low<high && nums[low]==nums[low+1]) low++;
                        while(low<high && nums[high]==nums[high-1]) high--;
                        low++; high--;
                    }
                    // for the next number, check if the new result is higher than expected
                    // if it is, come down the array (smaller elements cause its sorted)
                    else if(nums[low] + nums[high] > sum){
                        while(low<high && nums[high]==nums[high-1]) high--;
                        high--;
                    }
                    // otherwise, go up the array
                    else{
                        while(low<high && nums[low]==nums[low+1]) low++;
                        low++;
                    }
                }
            }
        }
        return result;
    }
}