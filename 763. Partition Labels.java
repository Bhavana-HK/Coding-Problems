// https://leetcode.com/problems/partition-labels/

import java.util.*;

class PartitionLables {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastIndex[S.charAt(i) - 'a'] = i;

        int i = 0;
        while (i < S.length()) {
            int end = lastIndex[S.charAt(i)-'a'];
            int j = i + 1;
            while (j <= end) {
                end = Math.max(end, lastIndex[S.charAt(j++)-'a']);
            }
            ans.add(end - i + 1);
            i = end + 1;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new PartitionLables().partitionLabels("ababcbacadefegdehijhklij"));
    }
}