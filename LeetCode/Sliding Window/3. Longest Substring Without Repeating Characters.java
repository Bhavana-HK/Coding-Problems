// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0, start = 0, len = s.length();
        int[] lastIndex = new int[256];
        int[] count = new int[256];
        
        for(int end = 0; end < len; end++){
            int c = s.charAt(end);

            if(++count[c] > 1 && lastIndex[c] >= start){
                int newStart = lastIndex[c] + 1;
                lastIndex[c] = end;

                for(int j = start; j < newStart; j++)
                    --count[s.charAt(j)];
                start = newStart;
            }else{
                ++count[c];
                lastIndex[c] = end;
                maxLength = Math.max(maxLength, end - start + 1);
            }
        }
        
        return maxLength;
    }
}