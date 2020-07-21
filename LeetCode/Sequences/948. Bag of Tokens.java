// https://leetcode.com/problems/bag-of-tokens/

import java.util.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int maxPoints = 0;
        int points = 0;
        while (i <= j) {
            if (tokens[i] <= P) {
                P -= tokens[i++];
                points++;
                maxPoints = Math.max(points, maxPoints);
            } else if (points > 0) {
                points--;
                P += tokens[j--];
            } else {
                return maxPoints;
            }
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().bagOfTokensScore(new int[] { 100 }, 50));
    }
}