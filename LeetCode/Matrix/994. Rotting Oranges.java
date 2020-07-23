// https://leetcode.com/problems/rotting-oranges/

import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<>();
        Set<String> rotten = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++)
                if( grid[i][j] == 1)
                    fresh.add("" + i + j);
                else if(grid[i][j] == 2)
                    rotten.add("" + i + j);
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0;
        while(fresh.size() > 0){
            Set<String> infected = new HashSet<>();
            
            for(String coordinate: rotten){
                int i = coordinate.charAt(0) - '0';
                int j = coordinate.charAt(1) - '0';
                
                for( int[] direction: directions){
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if(fresh.contains("" + nextI + nextJ)){
                        fresh.remove("" + nextI + nextJ);
                        infected.add("" + nextI + nextJ);
                    }
                }
            }
            
            if(rotten.size() == 0)
                return -1;
            
            rotten = infected;
            minutes++;
                
        }
        
        return minutes;
    }

    public int orangesRotting2(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]==2)
                    rotten.offer(new int[]{i, j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int minutes = 0;
        
        while(fresh > 0){
            Queue<int[]> infected = new LinkedList<>();
            
            for(int[] coordinate: rotten){
                for( int[] direction: directions){
                    int i = coordinate[0] + direction[0];
                    int j = coordinate[1] + direction[1];
                    if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j]==0 || grid[i][j] == 2)
                        continue;
                    fresh--;
                    grid[i][j]=2;
                    infected.offer(new int[]{i, j});
                }
            }
            
            if(infected.size() == 0)
                return -1;
            
            rotten = infected;
            minutes++;
                
        }
        
        return minutes;
    }
}