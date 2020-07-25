// https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length()==0)
            return "";
        
        int[] map = new int[128];
        
        for(char c: t.toCharArray())
            ++map[c];
        
        int minStart = 0, minEnd = 0, count = 0;
        int lo = 0, hi = 0, minLength = Integer.MAX_VALUE;
        
        for(hi = 0; hi < s.length(); hi++){
            if(--map[s.charAt(hi)] >= 0){
                count++;
            }
            if(count == t.length()){
                while(lo < hi && map[s.charAt(lo)] < 0){
                    ++map[s.charAt(lo)];
                    ++lo;
                }
                
                if(minLength > hi - lo + 1){
                    minLength = hi - lo + 1;
                    minStart = lo;
                    minEnd = hi + 1;
                }
            }
        }
        
        return s.substring(minStart, minEnd);
    }
}