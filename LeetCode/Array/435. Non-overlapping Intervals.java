// https://leetcode.com/problems/non-overlapping-intervals/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        if(intervals == null || intervals.length == 0)
            return count;
        
        Arrays.sort(intervals, (i1, i2) -> {return(i1[1] - i2[1]);});
        
        int end = intervals[0][0];
        
        for(int[] interval: intervals){
            if(interval[0] < end)
                count++;
            else
                end = interval[1];
        }
        
        return count;
    }
}

/**
 * 1. sort the intervals based on the eariest end time
 * 2. see if there are any overlapping intervals and remove them all
 * 3. increase the end if it doesnot overlap
 * 
 * We're sorting acc to end time because all the below 3 options fail:
 * 
 * 1. if we sort acc to start time:
 * [.........]
 *    [....][...]
 * here, we would be removing the bottom 2 instead of the top 1
 * 
 * 2. if we sort acc to minimum interval length:
 *        [...]
 * [........][.....]
 * here, we would be removing 2 in the bottom (largest) instead of top 1
 * 
 * 3. 
 */