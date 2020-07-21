// https://leetcode.com/problems/minimum-time-visiting-all-points/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
      if(points.length == 0) return 0;
      
      int minTime = 0;
      
      for(int i = 0; i < points.length - 1; i++){
        int diff1 = Math.abs(points[i+1][0] - points[i][0]);
        int diff2 = Math.abs(points[i+1][1] - points[i][1]);
        
        minTime += Math.max(diff1, diff2);
      }
      
      return minTime;
      
    }
}