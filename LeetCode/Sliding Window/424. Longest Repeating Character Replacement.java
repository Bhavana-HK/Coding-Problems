// https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;

        // count keeps track of no. of times a charecter has appeared inside the window
        // window size = end-start+1
        // maxCount = the max of number of times a charecter has appeared in the window
        // (XXXYZ) -> 3
        // when end-start+1 == maxCount -> the window is made of 1 type of charecter
        // (AAAA)
        // when end-start+1 > maxCount -> the window has atleast 2 diffrent charecters
        // (AABA)
        // when end-start+1 - maxCount > k -> the window has more number of different
        // charecters than that can be replaced. so we need to shrink the window. we do
        // that by sliding to the right.
        // we're expanding the end step by step and if at any place, the constaint does
        // not meet, we start shrinking it.
        
        // The initial step is to extend the window to its limit, that is, the longest
        // we can get to with maximum number of modifications. Until then the variable
        // start will remain at 0.
        // Then as end increase, the whole substring from 0 to end will violate the
        // rule, so we need to update start accordingly (slide the window). We move
        // start to the right until the whole string satisfy the constraint again. Then
        // each time we reach such situation, we update our max length.

        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            if (end - start + 1 - maxCount > k) {
                --count[s.charAt(start) - 'A'];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}