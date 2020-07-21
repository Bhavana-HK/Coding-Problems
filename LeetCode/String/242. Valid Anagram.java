// https://leetcode.com/problems/valid-anagram/

class Solution9 {

    public static boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        int n = s.length();
        
        if(n != t.length())
            return false;
        
        for(int i=0; i<n; i++){
            letters[s.charAt(i) - 'a']++;
        }
        for(int i=0; i<n; i++){
            if(--letters[t.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isAnagram("a", "b"));
    }
}