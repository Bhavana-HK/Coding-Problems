// https://leetcode.com/problems/group-anagrams/

import java.util.*;

class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] charCount = new char[26];
            for(char c : word.toCharArray() )
                charCount[c - 'a']++;
            String sortedString = String.valueOf(charCount);
            if (!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList<>());
            map.get(sortedString).add(word);
        }

        return new ArrayList<> (map.values());
    }

    public static void main(String[] args) {
        String[] input = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(input));
    }
}